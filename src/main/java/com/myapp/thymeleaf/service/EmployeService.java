package com.myapp.thymeleaf.service;

import java.util.List;

import com.myapp.thymeleaf.entity.Employe;

public interface EmployeService {

	public List<Employe> afficher();
	
	public Employe trouverId(int id);
	
	public void sauvegarder(Employe emp);
	
	public void supprimer(int id);

}
