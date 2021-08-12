package com.binu.springframework.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.binu.springframework.spring5webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book,Long>{

}
