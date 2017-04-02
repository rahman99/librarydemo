package com.demo.simple.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class BookAvailability {

	@Id @GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@ManyToOne
	@JoinColumn(name="bookCollection_id")
	private BookInformation bookInformation;
	private int numberAvailavle;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public BookInformation getBookInformation() {
		return bookInformation;
	}
	public void setBookInformation(BookInformation bookInformation) {
		this.bookInformation = bookInformation;
	}
	public int getNumberAvailavle() {
		return numberAvailavle;
	}
	public void setNumberAvailavle(int numberAvailavle) {
		this.numberAvailavle = numberAvailavle;
	}
	
	
}
