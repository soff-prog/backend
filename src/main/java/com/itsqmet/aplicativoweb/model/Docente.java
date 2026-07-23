package com.itsqmet.aplicativoweb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank (message = "El campo nombre es obligatorio")
    @Size (min = 2, max = 20, message = "El nombre debe tener entre 2 y 20 caracteres")
    private String nombre;

    @NotBlank(message = "El campo apellido es obligatorio")
    @Size (min = 2, max = 20, message = "El apellido debe tener entre 2 y 20 caracteres")
    private  String Apellido;

    @NotBlank(message = "El campo asignatura es obligatorio")
    @Size(min = 2, max = 30, message = "La asignatura debe tener entre 2 y 30 caracteres")
    private String asignatura;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
    private List<Asistencia> asistencias;

}
