package com.example.springbootexample.web;

import com.example.springbootexample.repository.CarreraRepository;
import com.example.springbootexample.service.CarreraService;
import com.example.springbootexample.service.dto.carrera.CarreraResponseDTO;
import com.example.springbootexample.service.dto.reporte.ReporteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/carreras")
@RequiredArgsConstructor
public class CarreraResource {

    private final CarreraService carreraService;

    //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    @GetMapping("/inscriptos")
    public List<CarreraResponseDTO> findCarrerasByCantInscriptosOrderByCantInscriptos(){
        return this.carreraService.findCarrerasByCantInscriptosOrderByCantInscriptos();
    }

    //h) generar un reporte de las carreras, que para cada carrera incluya información de los
    //inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y
    //presentar los años de manera cronológica
    @GetMapping("/reporte")
    public List<ReporteResponseDTO> getReporteCarrera(){
        return this.carreraService.getReporteCarrera();
    }

}
