package com.itsqmet.aplicativoweb.service;

import com.itsqmet.aplicativoweb.exception.MateriaNoEncontradaException;
import com.itsqmet.aplicativoweb.exception.DatosInvalidosException;
import com.itsqmet.aplicativoweb.model.Materia;
import com.itsqmet.aplicativoweb.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MateriaService {

    @Autowired
    public MateriaRepository materiaRepository;


    //READ-listar todas

    public List<Materia> obtenerTodo() {

        return materiaRepository.findAll();
    }

    //READ- buscar por ID personalizada
    public Materia buscarPorId(Long id) {
        return materiaRepository.findById(id)
        .orElseThrow(() -> new MateriaNoEncontradaException(id));
    }
    //CREATE- crear materia
    public Materia crearMateria(Materia materia) {
        if(materia.getNombre() == null || materia.getNombre().trim().isEmpty()){
            throw  new DatosInvalidosException("El nombre de la materia es obligatorio");
        }
        return materiaRepository.save(materia);
    }

    //UPDATE- actualizar materia
    public Materia actualizar(Long id, Materia materiaActualizada) {
        return materiaRepository.findById(id).map(materia -> {
            materia.setNombre(materiaActualizada.getNombre());
            materia.setDescripcion(materiaActualizada.getDescripcion());
            return materiaRepository.save(materia);
        }).orElseThrow(() -> new MateriaNoEncontradaException(id));
    }

    //DELETE- eliminar materia
    public boolean eliminar(Long id) {
        if (!materiaRepository.existsById(id)) {
            throw  new MateriaNoEncontradaException(id);
        }
        materiaRepository.deleteById(id);
        return true;
    }
}