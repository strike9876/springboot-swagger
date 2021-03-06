package io.mahesh.web.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="tipo_documento")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipo_documento")
    private int idTipoDocumento;

    private String nombre;
}