package com.example.springbootexample.service.dto.estudiante;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstudianteRequestDTO {

    @NotNull(message = "El dni es un campo obligatorio.")
    @NotEmpty(message = "El dni es un campo obligatorio.")
    private Integer dni;
    private int nroLibreta;
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String genero;

}
