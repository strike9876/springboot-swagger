package io.mahesh.web.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipo")
    private int idTipo;

    private String nombre;
}