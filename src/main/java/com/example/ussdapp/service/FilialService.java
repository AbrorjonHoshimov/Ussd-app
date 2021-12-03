package com.example.ussdapp.service;

import com.example.ussdapp.entity.Filial;
import com.example.ussdapp.payload.ApiResponse;
import com.example.ussdapp.payload.FilialDTO;
import com.example.ussdapp.repository.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Service
public class FilialService {
    @Autowired
    FilialRepository filialRepository;

    public ApiResponse addFilial(FilialDTO filialDTO) {
        Filial filial = new Filial();
        filial.setFilialManager(filialDTO.getFilialManager());
        filial.setDirector(filialDTO.getDirector());
        filial.setName(filialDTO.getName());
        filialRepository.save(filial);
        return new ApiResponse("Saved", true);
    }


    public ApiResponse delete(UUID id) {
        if (filialRepository.existsById(id)) {
            filialRepository.deleteById(id);
        }
        return new ApiResponse("Deleted", true);
    }

    public ApiResponse getOne(UUID id) {
        Optional<Filial> optionalFilial = filialRepository.findById(id);
        if (!optionalFilial.isPresent()) {
            return new ApiResponse("Not found", false);
        }
        return new ApiResponse("Found", true, optionalFilial.get());
    }

    public ApiResponse edit(UUID id, FilialDTO filialDTO) {
        Optional<Filial> byId = filialRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found", false);
        }
        Filial filial = byId.get();
        filial.setFilialManager(filialDTO.getFilialManager());
        filial.setDirector(filialDTO.getDirector());
        filial.setName(filialDTO.getName());
        filialRepository.save(filial);
        return new ApiResponse("Saved", true);

    }
}
