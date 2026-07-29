package com.itsqmet.aplicativoweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotBlank(message = "El nombre de la actividad no puede estar vacío")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private  String nombre;

    @NotBlank(message = "El tipo de actividad no puede estar vacío")
    @Size(min = 2, max = 50, message = "El tipo debe tener entre 2 y 50 caracteres")
    private String tipo;

    @NotBlank(message = "El periodo no puede estar vacío")
    @Pattern(regexp = "^(Q1|Q2|Q3|Q4|Quimestre 1|Quimestre 2)$",
    message = "El peridodo debe ser válido (ej. Q1, Q2)")
    private String periodo;

    @NotNull(message = "La fecha de la actividad es obligatoria")
    @FutureOrPresent(message = "La fecha debe ser hoy o futura")
    private LocalDate fecha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "materia_id", nullable = false)
    @JsonIgnoreProperties({"docente"})
    private Materia materia;

}
