package com.itsqmet.aplicativoweb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

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

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 carácteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 carácteres")
    private String apellido;

    @NotBlank(message = "El curso no puede estar vacío")
    @Size(min = 2, max = 20, message = "El curso debe tener entre 2 y 50 carácteres")
    private String curso;

    @OneToMany(mappedBy = "alumno")
    private List<Nota> notas;

}
