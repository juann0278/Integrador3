package com.example.springbootexample.web;

import com.example.springbootexample.repository.CarreraRepository;
import com.example.springbootexample.service.CarreraService;
import com.example.springbootexample.service.dto.carrera.CarreraResponseDTO;
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


}
