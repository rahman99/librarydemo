package com.demo.simple.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.simple.model.Book;

public interface BookService extends CrudRepository<Book, String> {

	public List<Book> findByCategoryLike(String category);
	public List<Book> findByTitleOrCategoryLike(String title, String category);
	public List<Book> titleAndCategory(String title, String category);
}
