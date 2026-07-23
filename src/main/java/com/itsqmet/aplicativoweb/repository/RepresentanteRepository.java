package com.itsqmet.aplicativoweb.repository;

import com.itsqmet.aplicativoweb.model.Representante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepresentanteRepository extends JpaRepository <Representante,Long> {
    List<Representante> findByRepresentanteId(Long representanteId);
}
