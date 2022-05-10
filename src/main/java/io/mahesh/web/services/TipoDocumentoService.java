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
		TipoDocumento tipoDocumento = reg;
		return repository.save(tipoDocumento);
	}
	@Transactional
	public void delete(TipoDocumento reg) {
		repository.delete(reg);
	}
	@Transactional
	public TipoDocumento update(TipoDocumento reg) {
		TipoDocumento tipoDocumento = reg;
		return repository.save(tipoDocumento);
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
