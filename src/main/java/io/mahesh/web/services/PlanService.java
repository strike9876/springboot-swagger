package io.mahesh.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.mahesh.web.model.Plan;
import io.mahesh.web.repository.PlanRepository;


@Service
@Transactional(readOnly=true)
public class PlanService {
	@Autowired
	private PlanRepository repository;

	@Transactional
	public Plan registrar(Plan reg) {
		return repository.save(reg);
	}
	@Transactional
	public void deleteById(Integer idPlan) {
		repository.deleteById(idPlan);
	}
	@Transactional
	public Plan update(Plan reg) {
		return repository.save(reg);
	}
	public Plan findById(Integer id) {
		return repository.findById(id).get();
	}
	public List<Plan> findAll() {
		return repository.findAll();
	}
	public Page<Plan> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
