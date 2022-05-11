package io.mahesh.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.mahesh.web.model.Oferta;
import io.mahesh.web.repository.OfertaRepository;


@Service
@Transactional(readOnly=true)
public class OfertaService {
	@Autowired
	private OfertaRepository repository;

	@Transactional
	public Oferta registrar(Oferta reg) {
		return repository.save(reg);
	}
	@Transactional
	public void deleteById(Integer idOferta) {
		repository.deleteById(idOferta);
	}
	@Transactional
	public Oferta update(Oferta reg) {
		return repository.save(reg);
	}
	public Oferta findById(Integer id) {
		return repository.findById(id).get();
	}
	public List<Oferta> findAll() {
		return repository.findAll();
	}
	public Page<Oferta> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
