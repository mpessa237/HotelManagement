package com.example.bankApplication.repository;

import com.example.bankApplication.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepo extends JpaRepository<Token,Integer> {
    Optional<Token> findByToken(String token);
}
