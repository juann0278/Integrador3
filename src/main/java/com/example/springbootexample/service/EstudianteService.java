package com.example.springbootexample.service;

import com.example.springbootexample.entities.Estudiante;
import com.example.springbootexample.repository.EstudianteRepository;
import com.example.springbootexample.service.dto.estudiante.EstudianteRequestDTO;
import com.example.springbootexample.service.dto.estudiante.EstudianteResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Transactional
    public EstudianteResponseDTO save(EstudianteRequestDTO request){
        final var estudiante = new Estudiante(request);
        final var result =  this.estudianteRepository.save(estudiante);
        return new EstudianteResponseDTO(result.getDni(),result.getNroLibreta(),result.getNombre(),result.getApellido(),result.getEdad(),result.getCiudad(),result.getGenero());
    }

    @Transactional
    public List<EstudianteResponseDTO> findAll(){
        return this.estudianteRepository.findAll(Sort.by(Sort.Direction.ASC, "edad"))
                .stream()
                .map(EstudianteResponseDTO::new)
                .toList();
    }
}
