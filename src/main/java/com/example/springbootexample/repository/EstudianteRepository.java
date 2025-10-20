package com.example.springbootexample.repository;


import com.example.springbootexample.entities.Estudiante;
import com.example.springbootexample.service.dto.estudiante.EstudianteResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    Estudiante findByNroLibreta(int nroLibreta);

    Optional<Estudiante> findByDni(Integer dni);

    List<Estudiante> findAllByGenero(String genero);

    @Query("SELECT DISTINCT new com.example.springbootexample.service.dto.estudiante.EstudianteResponseDTO(e.dni, e.nroLibreta, e.nombre, e.apellido, e.edad, e.ciudad, e.genero, c.nombre) FROM Estudiante e " +
            "JOIN e.inscripciones i JOIN i.carrera c " +
            "WHERE c.id = :id_carrera AND e.ciudad = :ciudad")
    List<EstudianteResponseDTO> findByCarreraFilteredByCiudad(Integer id_carrera, String ciudad);
}
