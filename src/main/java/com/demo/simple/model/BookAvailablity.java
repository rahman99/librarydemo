package com.demo.simple.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class BookAvailablity {

	@Id @GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@ManyToMany
	@JoinColumn(name="book_Collection")
	private BookCollection bookCollection;
	private int numberAvailavle;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BookCollection getBookCollection() {
		return bookCollection;
	}
	public void setBookCollection(BookCollection bookCollection) {
		this.bookCollection = bookCollection;
	}
	public int getNumberAvailavle() {
		return numberAvailavle;
	}
	public void setNumberAvailavle(int numberAvailavle) {
		this.numberAvailavle = numberAvailavle;
	}
	
	
}
