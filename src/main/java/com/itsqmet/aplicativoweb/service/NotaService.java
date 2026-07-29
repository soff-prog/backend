package com.itsqmet.aplicativoweb.service;


import com.itsqmet.aplicativoweb.exception.NotaNoEncontradaException;
import com.itsqmet.aplicativoweb.exception.DatosInvalidosException;
import com.itsqmet.aplicativoweb.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    //READ- listar notas
    public List<Nota> obtenerTodo() {
        return notaRepository.findAll();
    }

    //READ- buscar por ID con excepción personalizada
    public Nota buscarPorId(Long id) {
        return notaRepository.findById(id)
                .orElseThrow(() -> new NotaNoEncontradaException(id));
    }

    //CREATE- crear nota con validación
    public Nota crearNota(Nota nota) {
        if (nota.getCalificacion() == null || nota.getFecha() == null) {
            throw new DatosInvalidosException("La calificación y la fecha son obligatorios");
        }
        return notaRepository.save(nota);
    }

    //UPDATE- actualizar nota
    public Nota actualizar(Long id, Nota notaActualizada) {
        return notaRepository.findById(id).map(nota -> {
            nota.setCalificacion(notaActualizada.getCalificacion());
            nota.setFecha(notaActualizada.getFecha());
            return notaRepository.save(nota);
        }).orElseThrow(() -> new NotaNoEncontradaException(id));
    }

    //DELETE- eliminar nota
    public boolean eliminar(Long id) {
        if (!notaRepository.existsById(id)) {
            throw new NotaNoEncontradaException(id);
        }
        notaRepository.deleteById(id);
        return true;
    }
}