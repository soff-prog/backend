package com.itsqmet.aplicativoweb.repository;

import com.itsqmet.aplicativoweb.model.Representante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentanteRepository extends JpaRepository<Representante, Long> {
}