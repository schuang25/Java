package com.stephen.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stephen.bookclub.models.Book;
import com.stephen.bookclub.models.LoginUser;
import com.stephen.bookclub.models.User;
import com.stephen.bookclub.services.BookService;
import com.stephen.bookclub.services.UserService;

@Controller
public class HomeController {
	 
	@Autowired
	private UserService userServ;
	@Autowired
	private BookService bookServ;
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("newUser") User newUser,
		 @ModelAttribute("newLogin") LoginUser newLogin) {
	    model.addAttribute("newUser", new User());
	    model.addAttribute("newLogin", new LoginUser());
	    return "index.jsp";
	}
	
	// LOGIN/REGISTRATION
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
	        BindingResult result, Model model, HttpSession session) {
	    
		User user = userServ.register(newUser, result);
	    
		if(result.hasErrors()) {
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	    
	    session.setAttribute("id", user.getId());
	 
	    return "redirect:/books";
	}
	 
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	        BindingResult result, Model model, HttpSession session) {
	     
	    User user = userServ.login(newLogin, result);
	 
	    if(result.hasErrors()) {
	        model.addAttribute("newUser", new User());
	        return "index.jsp";
	    }
	 
	    session.setAttribute("id", user.getId());
	 
	    return "redirect:/books";
	}
	
	// BOOKS
	@GetMapping("/books")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("id") == null)
			return "redirect:/";
		 
		model.addAttribute("books", bookServ.allBooks());
		return "dashboard.jsp";
	}
	 
	@GetMapping("/books/new")
	public String newBook(Model model, HttpSession session,
			@ModelAttribute("newBook") Book newBook) {
		if (session.getAttribute("id") == null)
			return "redirect:/";
		model.addAttribute("id", session.getAttribute("id"));
		model.addAttribute("newBook", new Book());
		return "newbook.jsp";
	}
	 
	@PostMapping("/books/create")
	public String createBook(Model model, HttpSession session,
			@Valid @ModelAttribute("newBook") Book newBook, BindingResult result) {
		if (session.getAttribute("id") == null)
			return "redirect:/";
		if (result.hasErrors()) {
			model.addAttribute("newBook", newBook);
			return "newbook.jsp";
		}
		newBook.setUser(userServ.findUser((Long)session.getAttribute("id")));
		bookServ.createBook(newBook);
		return "redirect:/books";
	}
	 
	@GetMapping("/books/{id}")
	public String bookInfo(Model model, HttpSession session,
			@PathVariable("id") Long id) {
		if (session.getAttribute("id") == null)
			return "redirect:/";
		model.addAttribute("book", bookServ.findBook(id));
		return "bookinfo.jsp";
	}
	 
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
