package com.mastercloudapps.airport;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.mastercloudapps.airport.entity.Aeropuerto;
import com.mastercloudapps.airport.entity.Avion;
import com.mastercloudapps.airport.entity.Mecanico;
import com.mastercloudapps.airport.entity.Revision;
import com.mastercloudapps.airport.entity.Tripulante;
import com.mastercloudapps.airport.entity.Vuelo;
import com.mastercloudapps.airport.repository.AeropuertoRepository;
import com.mastercloudapps.airport.repository.AvionRepository;
import com.mastercloudapps.airport.repository.MecanicoRepository;
import com.mastercloudapps.airport.repository.RevisionRepository;
import com.mastercloudapps.airport.repository.TripulanteRepository;
import com.mastercloudapps.airport.repository.VueloRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseLoader implements CommandLineRunner {


    @Autowired MecanicoRepository mecanicoRepository;
    
    @Autowired TripulanteRepository tripulanteRepository;

    @Autowired AvionRepository avionRepository;

    @Autowired AeropuertoRepository aeropuertoRepository;

    @Autowired RevisionRepository revisionRepository;

    @Autowired VueloRepository vueloRepository;

    @Override
    public void run(String... args) {
        
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

        Avion av1 = Avion.builder()
            .matricula("00000AAA")
            .fabricante("Airbus")
            .modelo("775")
            .horasVuelo(25.6)
            .build();

        Aeropuerto ae1 = Aeropuerto.builder()
            .codIATA("AAA")
            .nombre("Adolfo Suárez")
            .ciudad("Madrid")
            .pais("España")
            .build();
        
        Aeropuerto ae2 = Aeropuerto.builder()
            .codIATA("BBB")
            .nombre("LPA")
            .ciudad("Las Palmas")
            .pais("España")
            .build();

        Calendar fechaInicio = Calendar.getInstance();
        fechaInicio.set(2021, 0, 11);

        Calendar fechaFin = Calendar.getInstance();
        fechaFin.set(2021, 0, 12);
    
        Revision r1 = Revision.builder()
            .avion(av1)
            .fechaInicio(fechaInicio.getTime())
            .fechaFin(fechaFin.getTime())
            .horas(2.0)
            .mecanico(m1)
            .tipo("Reparacion")
            .descripcion("Comprobación de flaps del avión")
            .aeropuerto(ae1)
            .build();

        Vuelo v1 = Vuelo.builder()
            .codVuelo("IB3343")
            .compania("Iberia")
            .avion(av1)
            .origen(ae1)
            .destino(ae2)
            .fechaHora(new Date(System.currentTimeMillis() - 5000000))
            .duracion(2.5)
            //.tripulantes(Arrays.asList(t1))
            .build();
            

        mecanicoRepository.save(m1);
        tripulanteRepository.save(t1);
        avionRepository.save(av1);
        aeropuertoRepository.save(ae1);
        aeropuertoRepository.save(ae2);
        revisionRepository.save(r1);
        vueloRepository.save(v1);

        List<Mecanico> mecanicos = mecanicoRepository.findAll();
        List<Tripulante> tripulantes = tripulanteRepository.findAll();
        List<Avion> aviones = avionRepository.findAll();
        List<Aeropuerto> aeropuertos = aeropuertoRepository.findAll();
        List<Revision> revisiones = revisionRepository.findAll();
        List<Vuelo> vuelos = vueloRepository.findAll();
        
        muestraDatos("Mecanicos: ", mecanicos);
        muestraDatos("Tripulantes: ", tripulantes);
        muestraDatos("Aviones: ", aviones);
        muestraDatos("Aeropuertos: ", aeropuertos);
        muestraDatos("Vuelos: ", vuelos);
        muestraDatos("Revisiones: ", revisiones);

    }
  
    private static void muestraDatos(String title, List datos) {
        System.out.println(title);
        for (Object p : datos) {
            System.out.println(p);
        }
        System.out.println("--------");
    }
}
