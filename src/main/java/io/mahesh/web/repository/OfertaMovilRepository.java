package io.mahesh.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.mahesh.web.model.OfertaMovil;
@Repository
public interface OfertaMovilRepository extends JpaRepository<OfertaMovil,Integer> {
    @Query("select a from OfertaMovil a INNER JOIN a.oferta b INNER JOIN a.lineaMovil c where b.idOferta = ?1 and c.idLineaMovil = ?2")
	OfertaMovil selectByIdOfertaIdLineaMovil(Integer idOferta, Integer idLineaMovil);

    @Query("select om from OfertaMovil om INNER JOIN om.lineaMovil lm where lm.idLineaMovil = ?1")
	List<OfertaMovil> selectByIdLineaMovil(Integer idLineaMovil);
}