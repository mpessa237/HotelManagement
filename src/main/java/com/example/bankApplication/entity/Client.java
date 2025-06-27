package com.example.bankApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private String address;
    private Boolean enabled = false;
    private Boolean accountLocked = false;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();

    //creer cpte,modfier profil,afficherReservation
    //reserver une chambre,payer une facture,annuler/modifier facture
}
