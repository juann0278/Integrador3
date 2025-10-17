package com.example.springbootexample.repository;

import com.example.springbootexample.entities.Carrera;
import com.example.springbootexample.service.dto.carrera.CarreraResponseDTO;
import com.example.springbootexample.service.dto.reporte.ReporteResponseDTO;
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

    @Query("""
                SELECT new com.example.springbootexample.service.dto.reporte.ReporteResponseDTO(
                    c.id,
                    c.nombre,
                    i.inscripcion,
                    COUNT(i),
                    SUM(CASE WHEN i.graduacion IS NOT NULL THEN 1 ELSE 0 END)
                )
                FROM Carrera c
                JOIN c.inscripciones i
                GROUP BY c.id, c.nombre, i.inscripcion
                ORDER BY c.nombre ASC, i.inscripcion ASC
            """)
    List<ReporteResponseDTO> getReporteCarrera();

}
