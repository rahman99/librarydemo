package com.demo.simple.service;

import org.springframework.data.repository.CrudRepository;

import com.demo.simple.model.MemberShip;

public interface MemberService extends CrudRepository<MemberShip, String> {

}
