package com.itsqmet.aplicativoweb.controller;

import com.itsqmet.aplicativoweb.model.Materia;
import com.itsqmet.aplicativoweb.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materias")
@CrossOrigin(origins = "*")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public ResponseEntity<List<Materia>> listarTodas() {
        return ResponseEntity.ok(materiaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> obtenerPorId(@PathVariable Long id) {
        return materiaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Materia> guardar(@RequestBody Materia materia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaService.guardar(materia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        materiaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}