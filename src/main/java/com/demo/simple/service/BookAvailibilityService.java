package com.demo.simple.service;

import org.springframework.data.repository.CrudRepository;

import com.demo.simple.model.BookAvailablity;


public interface BookAvailibilityService extends CrudRepository<BookAvailablity, String> {

}
