package com.example.ussdapp.controller;

import com.example.ussdapp.payload.ApiResponse;
import com.example.ussdapp.repository.TariffSimcardRepository;
import com.example.ussdapp.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/dashboard")
public class Dashboard {
    @Autowired
    DashboardService dashboardService;

    @Autowired
    TariffSimcardRepository tariffSimcardRepository;

    //Get Sold simCards if active that means sold
    @GetMapping("activeSimCard")
    public HttpEntity<?> getActive(){
     ApiResponse apiResponse = dashboardService.getActive();
     return ResponseEntity.ok(apiResponse);

    }

    //Get Most using tariff
    @GetMapping("/activeTariff")
    public HttpEntity<?>getActiveTariff(){
      ApiResponse apiResponse =  dashboardService.findActiveTariff();
      return ResponseEntity.ok(apiResponse);
    }

    //Get Less using tariff
    @GetMapping("/passiveTariff")
    public HttpEntity<?>getPassiveTariff(){
      ApiResponse apiResponse = dashboardService.findPassiveTariff();
      return ResponseEntity.ok(apiResponse);
    }

    //Get Most using packet types (Max using 2 types)
//    @GetMapping("/activePacketTypes")
//    public HttpEntity<?>getActivePacket(){
//       ApiResponse apiResponse = dashboardService.findActivePackets();
//       return ResponseEntity.ok(apiResponse);
//    }
}
