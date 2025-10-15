package com.example.springbootexample.repository;


import com.example.springbootexample.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    //c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
    @Query ("SELECT e FROM Estudiante e ORDER BY e.edad")
    Estudiante findOrderByEdad(int edad);

    //d) recuperar un estudiante, en base a su número de libreta universitaria.
    @Query("SELECT e FROM Estudiante e WHERE e.nroLibreta =:libreta")
    Estudiante findByNroLibreta(int nroLibreta);

    //e) recuperar todos los estudiantes, en base a su género.
    @Query ("SELECT e FROM Estudiante e WHERE e.genero =:genero")
    List<Estudiante> findByGenero(String genero);

}
