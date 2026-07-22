package com.itsqmet.aplicativoweb.service;

import com.itsqmet.aplicativoweb.model.Docente;
import com.itsqmet.aplicativoweb.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<Docente> obtenerTodos() {
        return docenteRepository.findAll();
    }
    public Optional<Docente> obtenerPorId(Long id) {
        return docenteRepository.findById(id);
    }

    public Docente guardarDocente(Docente docente) {
        return docenteRepository.save(docente);
    }

    public void eliminarDocente(Long id) {
        docenteRepository.deleteById(id);
    }

}
