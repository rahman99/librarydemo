package com.demo.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.simple.model.BookInformation;
import com.demo.simple.service.BookInformationService;

@RestController
@RequestMapping("/api/bookinformation")
public class BookInformationController {

	@Autowired
	private BookInformationService bookinfoService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Iterable<BookInformation> getAll(){
		return bookinfoService.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String save(@RequestBody BookInformation bi){
		String value = null;
		try {
			bookinfoService.save(bi);
			value = "data has been saved";
		} catch (Exception e) {
			value = "data failed to save";
			e.printStackTrace();
		}
				
		return value;
	}
}
