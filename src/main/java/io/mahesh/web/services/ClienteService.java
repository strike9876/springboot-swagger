package io.mahesh.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.mahesh.web.model.Cliente;
import io.mahesh.web.model.request.ClienteRequest;
import io.mahesh.web.repository.ClienteRepository;
import io.mahesh.web.repository.TipoDocumentoRepository;


@Service
@Transactional(readOnly=true)
public class ClienteService {
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	@Transactional
	public Cliente registrar(ClienteRequest reg) {
		Cliente cliente = mapperCliente(reg);
		return repository.save(cliente);
	}
	@Transactional
	public void deleteById(int idCliente) {
		repository.deleteById(idCliente);
	}
	@Transactional
	public Cliente update(ClienteRequest reg) {
		Cliente cliente = mapperCliente(reg);
		return repository.save(cliente);
	}
	private Cliente mapperCliente(ClienteRequest reg) {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(reg.getIdCliente());
		cliente.setNombreCompleto(reg.getNombreCompleto());
		cliente.setTipoDocumento(tipoDocumentoRepository.findById(reg.getIdTipoDocumento()).get());
		cliente.setFechaNacimiento(reg.getFechaNacimiento());
		return cliente;
	}
	public Cliente findById(Integer id) {
		return repository.findById(id).get();
	}
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	public Page<Cliente> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
}
