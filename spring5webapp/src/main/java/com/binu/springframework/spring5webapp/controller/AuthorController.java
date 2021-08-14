package com.binu.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.binu.springframework.spring5webapp.repository.AuthorRepository;

@Controller
public class AuthorController {

	
	private final AuthorRepository authorRepository;
		
	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}

	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		
		model.addAttribute("authors",authorRepository.findAll());
		return "authors/list";
	}
	
	
}
