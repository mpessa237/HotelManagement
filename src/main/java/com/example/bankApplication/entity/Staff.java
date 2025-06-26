package com.example.bankApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "staff")
public class Staff {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staffId;
    private String firstname;
    private String lastname;
    private String job; //gerant,receptionniste,femme de menage
    private String email;
    private String password;

    @ManyToOne
    private Hotel hotel;
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    //gererClients()
    //gererChambres()
    //gererReservations()
    //genererRapports()
}
