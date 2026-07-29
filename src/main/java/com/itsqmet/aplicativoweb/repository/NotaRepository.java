package com.itsqmet.aplicativoweb.repository;

import com.itsqmet.aplicativoweb.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface NotaRepository extends JpaRepository<Nota,Long> {
    List<Nota>finByActividadId(Long actividadId);
    Optional<Nota>findByAllumnoIdAndActividadId(Long alumnoId);
}
