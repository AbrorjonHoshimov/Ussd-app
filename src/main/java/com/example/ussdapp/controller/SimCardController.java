package com.example.ussdapp.controller;

import com.example.ussdapp.payload.ApiResponse;
import com.example.ussdapp.payload.RegisterDTO;
import com.example.ussdapp.service.SimCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/simCard")
public class SimCardController {
    @Autowired
    SimCardService simCardService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody RegisterDTO registerDTO) {
        ApiResponse apiResponse = simCardService.add(registerDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PostMapping("/{id}")
    public HttpEntity<?> changeTariff(@PathVariable UUID id, @RequestParam Integer tariffId) {
        ApiResponse response = simCardService.changeTariff(id, tariffId);
        return ResponseEntity.status(response.isSuccess() ? 200 : 404).body(response);
    }

//    @PostMapping("/{id}")
//    public HttpEntity<?> buyPacket(@PathVariable UUID id, @RequestParam Integer packetId) {
//        ApiResponse response = simCardService.buyPacket(id, packetId);
//        return ResponseEntity.ok(response);
//    }


}
