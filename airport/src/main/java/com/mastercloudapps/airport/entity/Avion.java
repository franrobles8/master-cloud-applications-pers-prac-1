package com.mastercloudapps.airport.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Avion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String matricula;

    private String fabricante;

    private String modelo;

    private Double horasVuelo;

}
