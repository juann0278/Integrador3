package com.example.springbootexample.web;

import com.example.springbootexample.service.InscripcionService;
import com.example.springbootexample.service.dto.inscripcion.InscripcionRequestDTO;
import com.example.springbootexample.service.dto.inscripcion.InscripcionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/inscripciones")
@RequiredArgsConstructor
public class InscripcionResource {

    private final InscripcionService inscripcionService;

    //b) matricular un estudiante en una carrera
    @PostMapping("/matricular")
    public ResponseEntity<InscripcionResponseDTO> save(@RequestBody InscripcionRequestDTO request) {
        final var result = this.inscripcionService.save(request);
        return ResponseEntity.accepted().body(result);
    }
}
