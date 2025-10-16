package com.example.springbootexample.entities;

import com.example.springbootexample.service.dto.inscripcion.InscripcionRequestDTO;
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

    // 🔹 Relación ManyToOne con Carrera
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera", referencedColumnName = "id")
    private Carrera carrera;

    // 🔹 Relación ManyToOne con Estudiante
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante", referencedColumnName = "dni")
    private Estudiante estudiante;

    private Integer inscripcion;  // Año de inscripción
    private Integer graduacion;
    private Integer antiguedad;
}

