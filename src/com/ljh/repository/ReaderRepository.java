package com.ljh.repository;

import com.ljh.entity.Reader;

/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020��4��24�� ����9:19:29

 */
public interface ReaderRepository {
	public Reader login(String username,String password);
	public int register(String username, String password, String name, String tel, String cardid, String gender);
}
