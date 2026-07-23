package com.itsqmet.aplicativoweb.controller;
import com.itsqmet.aplicativoweb.model.Alumno;
import com.itsqmet.aplicativoweb.model.Representante;
import com.itsqmet.aplicativoweb.service.RepresentanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/representantes")
@CrossOrigin(origins = "*")
public class RepresentanteController {

    @Autowired
    private RepresentanteService representanteService;

    @GetMapping
    public ResponseEntity<List<Representante>> listarTodos() {
        return ResponseEntity.ok(representanteService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Representante> obtenerPorId(@PathVariable Long id) {
        return representanteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/curso/{representanteId}")
    public ResponseEntity<List<Alumno>> listarPorCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(representanteService.obtenerPorCurso(cursoId));
    }

    @PostMapping
    public ResponseEntity<Representante> guardar(@RequestBody Representante representante) {
        return ResponseEntity.status(HttpStatus.CREATED).body(representanteService.guardarRepresentante(representante));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizar(@PathVariable Long id, @RequestBody Representante representante) {
        return representanteService.obtenerPorId(id)
                .map(a -> {
                    representante.setId(id);
                    return ResponseEntity.ok(representanteService.guardarRepresentante(representante));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (representanteService.obtenerPorId(id).isPresent()) {
            representanteService.eliminarRepresentante(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
