package com.itsqmet.aplicativoweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"alumno_id", "actividad_id"}
        )
)


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
    @DecimalMin(value = "0.0", inclusive = true, message = "La calificación mínima es 0")
    @DecimalMax(value = "10.0", inclusive = true, message = "La calificación máxima es 10")
    private Double calificacion;

    @Size(max = 500, message = "La observación no puede superar los 500 caracteres")
    private String observacion;

    @NotNull(message = "La fecha de registro no puede ser nula")
    @PastOrPresent(message = "La fecha de registro no puede ser futura")
    private LocalDate fecha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "alumno_id", nullable = false)
    private  Alumno alumno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;
}
