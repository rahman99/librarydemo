package com.demo.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.demo.simple.model.Book;
import com.demo.simple.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Book> getAll(){
		return bookService.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String save(@RequestBody Book b){
		String value = null;
		try {
			bookService.save(b);
			value = "data has been saved";
		} catch (Exception e) {
			value = "data failed to save";
			e.printStackTrace();
		}
				
		return value;
	}
	
	@RequestMapping(value="category={category}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.FOUND)
	public Iterable<Book> findByCategory(@PathVariable("category") String category){
		return bookService.findByCategoryLike(category);
	}
	
	@RequestMapping(value="/title={title}/category={category}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.FOUND)
	public Iterable<Book> findByTitleAndCategory(@PathVariable("title") String title, 
												 @PathVariable("category") String category){
		return bookService.findByTitleOrCategoryLike(title, category);
	}
	
	@RequestMapping(value="/title={title}&category={category}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.FOUND)
	public Iterable<Book> getTitleAndCategory(@PathVariable("title") String title, 
												 @PathVariable("category") String category){
		return bookService.titleAndCategory(title, category);
	}
	
}
