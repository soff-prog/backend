package com.itsqmet.aplicativoweb.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Entity
@lombok
@NoArgsConstructor
@Table(
        uniqueConstraints = @UniqueConstraint(
        columnNames = {"alumno_id","fecha", "material_id"}
        ))

public class Asistencia {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;
    @NotNull (message ="El campo fecha es obligatoria")
    @PastOrPresent(message = "La fecha no puede ser futura")
    private LocalDate fecha;

    @NotBlank (message = "El campo estado es obligatorio")
    @Pattern(
            regexp = "Presente|Ausente|Justificado|Atraso",
            message = "El estado debe ser: Presente, Ausente, Justificado o Atraso"
    )
    private String estado;

    @Size(max=200, message= "La observacopm no puede superar las 500 caracteres")
    @Column(length = 500)
    private String  observacion;

    @NotNull(message = "Debe seleccionar un alumno")
    @ManyToOne(optional = false)
    @JoinColumn(name = "alumno_id", nullable = false)
    @JsonIgnoreProperties({"RepresentanteRegistro"})
    private Alumno alumno;

    @NotNull(message = "Debe selecionar una materia")
    @ManyToOne(optional = false)
    @JoinColumn(name = "materia_id", nullable = false)
    @JsonIgnoreProperties({"docente"})
    private Materia materia;

}
