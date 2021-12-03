package com.example.ussdapp.service;

import com.example.ussdapp.entity.Packet;
import com.example.ussdapp.entity.Tariff;
import com.example.ussdapp.payload.ApiResponse;
import com.example.ussdapp.payload.PakaketDTO;
import com.example.ussdapp.repository.PacketRepository;
import com.example.ussdapp.repository.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PacketService {
    @Autowired
    TariffRepository tariffRepository;
    @Autowired
    PacketRepository packetRepository;

    public ApiResponse add(PakaketDTO pakaketDTO) {
        Packet packet = new Packet();
        packet.setAmount(pakaketDTO.getAmount());
        packet.setDueDate(pakaketDTO.getDueDate());
        packet.setPrice(pakaketDTO.getPrice());
        packet.setExpiredDate(new Date(System.currentTimeMillis() + (long) pakaketDTO.getDueDate() * 86400 * 1000));
        packet.setType(pakaketDTO.getType());
        List<Tariff> allById = tariffRepository.findAllById(pakaketDTO.getTariffList());
        packet.setTariffs(allById);
        packetRepository.save(packet);
        return new ApiResponse("Success", true);
    }

}
