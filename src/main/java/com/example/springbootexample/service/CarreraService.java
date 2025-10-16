package com.example.springbootexample.service;

import com.example.springbootexample.repository.CarreraRepository;
import com.example.springbootexample.service.dto.carrera.CarreraResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarreraService {
    private final CarreraRepository carreraRepository;

    //2f
    @Transactional
    public List<CarreraResponseDTO> findCarrerasByCantInscriptosOrderByCantInscriptos(){
        return this.carreraRepository.findCarrerasByCantInscriptosOrderByCantInscriptos();
    }
}
