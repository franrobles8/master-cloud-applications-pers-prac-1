package com.mastercloudapps.airport.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class Trabajador {

    @Id
    @GeneratedValue
    private String cod_empleado;
    
    private String nombre;
    
    private String apellidos;
    
    private String empresa;
}
