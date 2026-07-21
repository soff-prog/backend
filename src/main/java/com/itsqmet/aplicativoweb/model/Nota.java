package com.itsqmet.aplicativoweb.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double calificacion;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private  Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;
}
