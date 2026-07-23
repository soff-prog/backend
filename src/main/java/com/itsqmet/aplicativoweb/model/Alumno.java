package com.itsqmet.aplicativoweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La cedula es obligatorio")
    @Size(min = 10, max = 10, message = "La cedula debe contener 10 digitos")
    @Column(unique = true)
    private String cedula;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 20, message = "El nombre debe tener tener entre 2 y 20 caracteres")
    private String nombre;

    @NotBlank(message = "El campo apellido es obligatorio")
    @Size(min = 2, max = 20, message = "El apellido debe tener entre 2 y 20 cacarteres")
    private String apellido;

    @NotBlank(message = "El campo direccion es obligatorio")
    @Size(min = 10, max = 70, message = "La direccion deber tener enter 10 y 70 caracteres")
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    @JsonIgnoreProperties("alumnos")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "representante_id")
    @JsonIgnoreProperties("alumnos")
    private Representante representante;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("alumno")
    private List<Asistencia> asistencias;
}