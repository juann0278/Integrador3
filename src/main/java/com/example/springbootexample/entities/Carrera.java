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
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int duracion;
    private long cantInscriptos;

    //este constructor deberia tener por parametro un CarreraRequestDTO
    //pero aun no fue creada la clase
   public Carrera(String nombre, int duracion, long cantInscriptos) {
       this.nombre = nombre;
       this.duracion = duracion;
       this.cantInscriptos = cantInscriptos;
   }
}
