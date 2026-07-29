package com.itsqmet.aplicativoweb.repository;

import com.itsqmet.aplicativoweb.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {

    //Para buscar todas las notas que pertenecen a un alumno en especifico
    List<Nota> findByAlumnoId(Long alumnoId);

    //Para buscar notas registradas en una fecha en especifico
    List<Nota> findByFecha(LocalDate fecha);

    //Para buscar las notas de un alumno especifico dentro de una meteria especifica
    List<Nota> findByAlumnoIdAndMateria(Long alumnoId, Long materiaId);

    //Para buscar notas mediante el apellido de un alumno
    List<Nota> findByAlumnoApellidoContainingIgnoreCase(String apellido);

    //Buscar notas ingresadas dentro de un rango de fechas
    List<Nota> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);

}