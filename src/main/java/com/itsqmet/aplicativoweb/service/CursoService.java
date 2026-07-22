package com.itsqmet.aplicativoweb.service;
import com.itsqmet.aplicativoweb.model.Curso;
import com.itsqmet.aplicativoweb.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired CursoRepository cursoRepository;
    public List<Curso> obtenerTodas() {
        return cursoRepository.findAll();
    }
    public Optional<Curso> obtenerPorId(Long id) {
        return cursoRepository.findById(id);
    }
    public Curso guardarCurso (Curso curso){
        return cursoRepository.save(curso);
    }
    public void eliminarCurso (Long id){
        cursoRepository.deleteById(id);
    }





}
