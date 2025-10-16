package com.example.springbootexample.service;

import com.example.springbootexample.entities.Carrera;
import com.example.springbootexample.entities.Estudiante;
import com.example.springbootexample.entities.Inscripcion;
import com.example.springbootexample.repository.CarreraRepository;
import com.example.springbootexample.repository.EstudianteRepository;
import com.example.springbootexample.repository.InscripcionRepository;
import com.example.springbootexample.service.dto.inscripcion.InscripcionRequestDTO;
import com.example.springbootexample.service.dto.inscripcion.InscripcionResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;
    private final EstudianteRepository estudianteRepository;
    private final CarreraRepository carreraRepository;

    @Transactional
    public InscripcionResponseDTO save(InscripcionRequestDTO request) {
        // Buscar la carrera por ID
        Carrera carrera = carreraRepository.findById(Long.valueOf(request.getIdCarrera()))
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        // Buscar el estudiante por DNI
        Estudiante estudiante = estudianteRepository.findById(Long.valueOf(request.getDniEstudiante()))
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        // Crear la inscripción y asignar relaciones
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setCarrera(carrera);
        inscripcion.setEstudiante(estudiante);
        inscripcion.setInscripcion(request.getAnioInscripcion());
        inscripcion.setAntiguedad(0);  // valor inicial
        inscripcion.setGraduacion(0); // valor inicial

        // Guardar en DB
        Inscripcion result = inscripcionRepository.save(inscripcion);

        return new InscripcionResponseDTO(result);
    }
}
