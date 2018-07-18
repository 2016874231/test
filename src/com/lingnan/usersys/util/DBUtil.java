package com.lingnan.usersys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lingnan.usersys.exception.DaoException;

public class DBUtil {
	
	/**
	 获取数据库连接 
	 */

	public static Connection getConnection() {
		Connection conn = null;
		try {
			//加载驱动
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			String user = "scott";
			String password = "123456";
			//获得数据库连接
			conn = DriverManager.getConnection(url, user, password);
		}catch (SQLException e) {
			//将异常封装成自定义异常
			//throw new DaoException("不能建立数据库连接", e);
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			//将异常封装成自定义异常
			//throw new DaoException("不能建立数据库连接", e);
			e.printStackTrace();
		} 
		//返回得到的连接对象
		return conn;
	}
	
	
	
	/**
	 *开启事务
	 */
	
	public static void beginTransaction(Connection conn) {
		try {
			//将事务的自动提交模式设为假
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			//将异常封装成自定义异常
			throw new DaoException("开启事务出错", e);
		}
		
	}




	/**
	 *提交事务
	 */
	public static void committ(Connection conn) {
		try {
			//提交事务
			conn.commit();
		} catch (SQLException e) {
			//将异常封装成自定义异常
			throw new DaoException("提交事务出错", e);
		}
		
	}
	
	
	/**
	 *回滚事务
	 */
	public static void rollback(Connection conn) {
		try {
			//回滚事务
			conn.rollback();
		} catch (SQLException e) {
			//将异常封装成自定义异常
			throw new DaoException("回滚事务出错", e);
		}
		
	}
	
	
	/**
	 *关闭链接
	 */
	public static void closeConnection(Connection conn) {
		try {
			//如果数据库连接对象不为空，关闭该对象
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			//将异常封装成自定义异常
			throw new DaoException("关闭连接对象出错", e);
		}
		
	}
	
	
	/**
	 *关闭statement
	 */
	public static void closeStatement(ResultSet rs, Statement stmt) {
		try {
			//如果查询结果对象不为空，关闭该对象
			if(rs != null) {
				rs.close();
			}
			//如果声明对象不为空，关闭该对象
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			//将异常封装成自定义异常
			throw new DaoException("关闭声明对象出错", e);
		}
		
	}
	
}
