package com.example.springbootexample.entities;


import com.example.springbootexample.service.dto.estudiante.EstudianteRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Estudiante {

    @Id
    private Integer dni; // <- sin GeneratedValue

    private int nroLibreta;
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String genero;

    public Estudiante(EstudianteRequestDTO request) {
        this.dni = request.getDni();
        this.nroLibreta = request.getNroLibreta();
        this.nombre = request.getNombre();
        this.apellido = request.getApellido();
        this.edad = request.getEdad();
        this.ciudad = request.getCiudad();
        this.genero = request.getGenero();
    }
}
