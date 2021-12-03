package com.example.ussdapp.repository;


import com.example.ussdapp.entity.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TariffRepository extends JpaRepository<Tariff, Integer> {
    boolean existsByName(String name);

    Optional<Tariff> findByName(String name);

    void deleteByName(String name);
}
