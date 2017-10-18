package com.yunplus.util;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
public class JdbcUtil {
     private static DataSource data ;
     static {
    	 Properties  prop = new Properties();
    	 try {
			prop.load(JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			data = DruidDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
		}
     }
     public static Connection getConnection() {
    	 	Connection conn = null;
    	 	try {
				conn = data.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 	return conn;
     }
}
