package com.example.ussdapp.service;

import com.example.ussdapp.entity.SimCard;
import com.example.ussdapp.entity.TariffSimcard;
import com.example.ussdapp.payload.ApiResponse;
import com.example.ussdapp.repository.SimcardRepository;
import com.example.ussdapp.repository.TariffSimcardRepository;
import com.example.ussdapp.repository.USSDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Service
public class USSDService {
    @Autowired
    USSDRepository ussdRepository;
   @Autowired
   SimcardRepository simcardRepository;
   @Autowired
   TariffSimcardRepository tariffSimcardRepository;


    //
    public ApiResponse getBalance(UUID id){
        Optional<SimCard> byId = simcardRepository.findById(id);

        SimCard simCard = byId.get();
        return new ApiResponse("success",true,simCard.getBalance() );


    }

    //mb  va daq
    public ApiResponse getMb(UUID id){
        Optional<SimCard> byId = simcardRepository.findById(id);
        SimCard simCard = byId.get();
        Optional<TariffSimcard> bySimCard_id = tariffSimcardRepository.findBySimCard_Id(id);

        return new ApiResponse("success",true,Arrays.asList(bySimCard_id.get().getLeftOverDAQ(),bySimCard_id.get().getLeftOverMB()));
    }

    //all code

}
