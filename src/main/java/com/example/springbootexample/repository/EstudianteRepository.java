package com.example.springbootexample.repository;


import com.example.springbootexample.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    Estudiante findByNroLibreta(int nroLibreta);

    Optional<Estudiante> findByDniEstudiante(String dni);

    List<Estudiante> findAllByGenero(String genero);
}
