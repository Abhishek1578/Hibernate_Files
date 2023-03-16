package com.book;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Book {

	@Id
	private int book_id;
	private String book_name;
	private int book_price;
	private String book_authorname;
	private String Availability;
	final static String Library_name="Central Liabrary";
	public Book() {
		
	}
	public Book(int book_id, String book_name, int book_price, String book_authorname, String availability) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_price = book_price;
		this.book_authorname = book_authorname;
		Availability = availability;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public String getBook_authorname() {
		return book_authorname;
	}
	public void setBook_authorname(String book_authorname) {
		this.book_authorname = book_authorname;
	}
	public String getAvailability() {
		return Availability;
	}
	public void setAvailability(String availability) {
		Availability = availability;
	}
	public static String getLibraryName() {
		return Library_name;
	}
}
