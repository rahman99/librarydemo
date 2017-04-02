package com.demo.simple.service;

import org.springframework.data.repository.CrudRepository;

import com.demo.simple.model.BookAvailability;


public interface BookAvailibilityService extends CrudRepository<BookAvailability, String> {

}
