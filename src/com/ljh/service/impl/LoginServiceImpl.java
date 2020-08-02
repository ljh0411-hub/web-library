package com.ljh.service.impl;

import com.ljh.entity.Admin;
import com.ljh.entity.Reader;
import com.ljh.repository.AdminRepository;
import com.ljh.repository.ReaderRepository;
import com.ljh.repository.impl.AdminRepositoryImpl;
import com.ljh.repository.impl.ReaderRepositoryImpl;
import com.ljh.service.LoginService;


/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020年4月24日 下午9:16:01

 */
public class LoginServiceImpl implements LoginService{
	
	private ReaderRepository readerRepository = new ReaderRepositoryImpl();
	private AdminRepository adminRepository = new AdminRepositoryImpl();
	
	@Override
	public Object login(String username, String password,String type) {
		Object object = null;
		switch(type) {
		case "reader":
			object = readerRepository.login(username, password);
			break;
		case "admin":
			object = adminRepository.login(username, password);
			break;
		}
		return object;
	}

	@Override
	public int register(String username, String password, String name, String tel, String cardid, String gender) {
		int re = readerRepository.register(username, password,name,tel,cardid,gender);	
		return re;
	}
	
	
	
}
