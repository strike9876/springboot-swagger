package io.mahesh.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.mahesh.web.model.ClienteMovil;
import io.mahesh.web.model.request.ClienteMovilRequest;
import io.mahesh.web.repository.ClienteMovilRepository;
import io.mahesh.web.repository.ClienteRepository;
import io.mahesh.web.repository.LineaMovilRepository;

@Service
@Transactional(readOnly=true)
public class ClienteMovilService {
	@Autowired
	private ClienteMovilRepository repository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private LineaMovilRepository lineaMovilRepository;
	
	@Transactional
	public ClienteMovil registrar(ClienteMovilRequest reg) {
		ClienteMovil clienteMovil = mapperClienteMovil(reg);
		return repository.save(clienteMovil);
	}
	@Transactional
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	@Transactional
	public ClienteMovil update(ClienteMovilRequest reg) {
		ClienteMovil clienteMovil = mapperClienteMovil(reg);
		return repository.save(clienteMovil);
	}
	private ClienteMovil mapperClienteMovil(ClienteMovilRequest reg) {
		ClienteMovil clienteMovil = new ClienteMovil();
		clienteMovil.setIdClienteMovil(reg.getIdClienteMovil());
		clienteMovil.setCliente(clienteRepository.findById(reg.getIdCliente()).get());
		clienteMovil.setLineaMovil(lineaMovilRepository.findById(reg.getIdLineaMovil()).get());
		return clienteMovil;
	}
	public ClienteMovil selectByIdClienteIdLineaMovil(Integer idCliente, Integer idLineaMovil) {
		return repository.selectByIdClienteIdLineaMovil(idCliente, idLineaMovil);
	}
	public List<ClienteMovil> findAll() {
		return repository.findAll();
	}
	public Page<ClienteMovil> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
