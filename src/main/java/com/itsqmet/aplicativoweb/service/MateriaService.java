package com.itsqmet.aplicativoweb.service;

import com.itsqmet.aplicativoweb.model.Materia;
import com.itsqmet.aplicativoweb.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    public MateriaRepository materiaRepository;

    public List<Materia> obtenerTodo() {
        return materiaRepository.findAll();
    }

    public Optional<Materia> buscarPorId(Long id) {
        return materiaRepository.findById(id);
    }

    public Materia crearMateria(Materia materia) {
        return materiaRepository.save(materia);
    }

    public Optional<Materia> actualizar(Long id, Materia materiaActualizado) {
        return materiaRepository.findById(id).map(materia -> {
            materia.setNombre(materiaActualizado.getNombre());
            materia.setDescripcion(materiaActualizado.getDescripcion());
            return materiaRepository.save(materia);
        });
    }

    public boolean eliminar(Long id) {
        if (materiaRepository.existsById(id)) {
            materiaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}