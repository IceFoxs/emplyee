package com.yunplus.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yunplus.dao.EmplyeeDao;
import com.yunplus.domain.Employee;
import com.yunplus.util.JdbcUtil;

public class EmployeeDaoImpl implements EmplyeeDao{

	@Override
	public List getAllEmployee() {
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		List list = null;
		try {
			conn=JdbcUtil.getConnection();
		    psta=conn.prepareStatement("select * from employee");
		    rs=psta.executeQuery();
		    list = new ArrayList();
		    while(rs.next()) {
		    	int id = rs.getInt("id");
		    	String name = rs.getString("name");
		    	int salary = rs.getInt("salary");
		    	int job = rs.getInt("job");
		    	Employee e = new Employee(id, name, salary, job);
		    	list.add(e);
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
		return list;
	}

	@Override
	public int deleteEmployee(int id) {
		Connection conn = null;
		int status=0;
		PreparedStatement psta = null;
		try {
			conn=JdbcUtil.getConnection();
		    psta=conn.prepareStatement("delete from employee where id = ?");
		    psta.setInt(1,id);
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
	@Override
	public int updateEmployee(int id, String name, int salary, int job) {
		Connection conn = null;
		int status=0;
		PreparedStatement psta = null;
		try {
			conn=JdbcUtil.getConnection();
		    psta=conn.prepareStatement("update employee set name=? ,salary = ?,job = ? where id =?");
		    psta.setString(1,name);
		    psta.setInt(2, salary);
		    psta.setInt(3,job);
		    psta.setInt(4,id);
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

	@Override
	public Employee findOneEmployee(int eid) {
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		Employee emp = null;
		try {
			conn=JdbcUtil.getConnection();
		    psta=conn.prepareStatement("select * from employee  where id = ?");
		    psta.setInt(1, eid);
		    rs=psta.executeQuery();
		    if(rs.next()) {
		    	int id = rs.getInt("id");
		    	String name = rs.getString("name");
		    	int salary = rs.getInt("salary");
		    	int job = rs.getInt("job");
		    	emp = new Employee(id, name, salary, job);
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
	
		return emp;
	}

	@Override
	public int insertEmployee(int id, String name, int salary, int job) {
		Connection conn = null;
		int status=0;
		PreparedStatement psta = null;
		try {
			conn=JdbcUtil.getConnection();
		    psta=conn.prepareStatement(" insert into employee values(?,?,?,?)");
		    psta.setInt(1,id);
		    psta.setString(2,name);
		    psta.setInt(3, salary);
		    psta.setInt(4,job); 
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
