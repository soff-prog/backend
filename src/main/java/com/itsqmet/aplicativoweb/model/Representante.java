package com.itsqmet.aplicativoweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Representante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo nombre es obligatorio")
    @Size(min = 2, max = 20, message = "El nombre debe tener entre 2 y 20 caracteres")
    private String nombre;

    @NotBlank(message = "El campo apellido es obligatorio")
    @Size(min = 2, max = 20, message = "El apellido debe tener entre 2 y 20 caracteres")
    private String apellido;

    @NotBlank(message = "El campo teléfono es obligatorio")
    @Size(min = 10, max = 10, message = "El teléfono debe tener mínimo y máximo 10 caracteres")
    private String telefono;

    @NotBlank(message = "El campo dirección es obligatorio")
    @Size(min = 5, max = 70, message = "La dirección debe tener entre 5 y 70 caracteres")
    private String direccion;

    @NotBlank(message = "El campo correo es obligatorio")
    @Size(min = 10, max = 50, message = "El correo debe tener entre 10 y 50 caracteres")
    private String correo;


    @OneToMany(mappedBy = "representante")
    @JsonIgnore
    private List<Alumno> alumnos;
}