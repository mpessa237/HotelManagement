package com.example.bankApplication.repository;

import com.example.bankApplication.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepo extends JpaRepository<Invoice,Integer> {
}
