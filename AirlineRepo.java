package com.example.admin.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.admin.entity.Airline;

public interface AirlineRepo extends JpaRepository<Airline,Integer> {

}
