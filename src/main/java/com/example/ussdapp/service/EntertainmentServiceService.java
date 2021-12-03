package com.example.ussdapp.service;

import com.example.ussdapp.entity.Category;
import com.example.ussdapp.entity.EntertainmentService;
import com.example.ussdapp.payload.ApiResponse;
import com.example.ussdapp.payload.EntertainmentServiceDto;
import com.example.ussdapp.repository.CategoryRepository;
import com.example.ussdapp.repository.EntertainmentServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntertainmentServiceService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    EntertainmentServiceRepository entertainmentServiceRepository;

    public ApiResponse add(EntertainmentServiceDto entertainmentServiceDto) {

        EntertainmentService entertainmentService = new EntertainmentService();
        Optional<Category> category = categoryRepository.findById(entertainmentServiceDto.getCategoryId());
        if (!category.isPresent()) return null;
        entertainmentService.setCategory(category.get());
        entertainmentService.setPrice(entertainmentServiceDto.getPrice());
        entertainmentServiceDto.setName(entertainmentServiceDto.getName());
        entertainmentService.setDueDate(entertainmentServiceDto.getDueDate());
        entertainmentServiceRepository.save(entertainmentService);
        return new ApiResponse("success",true);

    }
    public ApiResponse edit(Integer id,EntertainmentServiceDto entertainmentServiceDto){
        if (!entertainmentServiceRepository.existsById(id)) {
            return new ApiResponse("object not found",false);
        }else {
            Optional<EntertainmentService> byId = entertainmentServiceRepository.findById(id);

           if(!categoryRepository.existsById(entertainmentServiceDto.getCategoryId())) return new ApiResponse("category not found",false);

if (!byId.isPresent()) return null;
           EntertainmentService entertainmentService = byId.get();
            entertainmentService.setDueDate(entertainmentServiceDto.getDueDate());
            entertainmentService.setName(entertainmentServiceDto.getName());
            Optional<Category> category = categoryRepository.findById(entertainmentServiceDto.getCategoryId());
            if (!category.isPresent()) return null;

            entertainmentService.setCategory(category.get());
            entertainmentService.setPrice(entertainmentServiceDto.getPrice());
            return new ApiResponse("success",true);
        }
    }
}
