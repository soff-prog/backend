package com.itsqmet.aplicativoweb.repository;

import com.itsqmet.aplicativoweb.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository <Materia, Long> {

}