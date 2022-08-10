package com.myapp.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.thymeleaf.dao.EmployeRepository;
import com.myapp.thymeleaf.entity.Employe;

@Service
public class EmployeServiceImpl implements EmployeService {
	
	private EmployeRepository employeRepository;

	@Autowired
	public EmployeServiceImpl(EmployeRepository employeRepository) {
		this.employeRepository = employeRepository;
	}

	@Override
	public List<Employe> afficher() {
		return employeRepository.findAll();
	}

	@Override
	public Employe trouverId(int id) {
		Optional<Employe> result = employeRepository.findById(id);
		
		Employe emp = null;
		
		if (result.isPresent()) {
			emp = result.get();
		} else {
			throw new RuntimeException("N'a pas trouvé l'id de l'employé - " + id);
		}
		return emp;
	}

	@Override
	public void sauvegarder(Employe emp) {
		employeRepository.save(emp);
	}

	@Override
	public void supprimer(int id) {
		employeRepository.deleteById(id);
	}

}
