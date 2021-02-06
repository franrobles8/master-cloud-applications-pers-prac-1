package com.mastercloudapps.airport.repository;

import com.mastercloudapps.airport.entity.Tripulante;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TripulanteRepository extends JpaRepository<Tripulante, String> {
    
}
