package com.myapp.thymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.thymeleaf.entity.Employe;
import com.myapp.thymeleaf.service.EmployeService;

@Controller
@RequestMapping("/employes")
public class EmployeController {
	
	private EmployeService employeService;
	
	// constructor using field
	
	// pas besoin de @Autowired car il n'y a qu'un seul constructeur
	
	public EmployeController(EmployeService employeService) {
		this.employeService = employeService;
	}
	
	
	// mapper "/liste"
	
	@GetMapping("/liste")
	public String listeEmployes(Model mod) {
		
		// déclarer liste pour obtenir les employés de la bdd
		List<Employe> lesEmployes = employeService.afficher();
		
		mod.addAttribute("employes", lesEmployes);
		
		//nom de notre fichier html
		return "employes/liste-employes";
	}
	
	@GetMapping("/afficherFormulaire")
	public String afficherFormulaire(Model mod) {
		
		Employe emp = new Employe();
		
		mod.addAttribute("employe", emp);
		
		return "employes/formulaire-employe";
	}
	
	@PostMapping("/sauvegarder")
	public String sauvegarderEmploye(@ModelAttribute("employe") Employe emp) {
		
		// sauvegarder l'employé
		employeService.sauvegarder(emp);
		
		// rediriger
		return "redirect:/employes/liste";
	}

}
