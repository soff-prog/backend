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
    //READ-listar todas
    public List<Materia> obtenerTodo() {
        return materiaRepository.findAll();
    }
    //READ- buscar por ID personalizada
    public Optional<Materia> buscarPorId(Long id) {
        return materiaRepository.findById(id)
        .orElseThrow(() -> new MateriaService("Material con id"+id+"no existe"));
    }
    //CREATE- crear materia
    public Materia crearMateria(Materia materia) {
        if(materia.getNombre() == null || materia.getNombre().trim().isEmpty()){
            throw  new IllegalArgumentException("El nombre de la materia es obligatorio");
        }
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