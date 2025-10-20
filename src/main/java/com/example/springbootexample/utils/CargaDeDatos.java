package com.example.springbootexample.utils;

import com.example.springbootexample.entities.Carrera;
import com.example.springbootexample.entities.Estudiante;
import com.example.springbootexample.entities.Inscripcion;
import com.example.springbootexample.repository.CarreraRepository;
import com.example.springbootexample.repository.EstudianteRepository;
import com.example.springbootexample.repository.InscripcionRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CargaDeDatos {

    private final CarreraRepository carreraRepository;
    private final EstudianteRepository estudianteRepository;
    private final InscripcionRepository inscripcionRepository;

    @Autowired
    public CargaDeDatos(CarreraRepository carreraRepository, EstudianteRepository estudianteRepository, InscripcionRepository inscripcionRepository) {
        this.carreraRepository = carreraRepository;
        this.estudianteRepository = estudianteRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    public void cargarDatosDesdeCSV() throws IOException {
        File carreraCSV = ResourceUtils.getFile("src/main/resources/csv/carreras.csv");
        File estudiantesCSV = ResourceUtils.getFile("src/main/resources/csv/estudiantes.csv");
        File inscripcionCSV = ResourceUtils.getFile("src/main/resources/csv/estudianteCarrera.csv");

        try (FileReader reader = new FileReader(carreraCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)){
            for (CSVRecord csvRecord : csvParser) {
                Carrera carrera = new Carrera();
                carrera.setId(Long.valueOf(csvRecord.get("id_carrera")));
                carrera.setNombre(csvRecord.get("carrera"));
                carrera.setDuracion(Integer.parseInt(csvRecord.get("duracion")));
                carreraRepository.save(carrera);
            }
        }

        try (FileReader reader = new FileReader(estudiantesCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Estudiante estudiante = new Estudiante();
                estudiante.setDni(Integer.parseInt(csvRecord.get("DNI"))); // <--- mayúsculas
                estudiante.setNombre(csvRecord.get("nombre"));
                estudiante.setApellido(csvRecord.get("apellido"));
                estudiante.setEdad(Integer.parseInt(csvRecord.get("edad")));
                estudiante.setGenero(csvRecord.get("genero"));
                estudiante.setCiudad(csvRecord.get("ciudad"));
                estudiante.setNroLibreta(Integer.parseInt(csvRecord.get("LU"))); // <--- usa "LU"
                estudianteRepository.save(estudiante);
            }
        }

        try (FileReader reader = new FileReader(inscripcionCSV);
             CSVParser csvParser = CSVFormat.DEFAULT
                     .withFirstRecordAsHeader()
                     .withIgnoreHeaderCase() // opcional, para ignorar mayúsculas/minúsculas
                     .withTrim()             // limpia espacios
                     .parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                // Obtener carrera existente
                Integer idCarrera = Integer.parseInt(csvRecord.get("id_carrera"));
                Carrera carrera = carreraRepository.findById(Long.valueOf(idCarrera))
                        .orElseThrow(() -> new RuntimeException("Carrera no encontrada: " + idCarrera));

                // Obtener estudiante existente
                Integer dniEstudiante = Integer.parseInt(csvRecord.get("id_estudiante"));
                Estudiante estudiante = estudianteRepository.findById(Long.valueOf(dniEstudiante))
                        .orElseThrow(() -> new RuntimeException("Estudiante no encontrado: " + dniEstudiante));

                // Crear inscripción
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setId(Integer.parseInt(csvRecord.get("id")));
                inscripcion.setCarrera(carrera);
                inscripcion.setEstudiante(estudiante);
                inscripcion.setInscripcion(Integer.parseInt(csvRecord.get("inscripcion")));
                inscripcion.setGraduacion(Integer.parseInt(csvRecord.get("graduacion")));
                inscripcion.setAntiguedad(Integer.parseInt(csvRecord.get("antiguedad")));

                inscripcionRepository.save(inscripcion);
            }
        }
    }
}