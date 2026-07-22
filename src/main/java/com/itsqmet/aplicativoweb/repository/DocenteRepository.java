package com.itsqmet.aplicativoweb.repository;

import com.itsqmet.aplicativoweb.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
    List<Docente> findByCursoId(Long cursoId);
}
