package com.demo.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.simple.model.MemberShip;
import com.demo.simple.service.MemberService;


@RestController
@RequestMapping("/api/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Iterable<MemberShip> getAll(){
		return memberService.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String save(@RequestBody MemberShip m){
		String value = null;
		try {
			memberService.save(m);
			value = "data has been saved";
		} catch (Exception e) {
			value = "data failed to save";
			e.printStackTrace();
		}
				
		return value;
	}
}
