package io.mahesh.web.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;
@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private int idCliente;

    @Column(name="nombre_completo")
    private String nombreCompleto;
    
    @ManyToOne
    @JoinColumn(name="id_tipo_documento")
    private TipoDocumento tipoDocumento;
    
    @Column(name="nro_documento")
    private int nroDocumento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;
}