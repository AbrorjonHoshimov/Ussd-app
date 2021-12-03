package com.example.ussdapp.controller;

import com.example.ussdapp.payload.ApiResponse;
import com.example.ussdapp.payload.PakaketDTO;
import com.example.ussdapp.service.PacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/packet")
public class PacketController {
    @Autowired
    PacketService packetService;

    @PostMapping
    public HttpEntity<?> addPacket(@RequestBody PakaketDTO packageDTO) {
        ApiResponse apiResponse = packetService.add(packageDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

}
