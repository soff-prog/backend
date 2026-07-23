package com.itsqmet.aplicativoweb.repository;

import com.itsqmet.aplicativoweb.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

    //Para buscar materias mediante un alumno en especifico que tiene notas registradas
    List<Materia> findDistinctByNotasAlumnoId(Long alumnoId);

    //Para buscar materias en las que exista alguna calificacion menor a un valor
    List<Materia> findDistinctByNotasCalificacionLessThan(Double calificacion);

    //Para buscar una materia por su nombre ignorando mayúsculas
    Optional<Materia> findByNombreIgnoreCase(String nombre);

    //Para buscar todas las materias ordenadas alfabeticamente
    List<Materia> findAllByOrderByNombreAsc();

    //Para traer las materias que tienen mejores calificaciones registradas ordenado de mejores a peores
    List<Materia> findDistinctByNotasCalificacionGreaterThanOrderByNotasCalificacionDesc(Double calificacion);

}