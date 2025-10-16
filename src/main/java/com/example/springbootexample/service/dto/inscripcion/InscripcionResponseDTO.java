package com.example.springbootexample.service.dto.inscripcion;

import com.example.springbootexample.entities.Inscripcion;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class InscripcionResponseDTO {

    private final Integer id;
    private final Integer idCarrera;
    private final Integer dniEstudiante;
    private final Integer inscripcion;
    private final Integer graduacion;
    private final Integer antiguedad;

    public InscripcionResponseDTO(Inscripcion inscripcion) {
        this.id = inscripcion.getId();
        this.idCarrera = inscripcion.getCarrera().getId();
        this.dniEstudiante = inscripcion.getEstudiante().getDni();
        this.inscripcion = inscripcion.getInscripcion();
        this.graduacion = inscripcion.getGraduacion();
        this.antiguedad = inscripcion.getAntiguedad();
    }
}
