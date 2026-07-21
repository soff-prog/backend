package com.itsqmet.aplicativoweb.service;

import com.itsqmet.aplicativoweb.model.Nota;
import com.itsqmet.aplicativoweb.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public List<Nota> obtenerTodo() {
        return notaRepository.findAll();
    }

    public Optional<Nota> buscarPorId(Long id) {
        return notaRepository.findById(id);
    }

    public Nota crearNota(Nota nota) {
        return notaRepository.save(nota);
    }

    public Optional<Nota> actualizar(Long id, Nota notaActualizado) {
        return notaRepository.findById(id).map(nota -> {
            nota.setCalificacion(notaActualizado.getCalificacion());
            nota.setFecha(notaActualizado.getFecha());
            return notaRepository.save(nota);
        });
    }

    public boolean eliminar(Long id) {
        if (notaRepository.existsById(id)) {
            notaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}