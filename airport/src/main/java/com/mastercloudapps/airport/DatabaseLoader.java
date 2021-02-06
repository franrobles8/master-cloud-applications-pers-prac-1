package com.mastercloudapps.airport;

import java.util.List;

import com.mastercloudapps.airport.entity.Mecanico;
import com.mastercloudapps.airport.entity.Tripulante;
import com.mastercloudapps.airport.repository.MecanicoRepository;
import com.mastercloudapps.airport.repository.TripulanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseLoader implements CommandLineRunner {


    @Autowired MecanicoRepository mecanicoRepository;
    
    @Autowired TripulanteRepository tripulanteRepository;

    @Override
    public void run(String... args) {
        // Guardando datos a través del repositorio de la clase madre:
        Mecanico m1 = Mecanico.builder()
            .empresa("Airbus")
            .nombre("Pepito")
            .apellidos("El de los palotes")
            .añoIncorporacion("2021")
            .formacionPrevia("Universidad de la calle")
            .build();

        Tripulante t1 = Tripulante.builder()
            .empresa("Airbus")
            .nombre("Jony")
            .apellidos("Me lavo")
            .puesto("Capitan del mundo")
            .formacion("Pagada por papa")
            .build();

        mecanicoRepository.save(m1);
        tripulanteRepository.save(t1);

        List<Mecanico> mecanicos = mecanicoRepository.findAll();
        List<Tripulante> tripulantes = tripulanteRepository.findAll();
        
        muestraDatos(mecanicos);
        muestraDatos(tripulantes);
    }

    
    private static void muestraDatos(List datos) {
        for (Object p : datos) {
            System.out.println(p);
        }
        System.out.println();
    }
}
