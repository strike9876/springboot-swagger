package io.mahesh.web.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.mahesh.web.model.ClienteMovil;
@Repository
public interface ClienteMovilRepository extends JpaRepository<ClienteMovil,Integer> {
    @Query("select a from ClienteMovil a INNER JOIN a.cliente b INNER JOIN a.lineaMovil c where b.idCliente = ?1 and c.idLineaMovil = ?2")
	ClienteMovil selectByIdClienteIdLineaMovil(Integer idCliente, Integer idLineaMovil);

    @Query("select a from ClienteMovil a INNER JOIN a.cliente b where b.idCliente = ?1")
	List<ClienteMovil> selectByIdCliente(Integer idCliente);

    @Query("select a from ClienteMovil a INNER JOIN a.lineaMovil b where b.idLineaMovil = ?1")
	List<ClienteMovil> selectByIdLineaMovil(Integer idLineaMovil);
}