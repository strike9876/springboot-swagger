package io.mahesh.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.mahesh.web.model.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    @Query("select c from Cliente c INNER JOIN c.tipoDocumento td where c.nroDocumento = ?1 and td.idTipoDocumento = ?2")
	List<Cliente> findByNroDocumentoIdTipoDocumento(Integer nroDocumento, Integer idTipoDocumento);
}