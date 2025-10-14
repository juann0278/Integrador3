package com.example.springbootexample.repository;


import com.example.springbootexample.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    //d) recuperar un estudiante, en base a su número de libreta universitaria.
    Estudiante findByNroLibreta(int nroLibreta);

    //e) recuperar todos los estudiantes, en base a su género.
    List<Estudiante> findByGenero(String genero);

}
