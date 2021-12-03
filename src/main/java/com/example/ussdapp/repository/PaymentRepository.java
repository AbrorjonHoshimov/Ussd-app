package com.example.ussdapp.repository;


import com.example.ussdapp.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    List<Payment> findAllByNumber(String number);
    double countPaymentsByAmountAndDateBetween(double amount, Date date, Date date2);

}
