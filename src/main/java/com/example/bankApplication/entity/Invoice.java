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
@Table(name = "invoice")
public class Invoice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceId;
    private LocalDateTime issueDate;
    private Double totalToPay;
    @Enumerated(EnumType.STRING)
    private StatusPayment statusPayment;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;


    //genererFacture,enregistrerPaiement
}
