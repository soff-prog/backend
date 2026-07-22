package com.itsqmet.aplicativoweb.controller;

import com.itsqmet.aplicativoweb.model.Nota;
import com.itsqmet.aplicativoweb.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
@CrossOrigin(origins = "*") // Permite la integración con el frontend
public class NotaController {

    @Autowired
    private NotaService notaService;

    // Obtener todas las notas
    @GetMapping
    public ResponseEntity<List<Nota>> obtenerTodas() {
        List<Nota> notas = notaService.obtenerTodo();
        return ResponseEntity.ok(notas);
    }

    // Obtener nota por ID
    @GetMapping("/{id}")
    public ResponseEntity<Nota> obtenerPorId(@PathVariable Long id) {
        return notaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Guardar o crear una nueva nota
    @PostMapping
    public ResponseEntity<Nota> crearNota(@RequestBody Nota nota) {
        Nota nuevaNota = notaService.guardar(nota);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNota);
    }

    // Actualizar una nota existente
    @PutMapping("/{id}")
    public ResponseEntity<Nota> actualizarNota(@PathVariable Long id, @RequestBody Nota notaDetails) {
        return notaService.obtenerPorId(id)
                .map(notaExistente -> {
                    // Setea los atributos necesarios de Nota
                    notaExistente.setCalificacion(notaDetails.getCalificacion());
                    notaExistente.setAlumno(notaDetails.getAlumno());
                    notaExistente.setMateria(notaDetails.getMateria());
                    Nota actualizada = notaService.guardar(notaExistente);
                    return ResponseEntity.ok(actualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar una nota por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNota(@PathVariable Long id) {
        if (notaService.obtenerPorId(id).isPresent()) {
            notaService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}