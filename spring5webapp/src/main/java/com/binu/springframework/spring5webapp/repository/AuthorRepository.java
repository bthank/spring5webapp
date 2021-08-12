package com.binu.springframework.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.binu.springframework.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
