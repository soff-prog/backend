package com.itsqmet.aplicativoweb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


/**
 * Entidad que representa a una materia o asignatura.
 * Incluye nombre, descripcion y su relación con las notas
 * que los alumnos obtienen en esta materia
 */

public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "El nombre de la materia no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre de la materia debe tener entre 2 y 50 carácteres")
    private String nombre;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 5, max = 200, message = "La descripcion debe tener entre 5 y 200 carácteres")
    private String descripcion;

    @OneToMany(mappedBy = "materia")
    private List<Nota> notas;

}
