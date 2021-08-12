package com.binu.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.binu.springframework.spring5webapp.domain.Author;
import com.binu.springframework.spring5webapp.domain.Book;
import com.binu.springframework.spring5webapp.domain.Publisher;
import com.binu.springframework.spring5webapp.repository.AuthorRepository;
import com.binu.springframework.spring5webapp.repository.BookRepository;
import com.binu.springframework.spring5webapp.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	
	private final BookRepository bookRepository;
	
	private final PublisherRepository publisherRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
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
		System.out.println("Number of authors: " + authorRepository.count());
		
		Publisher p1 = new Publisher("ACE Publishing","103 Albemarle Drive","Topeka", "KS","49923");
		Publisher p2 = new Publisher("Riverdale Publishing", "213 Sumter Drive","Akron","OH","44215");
		Publisher p3 = new Publisher("Marney Publishing", "857 Kwik Drive","Tallahassee","FL","45652");
		
		// save publisher to the db
		publisherRepository.save(p1);
		publisherRepository.save(p2);
		publisherRepository.save(p3);
		
		System.out.println("Number of publishers: " + publisherRepository.count());
		
	}

	
	
}
