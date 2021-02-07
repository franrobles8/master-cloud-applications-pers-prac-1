package com.mastercloudapps.airport.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Vuelo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vuelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String codVuelo;

    private String compania;

    @OneToOne
    private Avion avion;

    @OneToOne
    private Aeropuerto origen;

    @OneToOne
    private Aeropuerto destino;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    private Double duracion;

    @ManyToMany(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Tripulante> tripulantes;

}
