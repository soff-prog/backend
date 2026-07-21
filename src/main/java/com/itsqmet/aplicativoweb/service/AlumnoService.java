package com.itsqmet.aplicativoweb.service;

import com.itsqmet.aplicativoweb.model.Alumno;
import com.itsqmet.aplicativoweb.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> obtenerTodo() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> buscarPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    public Alumno crearAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Optional<Alumno> actualizar(Long id, Alumno alumnoActualizado) {
        return alumnoRepository.findById(id).map(alumno -> {
            alumno.setNombre(alumnoActualizado.getNombre());
            alumno.setApellido(alumnoActualizado.getApellido());
            alumno.setCurso(alumnoActualizado.getCurso());
            return alumnoRepository.save(alumno);
        });
    }

    public boolean eliminar(Long id) {
        if (alumnoRepository.existsById(id)) {
            alumnoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}