package com.demo.simple.service;

import org.springframework.data.repository.CrudRepository;

import com.demo.simple.model.Member;

public interface MemberService extends CrudRepository<Member, String> {

}
