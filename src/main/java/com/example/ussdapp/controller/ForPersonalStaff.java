package com.example.ussdapp.controller;

import com.example.ussdapp.payload.ApiResponse;
import com.example.ussdapp.payload.StaffDTO;
import com.example.ussdapp.repository.FilialRepository;
import com.example.ussdapp.repository.StaffRepository;
import com.example.ussdapp.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/myProfile")
public class ForPersonalStaff {
    /// Bu controller faqat staff uchun u o'zini ko'ra oladi va o'zgartira oladi bunda imkoniyatlar cheklangan
    // bu controllerni o'shirish krk emas!
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    FilialRepository filialRepository;

    @Autowired
    StaffService staffService;

    @GetMapping("/{id}")
    public HttpEntity<?> getInfo(@PathVariable UUID id) {
        ApiResponse apiResponse = staffService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PutMapping("/{id}")
    private HttpEntity<?> editStaff(@PathVariable UUID id, @RequestBody StaffDTO staffDTO) {
        ApiResponse apiResponse = staffService.editForOnlyStaff(id, staffDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
}

