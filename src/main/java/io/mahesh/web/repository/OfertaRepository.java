package io.mahesh.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mahesh.web.model.Oferta;
@Repository
public interface OfertaRepository extends JpaRepository<Oferta,Integer> {
    
}