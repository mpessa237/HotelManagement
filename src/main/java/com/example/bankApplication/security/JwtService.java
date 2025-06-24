package com.example.bankApplication.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private final long jwtExpiration;
    private final String secretKey;
    public JwtService(
            @Value("${application.security.jwt.secret-key:}") String secretKey,
            @Value("${application.security.jwt.expiration:86400000}") long jwtExpiration) {
        if (secretKey.isBlank()) {
            throw new IllegalStateException("JWT secret key is not configured");
        }
        this.secretKey = secretKey;
        this.jwtExpiration = jwtExpiration;
    }

    //elle extrait le nom de l'utilisateur(subjet) depuis un token
    String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }

    //use to create the JWT (for authentication and authorization of web apps)
    private String buildToken(
            Map<String,Object> extraClaims,
            UserDetails userDetails,
            long jwtExpiration)
    {
        var authorities = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .claim("authorities",authorities)
                .signWith(getSignInKey())
                .compact();
    }

    private Key getSignInKey() {
        byte [] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    //extract any claim(data) from the jwt
    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //it validates that the token has not been falsified and prevents a token from being modified without the correct signature
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    Boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    //retrieves the token's expiration date
    private Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public String generateToken(HashMap<String,Object> claims, UserDetails userDetails){
        return buildToken(claims,userDetails,jwtExpiration);
    }

}
