package com.ljh.repository;

import java.util.List;

import com.ljh.entity.Book;

/**
 * @description: 
 * @author: ljh
 * @param 
 * @date: Created in 2020��4��25�� ����1:05:27

 */
public interface BookRepository {
	public List<Book> findAll(int index,int limit);
	public int count();
	
}
