package com.example.springbootexample.web;

import com.example.springbootexample.service.EstudianteService;
import com.example.springbootexample.service.dto.estudiante.EstudianteRequestDTO;
import com.example.springbootexample.service.dto.estudiante.EstudianteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estudiantes")
@RequiredArgsConstructor
public class EstudianteResource {

    private final EstudianteService estudianteService;

    //a)dar de alta un estudiante
    @PostMapping("")
    public ResponseEntity<EstudianteResponseDTO> save(@RequestBody EstudianteRequestDTO request) {
        final var result = this.estudianteService.save(request);
        return ResponseEntity.ok(result);
    }

    //c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
    // En este caso se va a ordenar ascendentemente por edad y lo hacemos en el estudianteService
    @GetMapping("")
    public List<EstudianteResponseDTO> findAll() {
        return this.estudianteService.findAll();
    }

    // d) recuperar un estudiante, en base a su número de libreta universitaria.
    @GetMapping("/{nroLibreta}")
    public EstudianteResponseDTO findByNroLibreta(@PathVariable int nroLibreta) {
        return this.estudianteService.findByNroLibreta(nroLibreta);
    }

    //e) recuperar todos los estudiantes, en base a su género.
    @GetMapping("/genero/{genero}")
    public List<EstudianteResponseDTO> findAllByGenero(@PathVariable String genero) {
        return this.estudianteService.findAllByGenero(genero);
    }

    @GetMapping("/filtrar")
    public List<EstudianteResponseDTO> findByCarreraFilteredByCiudad(@RequestParam Integer id_carrera, @RequestParam String ciudad){
        return this.estudianteService.findByCarreraFilteredByCiudad(id_carrera, ciudad);
    }

    @DeleteMapping("/estudiante/{dni}")
    public void delete(@PathVariable Long dni) {
        this.estudianteService.deleteById(dni);
    }
}
