package com.example.ussdapp.service;

import com.example.ussdapp.entity.SimCard;
import com.example.ussdapp.entity.Tariff;
import com.example.ussdapp.payload.ApiResponse;
import com.example.ussdapp.repository.SimcardRepository;
import com.example.ussdapp.repository.TariffRepository;
import com.example.ussdapp.repository.TariffSimcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DashboardService {
    @Autowired
    SimcardRepository simcardRepository;

    @Autowired
    TariffSimcardRepository tariffSimcardRepository;

    @Autowired
    TariffRepository tariffRepository;

    public ApiResponse getActive() {
        List<SimCard> allByActive = simcardRepository.findAllByActive(true);
        return new ApiResponse("Active simCards",true,allByActive);
    }

    public ApiResponse findActiveTariff() {
        Integer activeTariff = tariffSimcardRepository.findActiveTariff();
        Optional<Tariff> tariffOptional = tariffRepository.findById(activeTariff);
        Tariff tariff = tariffOptional.get();
        String tariffName = tariff.getName();
        return new ApiResponse("Most using tariff",true,tariffName);
    }

    public ApiResponse findPassiveTariff() {
        Integer passiveTariff = tariffSimcardRepository.findPassiveTariff();
        Optional<Tariff> tariffOptional = tariffRepository.findById(passiveTariff);
        Tariff tariff = tariffOptional.get();
        String tariffName = tariff.getName();
        return new ApiResponse("Passive tariff",true,tariffName);

    }

//    public ApiResponse findActivePackets() {
//
//    }
}
