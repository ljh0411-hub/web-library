package com.ljh.service;

import com.ljh.entity.Reader;


/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020��4��24�� ����9:08:38

 */
public interface LoginService {
	
	
	public Object login(String username,String password,String type);
	public int register(String username,String password,String name,String tel,String cardid,String gender);
	
}
