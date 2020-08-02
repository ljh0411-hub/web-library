package com.ljh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljh.entity.Book;
import com.ljh.entity.Borrow;
import com.ljh.entity.Reader;
import com.ljh.service.BookService;
import com.ljh.service.impl.BookServiceImpl;

/**
 * @description:加载图书数据 
 * @author: ljh
 * @date: Created in 2020年4月25日 下午1:50:40

 */
@WebServlet("/book")
public class BookServlet extends HttpServlet{
	
	
	private BookService bookService =new BookServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		if(method == null) {
			method ="findAll";
		}
		HttpSession session =req.getSession();
		Reader reader = (Reader) session.getAttribute("reader");
		switch (method) {
		case "findAll":
			String pageStr = req.getParameter("page");
			Integer page = Integer.parseInt(pageStr);
			List<Book> list = bookService.findAll(page);
			req.setAttribute("list",list);
	        req.setAttribute("dataPrePage",6);
	        req.setAttribute("currentPage",page);
	        req.setAttribute("pages",bookService.getPages());
	        req.getRequestDispatcher("index.jsp").forward(req,resp);
	        break;
		case "addBorrow":
			String bookidStr = req.getParameter("bookid");
			Integer bookid = Integer.parseInt(bookidStr);
			//添加借书请求
			bookService.addBorrow(bookid, reader.getId());
			resp.sendRedirect("/webLibrary/book?method=findAllBorrow&page=1");
			break;
		case "findAllBorrow":
			//展示用户的借书记录
			pageStr = req.getParameter("page");
			page = Integer.parseInt(pageStr);
			List<Borrow> borrowList = bookService.findAllBorrowByReaderId(reader.getId(),page);
			req.setAttribute("list", borrowList);
			req.setAttribute("dataPrePage",6);
	        req.setAttribute("currentPage",page);
	        req.setAttribute("pages",bookService.getBorrowPages(reader.getId()));
			req.getRequestDispatcher("borrow.jsp").forward(req, resp);
			
			break;
		}
		
        
	}
	
	
	
}
