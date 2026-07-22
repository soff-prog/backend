package com.itsqmet.aplicativoweb.repository;

import com.itsqmet.aplicativoweb.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}