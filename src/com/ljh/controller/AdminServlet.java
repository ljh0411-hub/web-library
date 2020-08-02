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
import com.ljh.entity.Borrow;
import com.ljh.service.BookService;
import com.ljh.service.impl.BookServiceImpl;

/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020年4月26日 下午12:16:18

 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

	private BookService bookService = new BookServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		if(method == null) {
			method = "findAllBorrow";
		}
		HttpSession session = req.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		switch(method) {
		case "findAllBorrow":
			String pageStr = req.getParameter("page");
			Integer page = Integer.parseInt(pageStr);
			List<Borrow> borrowList = bookService.findAllBorrowByState(0, page);
			req.setAttribute("list", borrowList);
			req.setAttribute("dataPrePage", 6);
			req.setAttribute("currentPage", page);
			req.setAttribute("pages", bookService.getBorrowPagesByState(0));
			req.getRequestDispatcher("admin.jsp").forward(req, resp);
			break;
		case "handle":
			String IdStr = req.getParameter("id");
			Integer id = Integer.parseInt(IdStr);
			String stateStr = req.getParameter("state");
			Integer state = Integer.parseInt(stateStr);
			bookService.handleBorrow(id, state, admin.getId());
			if(state == 1 || state == 2) {
				resp.sendRedirect("/webLibrary/admin?page=1");
			}
			else if(state == 3)
			{
				resp.sendRedirect("/webLibrary/admin?method=getBorrowed&page=1");
			}
			break;
		case "getBorrowed":
			pageStr = req.getParameter("page");
			page = Integer.parseInt(pageStr);
			borrowList = bookService.findAllBorrowByState(1, page);
			req.setAttribute("list", borrowList);
			req.setAttribute("dataPrePage", 6);
			req.setAttribute("currentPage", page);
			req.setAttribute("pages", bookService.getBorrowPagesByState(1));
			req.getRequestDispatcher("return.jsp").forward(req, resp);
			break;
		}
	
	}
	
}
