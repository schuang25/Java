package com.stephen.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class MainController {
	@GetMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/submit")
	public String processForm(HttpSession session,
			@RequestParam(value="number") Integer number,
			@RequestParam(value="city") String city,
			@RequestParam(value="name") String name,
			@RequestParam(value="job") String job,
			@RequestParam(value="thing") String thing,
			@RequestParam(value="nice") String nice) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("job", job);
		session.setAttribute("thing", thing);
		session.setAttribute("nice", nice);
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/show")
	public String show(HttpSession session, Model model) {
		model.addAttribute("number", (Integer)session.getAttribute("number"));
		model.addAttribute("city", (String)session.getAttribute("city"));
		model.addAttribute("name", (String)session.getAttribute("name"));
		model.addAttribute("job", (String)session.getAttribute("string"));
		model.addAttribute("thing", (String)session.getAttribute("thing"));
		model.addAttribute("nice", (String)session.getAttribute("nice"));
		return "show.jsp";
	}
}
