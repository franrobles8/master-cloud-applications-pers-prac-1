package com.mastercloudapps.airport.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Revision")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Avion avion;

    private Date fechaInicio;

    private Date fechaFin;
    
    private Double horas;

    @OneToOne
    private Mecanico mecanico;

    private String tipo;

    private String descripcion;

    @OneToOne
    private Aeropuerto aeropuerto;

}
