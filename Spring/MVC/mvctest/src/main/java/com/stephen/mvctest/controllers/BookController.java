package com.stephen.mvctest.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.stephen.mvctest.models.Book;
import com.stephen.mvctest.services.BookService;

@Controller
public class BookController {
	private final BookService bookService;
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		model.addAttribute("title", book.getTitle());
		model.addAttribute("description", book.getDescription());
		model.addAttribute("language", book.getLanguage());
		model.addAttribute("pages", book.getNumberOfPages());
		return "show.jsp";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
	}
}
