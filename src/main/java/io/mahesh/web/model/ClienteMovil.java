package io.mahesh.web.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="cliente_movil")
public class ClienteMovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente_movil")
    private int idClienteMovil;

    @ManyToOne
    @JoinColumn(name="id_linea_movil")
    private LineaMovil lineaMovil;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
}