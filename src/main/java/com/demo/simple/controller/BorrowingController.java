package com.demo.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.simple.model.Borrowing;
import com.demo.simple.service.BorrowingService;

@RestController
@RequestMapping("/api/borrowing")
public class BorrowingController {

	@Autowired
	private BorrowingService borrowingService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Borrowing> getAll(){
		return borrowingService.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String save(@RequestBody Borrowing b){
		String value = null;
		try {
			borrowingService.save(b);
			value = "data has been saved";
		} catch (Exception e) {
			value = "data failed to save";
			e.printStackTrace();
		}
				
		return value;
	}
}
