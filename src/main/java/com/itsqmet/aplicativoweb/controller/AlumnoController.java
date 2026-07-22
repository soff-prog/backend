package com.itsqmet.aplicativoweb.controller;

import com.itsqmet.aplicativoweb.model.Alumno;
import com.itsqmet.aplicativoweb.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "*")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> listarTodos() {
        return ResponseEntity.ok(alumnoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerPorId(@PathVariable Long id) {
        return alumnoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Alumno>> listarPorCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(alumnoService.obtenerPorCurso(cursoId));
    }

    @PostMapping
    public ResponseEntity<Alumno> guardar(@RequestBody Alumno alumno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.gurdarAlumno(alumno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizar(@PathVariable Long id, @RequestBody Alumno alumno) {
        return alumnoService.obtenerPorId(id)
                .map(a -> {
                    alumno.setId(id);
                    return ResponseEntity.ok(alumnoService.gurdarAlumno(alumno));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (alumnoService.obtenerPorId(id).isPresent()) {
            alumnoService.eliminarAlumno(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}