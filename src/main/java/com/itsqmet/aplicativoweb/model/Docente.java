package com.itsqmet.aplicativoweb.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, length = 10)
    private String cedula;

    @NotBlank
    private String nombre;
    @NotBlank
    private String Apellido;
    @NotNull
    private LocalDate fechaNacimiento;
    @NotBlank
    private String especialidad;
    @NotBlank
    private String titulo;
    @NotBlank
    private String telefono;

    @Email
    @NotBlank
    @Column(unique = true)
    private String correo;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"permisos"})
    private Rol rol;




}
