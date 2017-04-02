package com.demo.simple.service;

import org.springframework.data.repository.CrudRepository;

import com.demo.simple.model.BookInformation;

public interface BookInformationService extends CrudRepository<BookInformation, String>{

}
