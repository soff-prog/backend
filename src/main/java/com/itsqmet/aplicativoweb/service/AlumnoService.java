package com.itsqmet.aplicativoweb.service;

import com.itsqmet.aplicativoweb.exception.AlumnoNoEncontradoException;
import com.itsqmet.aplicativoweb.exception.DatosInvalidosException;
import com.itsqmet.aplicativoweb.model.Alumno;
import com.itsqmet.aplicativoweb.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    // READ - listar todos

    public List<Alumno> obtenerTodo() {
        return alumnoRepository.findAll();
    }

    // READ - buscar por id con excepción personalizada

    public Alumno buscarPorId(Long id) {
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new AlumnoNoEncontradoException(id));
    }

    // CREATE - crear alumno con validación básica

    public Alumno crearAlumno(Alumno alumno) {
        if (alumno.getNombres() == null || alumno.getApellidos() == null) {
            throw new DatosInvalidosException("Nombre y Apellido son obligatorios");
        }
        return alumnoRepository.save(alumno);
    }

    // UPDATE - actualizar alumno

    public Alumno actualizar(Long id, Alumno alumnoActualizado) {
        return alumnoRepository.findById(id).map(alumno -> {
            alumno.setNombres(alumnoActualizado.getNombres());
            alumno.setApellidos(alumnoActualizado.getApellidos());
           // alumno.setCurso(alumnoActualizado.getCurso());
            return alumnoRepository.save(alumno);
        }).orElseThrow(() -> new AlumnoNoEncontradoException(id));
    }

    // DELETE - eliminar alumno
    public boolean eliminar(Long id) {
        if (!alumnoRepository.existsById(id)) {
            throw new AlumnoNoEncontradoException(id);
        }
        alumnoRepository.deleteById(id);
        return true;
    }
}
