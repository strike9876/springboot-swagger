package io.mahesh.web.model;
import javax.persistence.*;

import lombok.Data;
@Entity
@Data
@Table(name="linea_movil")
public class LineaMovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_linea_movil")
    private int idLineaMovil;

    @Column(name="nro_telefono")
    private int nroTelefono;
    
    @ManyToOne
    @JoinColumn(name="id_estado")
    private Estado estado;
    
    @ManyToOne
    @JoinColumn(name="id_tipo")
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name="id_plan")
    private Plan plan;
}