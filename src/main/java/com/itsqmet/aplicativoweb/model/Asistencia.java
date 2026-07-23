package com.itsqmet.aplicativoweb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "El campo fecha es obligatorio")
    @Size(min = 2, max = 20, message = "El nombre debe tener entre 2 y 20 caracteres")
    private String fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoAsistencia estado;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

}



