package com.demo.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.simple.model.BookAvailability;
import com.demo.simple.service.BookAvailibilityService;

@RestController
@RequestMapping("/api/book/availablity")
public class BookAvailablelityController {

	@Autowired
	private BookAvailibilityService bookAvailibilityService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String save(@RequestBody BookAvailability b){
		String value = null;
		try {
			bookAvailibilityService.save(b);
			value = "data has been saved";
		} catch (Exception e) {
			value = "data failed to save";
			e.printStackTrace();
		}
				
		return value;
	}
}
