package com.example.springbootexample.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 🔹 Relación con Carrera
    @ManyToOne
    @JoinColumn(name = "id_carrera", referencedColumnName = "id")
    private Carrera carrera;

    // 🔹 Relación con Estudiante
    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "dni")
    private Estudiante estudiante;

    private Integer inscripcion;
    private Integer graduacion;
    private Integer antiguedad;

    public Inscripcion(Integer id, Carrera carrera, Estudiante estudiante,
                       Integer inscripcion, Integer graduacion, Integer antiguedad) {
        this.id = id;
        this.carrera = carrera;
        this.estudiante = estudiante;
        this.inscripcion = inscripcion;
        this.graduacion = graduacion;
        this.antiguedad = antiguedad;
    }
}
