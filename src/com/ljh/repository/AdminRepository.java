package com.ljh.repository;

import com.ljh.entity.Admin;

/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020��4��25�� ����12:11:29

 */
public interface AdminRepository {
	public Admin login(String username,String password);
}
