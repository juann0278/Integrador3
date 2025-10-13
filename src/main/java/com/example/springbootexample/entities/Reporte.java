package com.example.springbootexample.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Reporte {
    private Integer id;
    private String nombre;
    private Long inscriptos;
    private Long graduados;
    private int anio;

}
