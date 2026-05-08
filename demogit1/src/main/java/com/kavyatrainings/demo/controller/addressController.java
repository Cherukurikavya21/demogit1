package com.kavyatrainings.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kavyatrainings.demo.entities.address;
import com.kavyatrainings.demo.service.addressService;

@RestController
public class addressController {

    @Autowired
    addressService addSrv;

    @RequestMapping("/")
    public String home() {
        return "Spring Boot Application Running Successfully";
    }

    @RequestMapping("/addresses")
    public List<address> getAddress() {
        return addSrv.getAddress();
    }

    @PostMapping("/addresses")
    public address createAddress(@RequestBody address payload) {
        return addSrv.createAddress(payload);
    }
}