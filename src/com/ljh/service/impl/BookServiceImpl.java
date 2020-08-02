package com.ljh.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ljh.entity.Book;
import com.ljh.entity.Borrow;
import com.ljh.repository.BookRepository;
import com.ljh.repository.BorrowRepository;
import com.ljh.repository.impl.BookRepositoryImpl;
import com.ljh.repository.impl.BorrowRepositoryImpl;
import com.ljh.service.BookService;


/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020年4月25日 下午1:02:13

 */
public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository = new BookRepositoryImpl();
	private BorrowRepository borrowRepository = new BorrowRepositoryImpl();
	private final int limit = 6;
	
	@Override
	public List<Book> findAll(int page) {
		int index = (page-1)*limit;
		return bookRepository.findAll(index,limit);
	}

	@Override
	public int getPages() {
		int count = bookRepository.count();
		int page =0;
		if(count % limit ==0) {
			page = count/limit;
		}else {
			page = count/limit +1;
		}
		return page;
	}

	@Override
	public void addBorrow(Integer bookid, Integer readerid) {
		//借书时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String borrowTime = simpleDateFormat.format(date);
        //还书时间，借书时间+14天
        Calendar calendar = Calendar.getInstance();
        int dates = calendar.get(Calendar.DAY_OF_YEAR) + 14;
        calendar.set(Calendar.DAY_OF_YEAR, dates);
        Date date2 = calendar.getTime();
        String returnTime = simpleDateFormat.format(date2);
        borrowRepository.insert(bookid,readerid,borrowTime,returnTime,null,0);
			
	}

	@Override
	public List<Borrow> findAllBorrowByReaderId(Integer id,Integer page) {
		int index = (page-1)*limit;
		return borrowRepository.findAllByReaderId(id,index,limit);
	}

	@Override
	public int getBorrowPages(Integer readerid) {
		int count = borrowRepository.count(readerid);
		int page =0;
		if(count % limit ==0) {
			page = count/limit;
		}else {
			page = count/limit +1;
		}
		return page;
	}

	@Override
	public List<Borrow> findAllBorrowByState(Integer state,Integer page) {
		int index = (page-1)*limit;
		return borrowRepository.findAllByState(state,index,limit);
	}

	@Override
	public int getBorrowPagesByState(Integer state) {
		int count = borrowRepository.countByState(state);
		int page =0;
		if(count % limit ==0) {
			page = count/limit;
		}else {
			page = count/limit +1;
		}
		return page;
	}

	@Override
	public void handleBorrow(Integer id, Integer state, Integer adminId) {
		borrowRepository.handleBorrow(id,state,adminId);
		
	}

	
	
	
	

}
