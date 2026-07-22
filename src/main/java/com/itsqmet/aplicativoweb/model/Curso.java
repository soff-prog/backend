package com.itsqmet.aplicativoweb.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;


    @OneToMany(mappedBy = "curso")
    private List<Docente> docentes;

    @OneToMany(mappedBy = "curso")
    private List<Alumno> alumnos;

}
