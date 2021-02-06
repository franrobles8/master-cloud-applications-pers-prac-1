package com.mastercloudapps.airport.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name="Mecanico")
public class Mecanico extends Trabajador {

    private String añoIncorporacion;
    private String formacionPrevia;    
}
