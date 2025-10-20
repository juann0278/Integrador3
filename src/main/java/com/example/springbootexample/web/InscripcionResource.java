package com.example.springbootexample.web;

import com.example.springbootexample.service.InscripcionService;
import com.example.springbootexample.service.dto.inscripcion.InscripcionRequestDTO;
import com.example.springbootexample.service.dto.inscripcion.InscripcionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inscripciones")
@RequiredArgsConstructor
public class InscripcionResource {

    private final InscripcionService inscripcionService;

    //b) matricular un estudiante en una carrera
    @PostMapping("/matricular")
    public ResponseEntity<InscripcionResponseDTO> matricular(@RequestBody InscripcionRequestDTO request) {
        final var result = this.inscripcionService.matricular(request);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.inscripcionService.delete(id);
    }
}
