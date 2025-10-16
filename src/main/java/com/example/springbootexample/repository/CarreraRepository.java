package com.example.springbootexample.repository;

import com.example.springbootexample.entities.Carrera;
import com.example.springbootexample.service.dto.carrera.CarreraResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    @Query("SELECT new com.example.springbootexample.service.dto.carrera.CarreraResponseDTO(c.id, c.nombre, c.duracion, COUNT(i.id)) " +
            "FROM Carrera c " +
            "JOIN c.inscripciones i " +
            "GROUP BY c.id, c.nombre, c.duracion " +
            "ORDER BY COUNT(i.id) DESC")
    List<CarreraResponseDTO> findCarrerasByCantInscriptosOrderByCantInscriptos();
}
