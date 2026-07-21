package com.itsqmet.aplicativoweb.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "materia")
    private List<Nota> notas;

}
