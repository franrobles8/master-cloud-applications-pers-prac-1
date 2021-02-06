package com.mastercloudapps.airport.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper=true, includeFieldNames=true)
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity(name="Tripulante")
public class Tripulante extends Trabajador {
    
    private String puesto;
    private String formacion;
    
    @ManyToMany(mappedBy = "tripulantes", fetch=FetchType.EAGER)
    @ToString.Exclude
    private List<Vuelo> vuelos;
}
