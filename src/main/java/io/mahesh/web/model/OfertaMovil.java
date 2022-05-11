package io.mahesh.web.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="oferta_movil")
public class OfertaMovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_oferta_movil")
    private int idOfertaMovil;

    @ManyToOne
    @JoinColumn(name="id_linea_movil")
    private LineaMovil lineaMovil;

    @ManyToOne
    @JoinColumn(name="id_oferta")
    private Oferta oferta;
}