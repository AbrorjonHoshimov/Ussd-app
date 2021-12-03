package com.example.ussdapp.controller;

import com.example.ussdapp.entity.Staff;
import com.example.ussdapp.payload.ApiResponse;
import com.example.ussdapp.payload.StaffDTO;
import com.example.ussdapp.repository.FilialRepository;
import com.example.ussdapp.repository.StaffRepository;
import com.example.ussdapp.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/stuff")
public class StaffController {
    // Bu controller kompaniya uchun staff o'zini ko'rish va o'zgartirish uchun alohida controller yoziladi

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    FilialRepository filialRepository;

    @Autowired
    StaffService staffService;

    @PostMapping
    public HttpEntity<?> addStaffToFilial(@RequestBody StaffDTO staffDTO) {
        ApiResponse apiResponse = staffService.add(staffDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping
    private HttpEntity<?> getList() {
        List<Staff> all = staffRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    private HttpEntity<?> getOne(@PathVariable UUID id) {
        ApiResponse apiResponse = staffService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PutMapping("/{id}")
    private HttpEntity<?> editStaff(@PathVariable UUID id, @RequestBody StaffDTO staffDTO) {
        ApiResponse apiResponse = staffService.edit(id, staffDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteStaff(@PathVariable UUID id) {
        ApiResponse apiResponse = staffService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
}
