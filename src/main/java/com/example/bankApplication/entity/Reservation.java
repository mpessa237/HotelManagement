package com.example.bankApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;
    private LocalDateTime dateArrives;
    private LocalDateTime dateStart;
    private Double totalAmount;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private Client client;
    @OneToOne(mappedBy = "reservation",cascade = CascadeType.ALL)
    private Invoice invoice;
    @OneToOne(mappedBy = "reservation",cascade = CascadeType.ALL)
    private Staff staff;


    //calculerMontantTotal,confirmerReservation,annulerReservation,modifierDate

}
