package com.realt.course.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.realt.course.spring.repositories.AuthorRepository;

@Controller
public class AuthorConntroller {
	
	AuthorRepository authorRepository;
	
	

	public AuthorConntroller(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}



	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		return "author/list";
	}
}
