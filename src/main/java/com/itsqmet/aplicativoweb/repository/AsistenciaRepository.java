package com.itsqmet.aplicativoweb.repository;

import com.itsqmet.aplicativoweb.model.Asistencia;
import com.itsqmet.aplicativoweb.model.EstadoAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
    List<Asistencia> findByAlumnoId(Long alumnoId);
    List<Asistencia> findByAlumnoIdAndEstado(Long alumnoId, EstadoAsistencia estado);
}
