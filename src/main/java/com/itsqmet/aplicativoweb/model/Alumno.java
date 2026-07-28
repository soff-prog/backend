package com.itsqmet.aplicativoweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

import java.util.List;

/**
 * Entidad que representa a un alumno dentro del sistema.
 * Contiene datos personales básicos (nombre, apellido, curso)
 * a demás de su relación con las notas que ha recibido.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La cédula no puede estar vacía")
    @Column(unique = true, length = 10)
    private String cedula;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 carácteres")
    private String nombres;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 carácteres")
    private String apellidos;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser anterior a hoy")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El grado no puede estar vacío")
    @Size(min = 1, max = 20, message = "El grado debe tener entre 1 y 20 caracteres")
    private String grado;

    @NotBlank(message = "El paralelo no puede estar vacío")
    @Pattern(regexp = "[A-Z]", message = "El paralelo debe tener una letra mayúscula (A, B, C...)")
    private String paralelo;

    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "El representante solo debe contener letras y espacios")
    private String representante;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener exactamente 10 dígitos")
    private String telefono;

    private String estado = "Activo";

    @ManyToOne
    @JsonIgnoreProperties({"alumnos"})
    private Representante representanteRegistro;

    @OneToMany(mappedBy = "alumno")
    private List<Nota> notas;

}
