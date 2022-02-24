package com.stephen.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stephen.dojosninjas.models.Dojo;
import com.stephen.dojosninjas.models.Ninja;
import com.stephen.dojosninjas.services.DojoService;
import com.stephen.dojosninjas.services.NinjaService;

@Controller
public class MainController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	public MainController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newdojo.jsp";
	}
	
	@GetMapping("ninjas/new")
	public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "newninja.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(Model model, @PathVariable("id") Long id) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "showdojo.jsp";
	}
	
	@PostMapping("/dojos/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors())
			return "newdojo.jsp";
		else {
			Long id = dojoService.createDojo(dojo).getId();
			return "redirect:/dojos/" + id;
		}
	}
	
	@PostMapping("ninjas/create")
	public String createNinja(Model model, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoService.allDojos());
			return "newninja.jsp";
		} else {
			Long id = ninjaService.createNinja(ninja).getDojo().getId();
			return "redirect:/dojos/" + id;
		}
	}
}
