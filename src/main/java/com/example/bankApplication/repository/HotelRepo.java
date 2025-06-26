package com.example.bankApplication.repository;

import com.example.bankApplication.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Integer> {
}
