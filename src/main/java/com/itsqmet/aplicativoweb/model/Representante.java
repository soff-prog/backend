package com.itsqmet.aplicativoweb.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
public class Representante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank  (message = "El campo nombre es obligatorio")
    @Size(min = 2, max = 20, message = "El nombre debe tener entre 2 a 20 caracteres")
    private String nombre;

    @NotBlank  (message = "El campo apellido es obligatorio")
    @Size(min = 2, max = 20, message = "El apellido debe tener entre 2 a 20 caracteres")
    @NotBlank
    private String apellido;

    @NotBlank  (message = "El campo identificacion es obligatorio")
    @Size(min = 10, max = 10, message = "La identificacion solo debe tener 10 digitos")
    @Column(unique = true, nullable = false, length = 10)
    private String identificacion;


    @NotBlank(message = "El campo telefono es obligatorio")
    @Pattern(
            regexp = "^09\\d{8}$",
            message = "El teléfono debe tener 10 dígitos y comenzar con 09")
    @Column(length = 10)
    private String telefono;

    @Email(message = "Ingrese un correo electronico valido")
    @NotBlank(message = "El campo correo es obligatorio")
    private String correo;


    @NotBlank (message = "El campo parestesco es obligatorio")
    @Size(min = 3, max = 30, message = "El parentesco debe tener entre 3 y 30 caracteres")
    @Pattern(
            regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$",
            message = "El parentesco solo puede contener letras")
    private String parentesco;

 @NotBlank(message = "El campo estudiante es obligatorio")
 @Size(min = 2, max = 20, message = "El nombre del estudiante debe tener 2 a 20 caracteres")
    private String estudiante;

    @NotBlank(message = "El campo curso es obligatorio")
    @Size(min = 2, max = 50, message = "El curso debe tener entre 2 y 50 caracteres")
    private String curso;

}
