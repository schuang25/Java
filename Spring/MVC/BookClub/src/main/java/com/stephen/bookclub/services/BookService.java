package com.stephen.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephen.bookclub.models.Book;
import com.stephen.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	public Book findBook(Long id) {
		Optional<Book> potentialBook = bookRepo.findById(id);
		if (potentialBook.isPresent())
			return potentialBook.get();
		else
			return null;
	}
}
