package com.ljh.entity;

import java.util.List;

/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020年4月25日 下午12:48:32

 */
public class BookCase {
	private Integer id;
	private String name;
	private List<Book> books;
		
	public BookCase() {
		super();
	}
	
	public BookCase(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
