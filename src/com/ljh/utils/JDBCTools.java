package com.ljh.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020年4月24日 下午9:34:43

 */
public class JDBCTools {
	private static DataSource dataSource;
	
	static {
		dataSource = new ComboPooledDataSource("testc3p0");
	}
	
	public static Connection getConnection() {
		Connection connection =null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void release(Connection connection,Statement statement,ResultSet resultSet) {
		try {
			if(connection != null) {
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	//测试JDBCTools是否配置成功
//	public static void main(String[] args) {
//		System.out.println(JDBCTools.getConnection());
//	}
	
	
}
