package com.itsqmet.aplicativoweb.repository;

import com.itsqmet.aplicativoweb.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
}
