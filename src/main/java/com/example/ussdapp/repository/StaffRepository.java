package com.example.ussdapp.repository;


import com.example.ussdapp.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffRepository extends JpaRepository<Staff, UUID> {

}
