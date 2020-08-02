package com.ljh.repository;

import com.ljh.entity.Admin;

/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020年4月25日 下午12:11:29

 */
public interface AdminRepository {
	public Admin login(String username,String password);
}
