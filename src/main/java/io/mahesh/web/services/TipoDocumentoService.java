package io.mahesh.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.mahesh.web.model.TipoDocumento;
import io.mahesh.web.repository.TipoDocumentoRepository;


@Service
@Transactional(readOnly=true)
public class TipoDocumentoService {
	@Autowired
	private TipoDocumentoRepository repository;

	@Transactional
	public TipoDocumento registrar(TipoDocumento reg) {
		return repository.save(reg);
	}
	@Transactional
	public void deleteById(Integer idTipoDocumento) {
		repository.deleteById(idTipoDocumento);
	}
	@Transactional
	public TipoDocumento update(TipoDocumento reg) {
		return repository.save(reg);
	}
	public TipoDocumento findById(Integer id) {
		return repository.findById(id).get();
	}
	public List<TipoDocumento> findAll() {
		return repository.findAll();
	}
	public Page<TipoDocumento> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
