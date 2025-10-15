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
public class Estudiante {

    @Id
    private Integer dni; // <- sin GeneratedValue

    private int nroLibreta;
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String genero;

    public Estudiante(Integer dni, int nroLibreta, String nombre, String apellido, int edad, String ciudad, String genero) {
        this.dni = dni;
        this.nroLibreta = nroLibreta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudad = ciudad;
        this.genero = genero;
    }
}
