package com.realt.course.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.realt.course.spring.model.Book;

public interface BookRepositoory extends CrudRepository<Book, Long> {

}
