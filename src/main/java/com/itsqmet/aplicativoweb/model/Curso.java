package com.itsqmet.aplicativoweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo nombre es obligatorio")
    private String nombre;

    @OneToMany(mappedBy = "curso")
    @JsonIgnoreProperties("curso")
    private List<Docente> docentes;

    @OneToMany(mappedBy = "curso")
    @JsonIgnoreProperties("curso")
    private List<Alumno> alumnos;
}