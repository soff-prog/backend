package com.itsqmet.aplicativoweb.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Representante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    @Column(unique = true)
    private String identificacion;
    @NotBlank
    private String telefono;
    @Email
    @NotBlank
    private String correo;
    @NotBlank private String parentesco;
    private String estudiante;
    private String curso;

}
