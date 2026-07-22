package com.itsqmet.aplicativoweb.service;
import com.itsqmet.aplicativoweb.model.Alumno;
import com.itsqmet.aplicativoweb.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> obtenerTodos(){
        return  alumnoRepository.findAll();
    }

    public Optional<Alumno> obtenerPorId(Long id){
        return alumnoRepository.findById(id);
    }

    public List<Alumno> obtenerPorCurso(Long cursoId){
        return alumnoRepository.findByCursoId(cursoId);
    }

    public  Alumno gurdarAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    public void eliminarAlumno(Long id){
        alumnoRepository.deleteById(id);
    }
}
