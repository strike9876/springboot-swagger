package io.mahesh.web.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_estado")
    private int idEstado;

    private String nombre;
}