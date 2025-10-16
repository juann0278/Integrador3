package com.example.springbootexample.service.dto.estudiante;

import com.example.springbootexample.entities.Estudiante;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EstudianteResponseDTO {

    private final Integer dni;
    private final int nroLibreta;
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final String ciudad;
    private final String genero;

    public EstudianteResponseDTO(Estudiante estudiante) {
        this.dni = estudiante.getDni();
        this.nroLibreta = estudiante.getNroLibreta();
        this.nombre = estudiante.getNombre();
        this.apellido = estudiante.getApellido();
        this.edad = estudiante.getEdad();
        this.ciudad = estudiante.getCiudad();
        this.genero = estudiante.getGenero();
    }

}
