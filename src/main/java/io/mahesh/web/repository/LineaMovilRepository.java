package io.mahesh.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mahesh.web.model.LineaMovil;
@Repository
public interface LineaMovilRepository extends JpaRepository<LineaMovil,Integer> {
    
}