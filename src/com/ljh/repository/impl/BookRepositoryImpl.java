package com.ljh.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ljh.entity.Book;
import com.ljh.entity.BookCase;
import com.ljh.repository.BookRepository;
import com.ljh.utils.JDBCTools;


/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020年4月25日 下午1:07:57

 */
public class BookRepositoryImpl implements BookRepository {

	@Override
	public List<Book> findAll(int index,int limit) {
		Connection connection = JDBCTools.getConnection();
		String sql = "SELECT * FROM book,bookcase WHERE book.`bookcaseid`= bookcase.`id` limit ?,?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Book> list = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, index);
			preparedStatement.setInt(2, limit);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				BookCase bookCase = new BookCase(resultSet.getInt(9),resultSet.getString(10));
				Book book = new Book(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getDouble(6),bookCase);
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JDBCTools.release(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public int count() {
		Connection connection = JDBCTools.getConnection();
		String sql = "SELECT count(*) FROM book,bookcase WHERE book.`bookcaseid`= bookcase.`id`";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JDBCTools.release(connection, preparedStatement, resultSet);
		}
		return count;
	}
	
	
	
	
	

}
