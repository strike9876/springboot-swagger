package io.mahesh.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="tipo_documento")
public class TipoDocumento {
    @Id
    @GeneratedValue
    @Column(name="id_tipo_documento")
    private int idTipoDocumento;

    private String nombre;
}