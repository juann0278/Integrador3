package com.example.springbootexample.web;

import com.example.springbootexample.service.EstudianteService;
import com.example.springbootexample.service.dto.estudiante.EstudianteRequestDTO;
import com.example.springbootexample.service.dto.estudiante.EstudianteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
