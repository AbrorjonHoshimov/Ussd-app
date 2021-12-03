package com.example.ussdapp.controller;

import com.example.ussdapp.payload.ApiResponse;
import com.example.ussdapp.payload.PaymentDTO;
import com.example.ussdapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    //Payment process
    @PostMapping
    public HttpEntity<?> add(@RequestBody PaymentDTO paymentDTO){
        ApiResponse apiResponse = paymentService.add(paymentDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);

    }

   //Get all payments history
    @GetMapping
    public HttpEntity<?>getAll(){
      ApiResponse apiResponse =  paymentService.getAll();
      return ResponseEntity.ok(apiResponse);
    }

    //Get one number history
   @GetMapping("/phone")
    public HttpEntity<?> getOne(@RequestParam String phoneNumber){
      ApiResponse apiResponse =  paymentService.getOne(phoneNumber);
      return ResponseEntity.ok(apiResponse);
   }

   @DeleteMapping("/{id}")
    public HttpEntity<?>delete(@PathVariable UUID id){
      ApiResponse apiResponse =  paymentService.delete(id);
      return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
   }

    }

