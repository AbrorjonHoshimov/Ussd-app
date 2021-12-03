package com.example.ussdapp.repository;


import com.example.ussdapp.entity.Packet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacketRepository extends JpaRepository<Packet, Integer> {

}
