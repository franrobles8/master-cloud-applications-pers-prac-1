package com.mastercloudapps.airport.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name="Tripulante")
public class Tripulante extends Trabajador {
    
    private String puesto;
    private String formacion;
}
