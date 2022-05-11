package io.mahesh.web.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_plan")
    private int idPlan;

    private String nombre;
}