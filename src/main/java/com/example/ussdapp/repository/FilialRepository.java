package com.example.ussdapp.repository;


import com.example.ussdapp.entity.Filial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FilialRepository extends JpaRepository<Filial, UUID> {

}
