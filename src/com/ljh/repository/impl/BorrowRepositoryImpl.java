package com.ljh.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ljh.entity.Book;
import com.ljh.entity.Borrow;
import com.ljh.entity.Reader;
import com.ljh.repository.BorrowRepository;
import com.ljh.utils.JDBCTools;


/**
 * @description: 
 * @author: ljh
 * @date: Created in 2020年4月25日 下午6:11:30

 */
public class BorrowRepositoryImpl implements BorrowRepository {

	@Override
	public void insert(Integer bookid, Integer readerid, String borrowtime, String returntime, Integer adminid,
			Integer state) {
		Connection connection = JDBCTools.getConnection();
		String sql = "INSERT INTO borrow(bookid,readerid,borrowtime,returntime,state) VALUES(?,?,?,?,0)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,bookid);
			preparedStatement.setInt(2, readerid);
			preparedStatement.setString(3, borrowtime);
			preparedStatement.setString(4, returntime);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JDBCTools.release(connection, preparedStatement,null);
		}	
	}

	
	@Override
	public List<Borrow> findAllByReaderId(Integer id,Integer index,Integer limit) {
		Connection connection = JDBCTools.getConnection();
        String sql = "select br.id,b.name,b.author,b.publish,br.borrowtime,br.returntime,r.name,r.tel,r.cardid,br.state from borrow br,book b,reader r where readerid = ? and b.id = br.bookid and r.id = br.readerid GROUP BY id DESC limit ?,?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Borrow> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.setInt(2,index);
            statement.setInt(3,limit);
            resultSet = statement.executeQuery();
            //循环
            while(resultSet.next()){
                //取出所有的素材
                list.add(new Borrow(resultSet.getInt(1),
                        new Book(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)),
                        new Reader(resultSet.getString(7),resultSet.getString(8),resultSet.getString(9)),
                        resultSet.getString(5),
                        resultSet.getString(6),
                		resultSet.getInt(10)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return list;
	}


	@Override
	public int count(Integer readerid) {
		Connection connection = JDBCTools.getConnection();
        String sql = "select count(*) from borrow br,book b,reader r where readerid = ? and b.id = br.bookid and r.id = br.readerid";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,readerid);
            resultSet = statement.executeQuery();
            //循环
            if(resultSet.next()){
                //取出所有的素材
               count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return count;
	}


	@Override
	public List<Borrow> findAllByState(Integer state,Integer index,Integer limit) {
		Connection connection = JDBCTools.getConnection();
        String sql = "select br.id,b.name,b.author,b.publish,br.borrowtime,br.returntime,r.name,r.tel,r.cardid,br.state from borrow br,book b,reader r where state = ? and b.id = br.bookid and r.id = br.readerid GROUP BY id DESC limit ?,?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Borrow> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,state);
            statement.setInt(2,index);
            statement.setInt(3,limit);
            resultSet = statement.executeQuery();
            //循环
            while(resultSet.next()){
                //取出所有的素材
                list.add(new Borrow(resultSet.getInt(1),
                        new Book(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)),
                        new Reader(resultSet.getString(7),resultSet.getString(8),resultSet.getString(9)),
                        resultSet.getString(5),
                        resultSet.getString(6),
                		resultSet.getInt(10)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return list;
	}


	@Override
	public int countByState(Integer state) {
		Connection connection = JDBCTools.getConnection();
        String sql = "select count(*) from borrow br,book b,reader r where state = ? and b.id = br.bookid and r.id = br.readerid";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,state);
            resultSet = statement.executeQuery();
            //循环
            if(resultSet.next()){
                //取出所有的素材
               count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return count;
	}


	@Override
	public void handleBorrow(Integer id, Integer state, Integer adminId) {
		Connection connection = JDBCTools.getConnection();
        String sql = "update borrow set state = ?,adminid = ? where id = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,state);
            statement.setInt(2,adminId);
            statement.setInt(3,id);
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,statement,null);
        }
		
	}
	
	
	
	
	
}
