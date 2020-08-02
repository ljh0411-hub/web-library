package com.ljh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljh.service.LoginService;
import com.ljh.service.impl.LoginServiceImpl;

/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020��4��26�� ����6:09:46

 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	private LoginService loginService = new LoginServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
	    resp.setContentType("text/html;charset=utf-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String cardid = req.getParameter("cardid");
		String gender = req.getParameter("gender");
		int re = loginService.register(username, password, name, tel, cardid, gender);
		if(re == 1) {
			resp.getWriter().write("ע��ɹ����������<a href='login.jsp'>��¼</a>");
		}else {
			resp.getWriter().write("ע��ʧ�ܣ��������<a href='register.jsp'>ע��</a>");
		}
	}
	
}
