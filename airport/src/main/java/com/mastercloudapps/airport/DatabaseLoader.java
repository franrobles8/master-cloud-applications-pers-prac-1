package com.mastercloudapps.airport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.mastercloudapps.airport.dto.VueloCiudadFechaDTO;
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

    @Autowired
    MecanicoRepository mecanicoRepository;

    @Autowired
    TripulanteRepository tripulanteRepository;

    @Autowired
    AvionRepository avionRepository;

    @Autowired
    AeropuertoRepository aeropuertoRepository;

    @Autowired
    RevisionRepository revisionRepository;

    @Autowired
    VueloRepository vueloRepository;

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
            .horasVuelo(1500.0)
            .build();

        Avion av2 = Avion.builder()
            .matricula("1111BBB")
            .fabricante("Boeing")
            .modelo("737")
            .horasVuelo(856.5)
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
        
        Aeropuerto ae3 = Aeropuerto.builder()
            .codIATA("CCC")
            .nombre("JFK")
            .ciudad("Nueva York")
            .pais("USA")
            .build();

        Calendar fechaInicio = Calendar.getInstance();
        fechaInicio.set(2021, 0, 11);

        Calendar fechaFin = Calendar.getInstance();
        fechaFin.set(2021, 0, 12);

        Revision r1 = Revision.builder()
            .avion(av1)
            .fechaInicio(fechaInicio.getTime()).fechaFin(fechaFin.getTime())
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
            .build();
        
        Vuelo v2 = Vuelo.builder()
            .codVuelo("UX3345")
            .compania("Air Europa")
            .avion(av2)
            .origen(ae1)
            .destino(ae3)
            .fechaHora(new Date(System.currentTimeMillis() - 8000000))
            .duracion(9.0)
            .build();

        Vuelo v3 = Vuelo.builder()
            .codVuelo("UX3346")
            .compania("Air Europa")
            .avion(av2)
            .origen(ae3)
            .destino(ae2)
            .fechaHora(new Date(System.currentTimeMillis() - 2000000))
            .duracion(8.7)
            .build();

        mecanicoRepository.save(m1);
        tripulanteRepository.save(t1);
        avionRepository.save(av1);
        avionRepository.save(av2);
        aeropuertoRepository.save(ae1);
        aeropuertoRepository.save(ae2);
        aeropuertoRepository.save(ae3);
        vueloRepository.save(v1);
        vueloRepository.save(v2);
        vueloRepository.save(v3);
        revisionRepository.save(r1);

        List<Mecanico> mecanicos = mecanicoRepository.findAll();
        List<Tripulante> tripulantes = tripulanteRepository.findAll();
        List<Avion> aviones = avionRepository.findAll();
        List<Aeropuerto> aeropuertos = aeropuertoRepository.findAll();
        List<Vuelo> vuelos = vueloRepository.findAll();
        List<Revision> revisiones = revisionRepository.findAll();

        muestraDatos("Mecanicos: ", mecanicos);
        muestraDatos("Tripulantes: ", tripulantes);
        muestraDatos("Aviones: ", aviones);
        muestraDatos("Aeropuertos: ", aeropuertos);
        muestraDatos("Vuelos: ", vuelos);
        muestraDatos("Revisiones: ", revisiones);


        // Custom queries

        try {
            this.muestraVuelosCiudadDestinoYFecha("Las Palmas", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-07"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static void muestraDatos(String title, List datos) {
        System.out.println("\n\n\n--------");
        System.out.println(title + "\n\n");
        for (Object p : datos) {
            System.out.println(p);
        }
        System.out.println("--------");
    }

    private void muestraVuelosCiudadDestinoYFecha(String ciudadDestino, Date fecha) {
        List<VueloCiudadFechaDTO> vuelos = vueloRepository.findVuelosByCiudadDestinoAndFechaOrderedByHour(ciudadDestino, fecha);
        muestraDatos("Vuelos por ciudad de destino y fecha ordenados por hora: ", vuelos);
    }
}
