package com.itsqmet.aplicativoweb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


/**
 * Entidad que reprenta a una nota académica.
 * Contiene la calificación (0 a 10) y la fecha en la que fue registrada
 * asimismo las relaciones con el alumno y la materia correspondientes.
 * Se valida lque la fecha no sea futura y que la calificación esté en rango.
 */

public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La calificación no puede ser nula")
    @Min(value = 0, message = "La calificación mínima es 0")
    @Max(value = 10, message = "La calificación máxima es 10")
    private Double calificacion;


    @NotNull(message = "La fecha no puede ser nula")
    @PastOrPresent(message = "La fecha no puede ser futura")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private  Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;
}
