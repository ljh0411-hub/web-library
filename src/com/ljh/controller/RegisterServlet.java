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
 * @date: Created in 2020年4月26日 下午6:09:46

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
			resp.getWriter().write("注册成功，点击返回<a href='login.jsp'>登录</a>");
		}else {
			resp.getWriter().write("注册失败，点击返回<a href='register.jsp'>注册</a>");
		}
	}
	
}
