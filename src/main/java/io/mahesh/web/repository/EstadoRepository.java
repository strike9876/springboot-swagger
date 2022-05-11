package io.mahesh.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mahesh.web.model.Estado;
@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer> {
    
}