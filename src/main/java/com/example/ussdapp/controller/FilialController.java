package com.example.ussdapp.controller;

import com.example.ussdapp.entity.Filial;
import com.example.ussdapp.payload.ApiResponse;
import com.example.ussdapp.payload.FilialDTO;
import com.example.ussdapp.repository.FilialRepository;
import com.example.ussdapp.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/filial")
public class FilialController {
    // filial o'zini o'zi o'zgartira olmaydi uni faqat filial managerqiladi

    @Autowired
    FilialRepository filialRepository;
    @Autowired
    FilialService filialService;

    @PostMapping
    public HttpEntity<?> addFilial(@RequestBody FilialDTO filialDTO) {
        ApiResponse apiResponse = filialService.addFilial(filialDTO);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable UUID id) {
        ApiResponse apiResponse = filialService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Filial> all = filialRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable UUID id, @RequestBody FilialDTO filialDTO) {
        ApiResponse apiResponse = filialService.edit(id, filialDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable UUID id) {

        ApiResponse apiResponse = filialService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

}
