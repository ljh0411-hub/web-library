package com.ljh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljh.entity.Admin;
import com.ljh.entity.Reader;

/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020年4月25日 下午8:16:38

 */
@WebFilter("/book")
public class ReaderFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//判断是否有读者登录
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		Reader reader = (Reader) session.getAttribute("reader");
		if(reader == null) {
			response.sendRedirect("login.jsp");
		}else {
			arg2.doFilter(request, response);
		}
		
	}
	
}
