package com.ljh.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ljh.entity.Reader;
import com.ljh.repository.ReaderRepository;
import com.ljh.utils.JDBCTools;

/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020年4月24日 下午9:22:04

 */
public class ReaderRepositoryImpl implements ReaderRepository {

	@Override
	public Reader login(String username, String password) {
		Connection connection = JDBCTools.getConnection();
		String sql = "select * from reader where username = ? and password = ?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Reader reader = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,username);
			statement.setString(2,password);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				reader = new Reader(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)); 
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JDBCTools.release(connection, statement, resultSet);
		}
		
		return reader;
	}

	@Override
	public int register(String username, String password, String name, String tel, String cardid, String gender) {
		Connection connection = JDBCTools.getConnection();
		String sql = "insert into reader(username,password,name,tel,cardid,gender) value(?,?,?,?,?,?)";
		PreparedStatement statement = null;
		int re =0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,username);
			statement.setString(2,password);
			statement.setString(3,name);
			statement.setString(4,tel);
			statement.setString(5,cardid);
			statement.setString(6,gender);
			re = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JDBCTools.release(connection, statement, null);
		}
		return re;
	}
	
	

}
