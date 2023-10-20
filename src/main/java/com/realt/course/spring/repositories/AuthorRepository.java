package com.realt.course.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.realt.course.spring.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
