package com.example.springbootexample.web;

import com.example.springbootexample.service.EstudianteService;
import com.example.springbootexample.service.dto.estudiante.EstudianteRequestDTO;
import com.example.springbootexample.service.dto.estudiante.EstudianteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estudiantes")
@RequiredArgsConstructor
public class EstudianteResource {

    private final EstudianteService estudianteService;

    //a)dar de alta un estudiante
    @PostMapping("")
    public ResponseEntity<EstudianteResponseDTO> save(@RequestBody EstudianteRequestDTO request) {
        final var result = this.estudianteService.save(request);
        return ResponseEntity.accepted().body(result);
    }

    //c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
    // En este caso se va a ordenar ascendentemente por edad y lo hacemos en el estudianteService
    @GetMapping("")
    public List<EstudianteResponseDTO> findAll() {
        return this.estudianteService.findAll();
    }
}
