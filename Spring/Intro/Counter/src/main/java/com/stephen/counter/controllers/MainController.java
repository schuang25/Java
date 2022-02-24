package com.stephen.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null)
			session.setAttribute("count", 0);
		session.setAttribute("count", (Integer)session.getAttribute("count") + 1);
		System.out.println((Integer)session.getAttribute("count"));
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		if (session.getAttribute("count") == null)
			session.setAttribute("count", 0);
		model.addAttribute("counter", (Integer)session.getAttribute("count"));
		return "counter.jsp";
	}
}
