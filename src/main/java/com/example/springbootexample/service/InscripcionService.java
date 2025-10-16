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
    public InscripcionResponseDTO matricular(InscripcionRequestDTO request) {
        // Buscar estudiante por DNI
        Estudiante estudiante = estudianteRepository.findByDniEstudiante(request.getDniEstudiante())
                .orElseThrow(()->(new RuntimeException("Estudiante no encontrado con DNI" + request.getDniEstudiante())));

        // Buscar carrera por ID
        Carrera carrera = carreraRepository.findById(request.getIdCarrera())
                .orElseThrow(()->(new RuntimeException("Carrera no encontrada con ID" + request.getIdCarrera())));

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setCarrera(carrera);
        inscripcion.setEstudiante(estudiante);
        inscripcion.setInscripcion(request.getAnioInscripcion());

        inscripcionRepository.save(inscripcion);

        return new InscripcionResponseDTO(inscripcion);

    }

}
