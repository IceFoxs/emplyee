package com.yunplus.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.yunplus.dao.UserDao;
import com.yunplus.domain.User;
import com.yunplus.util.JdbcUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUser(String username) {
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn=JdbcUtil.getConnection();
		    psta=conn.prepareStatement("select * from user  where username = ?");
		    psta.setString(1,username);
		    rs=psta.executeQuery();
		    if(rs.next()) {
		    	user = new User(rs.getString("username"),rs.getString("password"));
		    }
		}catch(Exception e) {
		   
		}
		finally {
			 if (rs != null) {
			        try {
			            rs.close();
			        } catch (SQLException ex) {
			            // ignore
			        }
			    }

			    if (psta != null) {
			        try {
			        	psta.close();
			        } catch (SQLException ex) {
			            // ignore
			        }
			    }

			    if (conn != null) {
			        try {
			        	conn.close();
			        } catch (SQLException ex) {
			            // ignore
			        }
			    }
		}
       return user;
	}

	@Override
	public int addUser(String username, String password) {
		Connection conn = null;
		int status=0;
		PreparedStatement psta = null;
		try {
			conn=JdbcUtil.getConnection();
		    psta=conn.prepareStatement(" insert into user values(?,?)");
		    psta.setString(1,username);
		    psta.setString(2,password);
		    status=psta.executeUpdate();
		}
		catch(Exception e) {	
		}
		finally {
			    if (psta != null) {
			        try {
			        	psta.close();
			        } catch (SQLException ex) {
			            // ignore
			        }
			    }
			    if (conn != null) {
			        try {
			        	conn.close();
			        } catch (SQLException ex) {
			            // ignore
			        }
			    }
		}
		return status;	
	}

}
