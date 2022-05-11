package io.mahesh.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.mahesh.web.model.OfertaMovil;
import io.mahesh.web.model.request.OfertaMovilRequest;
import io.mahesh.web.repository.OfertaMovilRepository;
import io.mahesh.web.repository.OfertaRepository;
import io.mahesh.web.repository.LineaMovilRepository;

@Service
@Transactional(readOnly=true)
public class OfertaMovilService {
	@Autowired
	private OfertaMovilRepository repository;
	@Autowired
	private OfertaRepository ofertaRepository;
	@Autowired
	private LineaMovilRepository lineaMovilRepository;
	
	@Transactional
	public OfertaMovil registrar(OfertaMovilRequest reg) {
		OfertaMovil ofertaMovil = mapperOfertaMovil(reg);
		return repository.save(ofertaMovil);
	}
	@Transactional
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	@Transactional
	public OfertaMovil update(OfertaMovilRequest reg) {
		OfertaMovil ofertaMovil = mapperOfertaMovil(reg);
		return repository.save(ofertaMovil);
	}
	private OfertaMovil mapperOfertaMovil(OfertaMovilRequest reg) {
		OfertaMovil ofertaMovil = new OfertaMovil();
		ofertaMovil.setIdOfertaMovil(reg.getIdOfertaMovil());
		ofertaMovil.setOferta(ofertaRepository.findById(reg.getIdOferta()).get());
		ofertaMovil.setLineaMovil(lineaMovilRepository.findById(reg.getIdLineaMovil()).get());
		return ofertaMovil;
	}
	public OfertaMovil selectByIdOfertaIdLineaMovil(Integer idOferta, Integer idLineaMovil) {
		return repository.selectByIdOfertaIdLineaMovil(idOferta, idLineaMovil);
	}
	public List<OfertaMovil> findAll() {
		return repository.findAll();
	}
	public Page<OfertaMovil> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
