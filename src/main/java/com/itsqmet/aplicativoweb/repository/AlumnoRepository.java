package com.itsqmet.aplicativoweb.repository;

import com.itsqmet.aplicativoweb.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository < Alumno,Long>{
    Optional<Alumno> findByCedula(String cedula);
}
