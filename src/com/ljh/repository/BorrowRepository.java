package com.ljh.repository;

import java.util.List;

import com.ljh.entity.Borrow;

/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020年4月25日 下午6:10:35

 */
public interface BorrowRepository {
	public void insert(Integer bookid,Integer readerid,String borrowtime,String returntime,Integer adminid,Integer state);
	public List<Borrow> findAllByReaderId(Integer id,Integer index,Integer limit);
	public int count(Integer readerid);
	public List<Borrow> findAllByState(Integer state,Integer index,Integer limit);
	public int countByState(Integer state);
	public void handleBorrow(Integer id,Integer state,Integer adminId);
	
}
