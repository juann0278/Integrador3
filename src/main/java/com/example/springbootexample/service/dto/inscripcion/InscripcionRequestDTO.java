package com.example.springbootexample.service.dto.inscripcion;

import com.example.springbootexample.entities.Carrera;
import com.example.springbootexample.entities.Estudiante;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InscripcionRequestDTO {
    private Integer idCarrera;      // ID de la carrera
    private Integer dniEstudiante;  // DNI del estudiante
    private Integer anioInscripcion;
}
