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
@Table(name = "room")
public class Room {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;
    private String roomNumber;
    private Integer maxCapacity;
    private Boolean isAvailable;
    @Enumerated(EnumType.STRING)
    private TypeRoom typeRoom;
    private Double pricePerNight;

    @ManyToOne
    private Hotel hotel;

    //reserver,liberer,verifier la disponibilites
}
