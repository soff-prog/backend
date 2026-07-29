package com.itsqmet.aplicativoweb.controller;

import com.itsqmet.aplicativoweb.model.Actividad;
import com.itsqmet.aplicativoweb.service.ActividadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actividades")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @GetMapping
    public List<Actividad> listar() {
        return actividadService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actividad> obtenerPorId(@PathVariable Long id) {
        return actividadService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Actividad crear(@Valid @RequestBody Actividad actividad) {
        return actividadService.guardarActividad(actividad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actividad> actualizar(@PathVariable Long id, @Valid @RequestBody Actividad actividadDetalles) {
        return actividadService.obtenerPorId(id).map(actividad -> {
            actividad.setNombre(actividadDetalles.getNombre());
            actividad.setTipo(actividadDetalles.getTipo());
            actividad.setPeriodo(actividadDetalles.getPeriodo());
            actividad.setFecha(actividadDetalles.getFecha());
            actividad.setMateria(actividadDetalles.getMateria());
            Actividad actualizada = actividadService.guardarActividad(actividad);
            return ResponseEntity.ok(actualizada);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (actividadService.obtenerPorId(id).isPresent()) {
            actividadService.eliminarActividad(id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }
}
