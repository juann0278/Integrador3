package com.example.springbootexample.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int duracion;
    private long cantInscriptos;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
    private List<Inscripcion> inscripciones;

    //este constructor deberia tener por parametro un CarreraRequestDTO
    //pero aun no fue creada la clase
   public Carrera(String nombre, int duracion, long cantInscriptos) {
       this.nombre = nombre;
       this.duracion = duracion;
       this.cantInscriptos = cantInscriptos;
   }
}
