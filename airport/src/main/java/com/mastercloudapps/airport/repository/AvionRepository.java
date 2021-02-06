package com.mastercloudapps.airport.repository;

import com.mastercloudapps.airport.entity.Avion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepository extends JpaRepository<Avion, Long> {
    
}
