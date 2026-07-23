package com.itsqmet.aplicativoweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo fecha es obligatorio")
    @Size(min = 2, max = 20, message = "La fecha debe tener entre 2 y 20 caracteres")
    private String fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoAsistencia estado;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    @JsonIgnoreProperties("asistencias")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    @JsonIgnoreProperties("asistencias")
    private Docente docente;
}