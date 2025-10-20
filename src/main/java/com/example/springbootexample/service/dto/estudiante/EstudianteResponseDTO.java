package com.example.springbootexample.service.dto.estudiante;

import com.example.springbootexample.entities.Estudiante;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class EstudianteResponseDTO {

    private final Integer dni;
    private final int nroLibreta;
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final String ciudad;
    private final String genero;
    private final String nombreCarrera; // 👈 nuevo campo

    // Constructor que usará el @Query con new EstudianteResponseDTO(...)
    public EstudianteResponseDTO(Integer dni, int nroLibreta, String nombre, String apellido,
                                 int edad, String ciudad, String genero, String nombreCarrera) {
        this.dni = dni;
        this.nroLibreta = nroLibreta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudad = ciudad;
        this.genero = genero;
        this.nombreCarrera = nombreCarrera;
    }

    // Constructor que sigue funcionando para mapear desde la entidad directamente
    public EstudianteResponseDTO(Estudiante estudiante) {
        this.dni = estudiante.getDni();
        this.nroLibreta = estudiante.getNroLibreta();
        this.nombre = estudiante.getNombre();
        this.apellido = estudiante.getApellido();
        this.edad = estudiante.getEdad();
        this.ciudad = estudiante.getCiudad();
        this.genero = estudiante.getGenero();
        this.nombreCarrera = null; // por defecto si no viene de la query
    }
}

