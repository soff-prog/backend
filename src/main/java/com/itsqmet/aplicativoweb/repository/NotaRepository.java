package com.itsqmet.aplicativoweb.repository;

import com.itsqmet.aplicativoweb.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository <Nota, Long> {

}