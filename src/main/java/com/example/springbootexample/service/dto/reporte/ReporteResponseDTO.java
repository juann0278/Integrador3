package com.example.springbootexample.service.dto.reporte;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReporteResponseDTO {
    private Long id;
    private String nombre;
    private Integer inscriptos;
    private Long graduados;
    private Long antiguedad;
}

