package com.itsqmet.aplicativoweb.service;

import com.itsqmet.aplicativoweb.model.Actividad;
import com.itsqmet.aplicativoweb.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ActividadService {
    @Autowired
    private  ActividadRepository actividadRepository;

    public List<Actividad>obtenerTodas(){
        return actividadRepository.findAll();
    }

    public Optional<Actividad>obtenerPorId(Long id){
        return actividadRepository.findById(id);
    }

    public Actividad guardadActvidad(Actividad actividad){
        return actividadRepository.save(actividad);
    }

    public void eliminarActividad(Long id){
        actividadRepository.deleteById(id);
    }
}
