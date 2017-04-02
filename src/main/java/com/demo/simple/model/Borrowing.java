package com.demo.simple.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Borrowing {

	@Id @GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@ManyToMany
	@JoinTable(name="bookBorrowing",
			   joinColumns=@JoinColumn(name="id_borrowing")
			   )
	private List<Book> book = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="member_id", nullable=false)
	private Member member;
	
	private Date returnBook;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getReturnBook() {
		return returnBook;
	}

	public void setReturnBook(Date returnBook) {
		this.returnBook = returnBook;
	}
	
	
}
