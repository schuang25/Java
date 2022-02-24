package com.stephen.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.stephen.savetravels.models.Expense;
import com.stephen.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	private final ExpenseService expenseService;
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@GetMapping("/expenses")
	public String index(Model model,
			@ModelAttribute("expense") Expense expense) {
		model.addAttribute("expenses", expenseService.allExpenses());
		return "index.jsp";
	}
	
	@PostMapping("/expenses/create")
	public String create(Model model,
			@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("expenses", expenseService.allExpenses());
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(Model model,
			@ModelAttribute("expense") Expense expense,
			@PathVariable("id") Long id) {
		model.addAttribute("id", id);
		model.addAttribute("expense", expenseService.findExpense(id));
		return "edit.jsp";
	}
	
	@PutMapping("/expenses/update/{id}")
	public String update(Model model,
			@Valid @ModelAttribute("expense") Expense expense, BindingResult result,
			@PathVariable("id") Long id) {
		if (result.hasErrors()) {
			model.addAttribute("id", id);
			model.addAttribute("expense", expenseService.findExpense(id));
			return "edit.jsp";
		} else {
			expenseService.updateExpense(id, expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		model.addAttribute("e", expenseService.findExpense(id));
		return "show.jsp";
	}
	
	@DeleteMapping("/expenses/{id}")
	public String destroy(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
}
