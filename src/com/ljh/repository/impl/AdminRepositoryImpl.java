package com.ljh.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ljh.entity.Admin;
import com.ljh.entity.Reader;
import com.ljh.repository.AdminRepository;
import com.ljh.repository.ReaderRepository;
import com.ljh.utils.JDBCTools;

/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020年4月25日 下午12:13:21

 */
public class AdminRepositoryImpl implements AdminRepository {

	@Override
	public Admin login(String username, String password) {
		Connection connection = JDBCTools.getConnection();
		String sql = "select * from bookadmin where username = ? and password = ?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Admin admin = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,username);
			statement.setString(2,password);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				admin = new Admin(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)); 
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JDBCTools.release(connection, statement, resultSet);
		}
		
		return admin;
	}

}
