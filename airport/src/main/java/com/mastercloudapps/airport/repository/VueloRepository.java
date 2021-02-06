package com.mastercloudapps.airport.repository;

import com.mastercloudapps.airport.entity.Vuelo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
    
}
