package com.example.ussdapp.controller;

import com.example.ussdapp.entity.User;
import com.example.ussdapp.payload.ApiResponse;
import com.example.ussdapp.payload.AuthRegisterDTO;
import com.example.ussdapp.payload.LoginDto;
import com.example.ussdapp.repository.UserRepository;
import com.example.ussdapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

    @Autowired
    AuthService authService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody AuthRegisterDTO authRegisterDTO) throws ChangeSetPersister.NotFoundException {
        ApiResponse apiResponse = authService.registerUser(authRegisterDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDto loginDto) {
        ApiResponse apiResponse = authService.loginUser(loginDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @GetMapping
    public HttpEntity<?> all(@RequestBody LoginDto loginDto) {
        List<User> all = userRepository.findAll();
        return ResponseEntity.ok(all);
    }
}
