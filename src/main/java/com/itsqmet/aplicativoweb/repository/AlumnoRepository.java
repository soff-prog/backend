package com.itsqmet.aplicativoweb.repository;

import com.itsqmet.aplicativoweb.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    //Para buscar estudiantes de un curso
    List<Alumno> findByCurso(String curso);

    //Para buscar estudiantes de un curso ordenado alfabeticamente
    List<Alumno> findByCursoOrderByApellioAsc(String curso);

    //Para buscar alumnos por su apellido ignorando si está en mayúscula
    List<Alumno> findByApellidoContainingIgnoreCase(String apellido);

    //Para una busqueda donde se puede escribir el nombre o el apellido
    List<Alumno> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido);

    //Para buscar alumnos que no tengan ninguna nota registrada
    List<Alumno> findByNotasIsEmpty();

    //Para obtener los alumnos que tienen una nota destacada de mayor o igual a cierto valor
    List<Alumno> findDistincByNotasCalificacionGreaterThanEqual(Double calificacion);
}