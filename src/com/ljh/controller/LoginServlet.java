package com.ljh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljh.entity.Admin;
import com.ljh.entity.Book;
import com.ljh.entity.Borrow;
import com.ljh.entity.Reader;
import com.ljh.service.BookService;
import com.ljh.service.LoginService;
import com.ljh.service.impl.BookServiceImpl;
import com.ljh.service.impl.LoginServiceImpl;

/**
 * @description: 处理登录的业务逻辑
 * @author: ljh
 * @date: Created in 2020年4月24日 下午8:46:02

 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	private LoginService loginService = new LoginServiceImpl();
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
	    resp.setContentType("text/html;charset=utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String type = req.getParameter("type");
		Object object = loginService.login(username, password,type);
		if(object != null) {
			HttpSession session = req.getSession();
			switch(type){
				case "reader":
					Reader reader = (Reader) object;
					session.setAttribute("reader", reader);
					resp.sendRedirect("/webLibrary/book?page=1");
					break;
				case "admin":
					Admin admin = (Admin) object;
					session.setAttribute("admin", admin);
					resp.sendRedirect("admin?method=findAllBorrow&page=1");
					break;	
			}
		}else {
			resp.getWriter().write("用户名或密码错误，请重新<a href='login.jsp'>登录</a>");
		}
		
	}
	
}
