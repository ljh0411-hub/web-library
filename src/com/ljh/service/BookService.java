package com.ljh.service;

import java.util.List;

import com.ljh.entity.Book;
import com.ljh.entity.Borrow;
/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020年4月25日 下午12:41:52

 */
public interface BookService {
	public List<Book> findAll(int page);
	public int getPages();
	public void addBorrow(Integer bookid,Integer readerid);
	public List<Borrow> findAllBorrowByReaderId(Integer id,Integer page);
	public int getBorrowPages(Integer readerid);
	public List<Borrow> findAllBorrowByState(Integer state,Integer page);
	public int getBorrowPagesByState(Integer state);
	public void handleBorrow(Integer id,Integer state,Integer adminId);
	
}
