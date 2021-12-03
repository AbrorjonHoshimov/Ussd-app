package com.example.ussdapp.repository;

import com.example.ussdapp.entity.UssdCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface USSDRepository extends JpaRepository<UssdCode,Integer> {
}
