package io.mahesh.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.mahesh.web.model.LineaMovil;
import io.mahesh.web.model.request.LineaMovilRequest;
import io.mahesh.web.repository.EstadoRepository;
import io.mahesh.web.repository.LineaMovilRepository;
import io.mahesh.web.repository.PlanRepository;
import io.mahesh.web.repository.TipoRepository;


@Service
@Transactional(readOnly=true)
public class LineaMovilService {
	@Autowired
	private LineaMovilRepository repository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private PlanRepository planRepository;
	
	@Transactional
	public LineaMovil registrar(LineaMovilRequest reg) {
		LineaMovil lineaMovil = mapperLineaMovil(reg);
		return repository.save(lineaMovil);
	}
	@Transactional
	public void deleteById(int idLineaMovil) {
		repository.deleteById(idLineaMovil);
	}
	@Transactional
	public LineaMovil update(LineaMovilRequest reg) {
		LineaMovil lineaMovil = mapperLineaMovil(reg);
		return repository.save(lineaMovil);
	}
	private LineaMovil mapperLineaMovil(LineaMovilRequest reg) {
		LineaMovil lineaMovil = new LineaMovil();
		lineaMovil.setIdLineaMovil(reg.getIdLineaMovil());
		lineaMovil.setNroTelefono(reg.getNroTelefono());
		lineaMovil.setEstado(estadoRepository.findById(reg.getIdEstado()).get());
		lineaMovil.setTipo(tipoRepository.findById(reg.getIdTipo()).get());
		lineaMovil.setPlan(planRepository.findById(reg.getIdPlan()).get());
		return lineaMovil;
	}
	public LineaMovil findById(Integer id) {
		return repository.findById(id).get();
	}
	public List<LineaMovil> findAll() {
		return repository.findAll();
	}
	public Page<LineaMovil> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
