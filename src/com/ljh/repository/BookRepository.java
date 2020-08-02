package com.ljh.repository;

import java.util.List;

import com.ljh.entity.Book;

/**
 * @description: 
 * @author: ljh
 * @param 
 * @date: Created in 2020年4月25日 下午1:05:27

 */
public interface BookRepository {
	public List<Book> findAll(int index,int limit);
	public int count();
	
}
