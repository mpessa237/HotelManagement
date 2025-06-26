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
@Table(name = "hotel")
public class Hotel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;
    private String nameHotel;
    private String address;
    private String email;
    private Integer phone;

    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    private Set<Room> rooms = new HashSet<>();

    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    private Set<Staff> staffs = new HashSet<>();

    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();

    //ajouterChambre,gererChambre,gererReservation
}
