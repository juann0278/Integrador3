package com.example.springbootexample.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer id_carrera;
    private Integer id_estudiante;
    private Integer inscripcion;
    private Integer graduacion;
    private Integer antiguedad;

    public Inscripcion(Integer id, Integer id_carrera, Integer id_estudiante, Integer inscripcion, Integer graduacion, Integer antiguedad) {
        this.id = id;
        this.id_carrera = id_carrera;
        this.id_estudiante = id_estudiante;
        this.inscripcion = inscripcion;
        this.graduacion = graduacion;
        this.antiguedad = antiguedad;
    }
}
