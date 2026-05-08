package com.kavyatrainings.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavyatrainings.demo.entities.address;

public interface IAddressPersistence extends JpaRepository<address, Long> {

}
