package com.stephen.mvctest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stephen.mvctest.models.Book;
import com.stephen.mvctest.repositories.BookRepository;
@Service
public class BookService {
 // adding the book repository as a dependency
	private final BookRepository bookRepository;
 
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}	
	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}	
	// creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Book updateBook(Long id, String title, String description, String lang, Integer numOfPages) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		Book book;
		if (optionalBook.isPresent()) {
			book = optionalBook.get();
			book.setTitle(title);
			book.setDescription(description);
			book.setLanguage(lang);
			book.setNumberOfPages(numOfPages);
			return bookRepository.save(book);
		} else {
			book = new Book(title, description, lang, numOfPages);
			return bookRepository.save(book);
		}
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}

