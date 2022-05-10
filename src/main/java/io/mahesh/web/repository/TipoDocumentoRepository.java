package io.mahesh.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mahesh.web.model.TipoDocumento;
@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento,Integer> {
    
}