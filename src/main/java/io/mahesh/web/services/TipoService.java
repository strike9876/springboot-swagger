package io.mahesh.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.mahesh.web.model.Tipo;
import io.mahesh.web.repository.TipoRepository;


@Service
@Transactional(readOnly=true)
public class TipoService {
	@Autowired
	private TipoRepository repository;

	@Transactional
	public Tipo registrar(Tipo reg) {
		return repository.save(reg);
	}
	@Transactional
	public void deleteById(Integer idTipo) {
		repository.deleteById(idTipo);
	}
	@Transactional
	public Tipo update(Tipo reg) {
		return repository.save(reg);
	}
	public Tipo findById(Integer id) {
		return repository.findById(id).get();
	}
	public List<Tipo> findAll() {
		return repository.findAll();
	}
	public Page<Tipo> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
