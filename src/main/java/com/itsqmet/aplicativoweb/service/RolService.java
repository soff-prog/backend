package com.itsqmet.aplicativoweb.service;

import com.itsqmet.aplicativoweb.model.Actividad;
import com.itsqmet.aplicativoweb.model.Rol;
import com.itsqmet.aplicativoweb.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerTodos(){
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerPorId(Long id){
        return rolRepository.findById(id);
    }

    public Rol guardadRol(Rol rol){
        return rolRepository.save(rol);
    }

    public void eliminarRol(Long id){
        rolRepository.deleteById(id);
    }
}
