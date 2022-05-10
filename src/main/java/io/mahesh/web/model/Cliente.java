package io.mahesh.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;


import lombok.Data;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue
    @Column(name="id_cliente")
    private int idCliente;

    @Column(name="nombre_completo")
    private String nombreCompleto;
    
    @ManyToOne
    @JoinColumn(name="id_tipo_documento")
    private TipoDocumento tipoDocumento;
    
    @Column(name="nro_documento")
    private String nroDocumento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;
}