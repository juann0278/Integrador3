package com.example.springbootexample.service.dto.carrera;

import com.example.springbootexample.entities.Carrera;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CarreraResponseDTO {
    private final Long id;
    private final String nombre;
    private final int duracion;
    private final Long cantInscriptos;

    public CarreraResponseDTO(Carrera carrera) {
        this.id = carrera.getId();
        this.nombre = carrera.getNombre();
        this.duracion = carrera.getDuracion();
        this.cantInscriptos = carrera.getCantInscriptos();
    }
}
