package io.mahesh.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.mahesh.web.model.Estado;
import io.mahesh.web.repository.EstadoRepository;


@Service
@Transactional(readOnly=true)
public class EstadoService {
	@Autowired
	private EstadoRepository repository;

	@Transactional
	public Estado registrar(Estado reg) {
		return repository.save(reg);
	}
	@Transactional
	public void deleteById(Integer idEstado) {
		repository.deleteById(idEstado);
	}
	@Transactional
	public Estado update(Estado reg) {
		return repository.save(reg);
	}
	public Estado findById(Integer id) {
		return repository.findById(id).get();
	}
	public List<Estado> findAll() {
		return repository.findAll();
	}
	public Page<Estado> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
