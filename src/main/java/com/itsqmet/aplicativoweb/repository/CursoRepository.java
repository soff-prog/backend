package com.itsqmet.aplicativoweb.repository;

import com.itsqmet.aplicativoweb.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
