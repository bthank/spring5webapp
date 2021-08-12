package com.binu.springframework.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.binu.springframework.spring5webapp.domain.Author;
import com.binu.springframework.spring5webapp.domain.Book;
import com.binu.springframework.spring5webapp.repository.AuthorRepository;
import com.binu.springframework.spring5webapp.repository.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	
	private final BookRepository bookRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		 
		Author eric = new Author("Eric","Evans");
		Book dddBook = new Book("Domain Driven Design","123123");
		eric.getBooks().add(dddBook);
		dddBook.getAuthors().add(eric);
		
		// save author and book to the db
		authorRepository.save(eric);
		bookRepository.save(dddBook);
		
		
		Author rod = new Author("Rod","Silver");
		Book aaaBook = new Book("An Adverse Answer","342412");
		rod.getBooks().add(aaaBook);
		aaaBook.getAuthors().add(rod);
		
		// save author and book to the db
		authorRepository.save(rod);
		bookRepository.save(aaaBook);
		
		System.out.println("Started in BootStrap");
		System.out.println("Number of books: " + bookRepository.count());
		
	}

	
	
}
