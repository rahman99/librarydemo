package com.demo.simple.service;

import org.springframework.data.repository.CrudRepository;

import com.demo.simple.model.Borrowing;

public interface BorrowingService extends CrudRepository<Borrowing, String> {

}
