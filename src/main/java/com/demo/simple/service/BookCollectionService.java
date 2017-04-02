package com.demo.simple.service;

import org.springframework.data.repository.CrudRepository;

import com.demo.simple.model.BookCollection;

public interface BookCollectionService extends CrudRepository<BookCollection, String>{

}
