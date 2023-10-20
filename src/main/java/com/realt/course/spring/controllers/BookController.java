package com.realt.course.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.realt.course.spring.repositories.BookRepositoory;


@Controller
public class BookController {
	
	private final BookRepositoory bookRepositoory;

	public BookController(BookRepositoory bookRepositoory) {
		super();
		this.bookRepositoory = bookRepositoory;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepositoory.findAll());
		return "books/list";
		
	}
}
