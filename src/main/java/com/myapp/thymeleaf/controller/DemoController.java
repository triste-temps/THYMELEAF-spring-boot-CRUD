package com.myapp.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	// Mapper pour "/hello"
	
	@GetMapping("/hello")
	public String Salut (Model mod) {
		
		// Ajout au model de l'attribut "date"
		mod.addAttribute("date", new java.util.Date());
		
		// Nom de la vue
		// Avec spring-boot il recherche automatiquement dans 
		// le dossier /src/main/ressources/templates/helloworld.html
		return "helloworld";
	}

}
