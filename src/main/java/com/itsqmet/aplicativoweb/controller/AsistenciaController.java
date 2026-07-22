package com.itsqmet.aplicativoweb.controller;

import com.itsqmet.aplicativoweb.model.Asistencia;
import com.itsqmet.aplicativoweb.model.EstadoAsistencia;
import com.itsqmet.aplicativoweb.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
@CrossOrigin(origins = "*")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping
    public ResponseEntity<List<Asistencia>> listarTodas() {
        return ResponseEntity.ok(asistenciaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> obtenerPorId(@PathVariable Long id) {
        return asistenciaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Asistencia> guardar(@RequestBody Asistencia asistencia) {
        Asistencia nuevaAsistencia = asistenciaService.guardarAsistencia(asistencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaAsistencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asistencia> actualizar(@PathVariable Long id, @RequestBody Asistencia asistencia) {
        return asistenciaService.obtenerPorId(id)
                .map(a -> {
                    asistencia.setId(id);
                    return ResponseEntity.ok(asistenciaService.guardarAsistencia(asistencia));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (asistenciaService.obtenerPorId(id).isPresent()) {
            asistenciaService.eliminarAsistencia(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/alumno/{alumnoId}")
    public ResponseEntity<List<Asistencia>> listarPorAlumno(@PathVariable Long alumnoId) {
        return ResponseEntity.ok(asistenciaService.obtenerPorAlumno(alumnoId));
    }

    @GetMapping("/alumno/{alumnoId}/estado/{estado}")
    public ResponseEntity<List<Asistencia>> listarPorAlumnoYEstado(
            @PathVariable Long alumnoId,
            @PathVariable EstadoAsistencia estado) {
        return ResponseEntity.ok(asistenciaService.obtenerPorAlumnoYEstado(alumnoId, estado));
    }
}