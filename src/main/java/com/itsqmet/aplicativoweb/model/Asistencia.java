package com.itsqmet.aplicativoweb.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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
@Table(
        uniqueConstraints = @UniqueConstraint(
        columnNames = {"alumno_id","fecha", "material_id"}
        ))

public class Asistencia {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;
    @NotNull private LocalDate fecha;
    @NotBlank private String estado;
    @Column(length = 500) private String  observacion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "alumno_id")
    @JsonIgnoreProperties({"RepresentanteRegistro"})
    private Alumno alumno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "materia_id")
    @JsonIgnoreProperties({"docente"})
    private Materia materia;

}
