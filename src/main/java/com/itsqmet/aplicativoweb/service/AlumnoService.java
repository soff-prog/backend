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
    //READ - listar todos
    public List<Alumno> obtenerTodo() {
        return alumnoRepository.findAll();
    }
    //READ- buscar por id con excepción personalizada
    public Optional<Alumno> buscarPorId(Long id) {
        return alumnoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Alumno con id" + id+"no existe")));
    }
    //CREATE - crear alumno con validacion basica
    public Alumno crearAlumno(Alumno alumno)
    {
        if(alumno.getNombre()==null ||alumno.getApellido() ==null){
            throw new IllegalArgumentException("Nombre y Apellido son obligatorio");
        }
        return alumnoRepository.save(alumno);
    }
    //UPDATE-actualizar alumno
    public Optional<Alumno> actualizar(Long id, Alumno alumnoActualizado) {
        return alumnoRepository.findById(id).map(alumno -> {
            alumno.setNombre(alumnoActualizado.getNombre());
            alumno.setApellido(alumnoActualizado.getApellido());
            alumno.setCurso(alumnoActualizado.getCurso());
            return alumnoRepository.save(alumno);})
             .orElseThrow(()-> new IllegalArgumentException("Alumno con id" + id + "no existe")));
    }
    //DELETE- eliminar alumno
    public boolean eliminar(Long id) {
        if (!alumnoRepository.existsById(id)) {
            throw new IllegalArgumentException("Alumno con id "+ id +" no existe");}
            alumnoRepository.deleteById(id);
            return true;
        }


}