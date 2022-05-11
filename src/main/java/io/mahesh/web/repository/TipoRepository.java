package io.mahesh.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mahesh.web.model.Tipo;
@Repository
public interface TipoRepository extends JpaRepository<Tipo,Integer> {
    
}