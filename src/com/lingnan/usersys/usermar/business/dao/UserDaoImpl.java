package com.lingnan.usersys.usermar.business.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lingnan.usersys.usermar.domain.UserVo;
import com.lingnan.usersys.util.DBUtil;
import com.lingnan.usersys.util.TypeUtils;




public class UserDaoImpl implements UserDao {
	/**
	 * 数据库连接
	 */
	private Connection conn;
	
	/**
	 * 构造方法
	 * 
	 * @param conn 数据库连接
	 */
	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * 用户登录
	 * @param user 用户信息
	 * @return 用户信息
	 */
	public UserVo login(String username, String password) {
		//声明预编译对象变量，用于进行数据库操作的载体
		PreparedStatement prep = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
	    //声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVo user = null;
		TypeUtils tu = new TypeUtils();
		try {
			     //调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			     prep = conn.prepareStatement("select * from T_user where username = ? and password = ? and status = '1'");
			     //调用预编译对象的setXXX方法，给？赋值
			     prep.setString(1, username);
			     prep.setString(2, password);
			     //调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值结果集对象变量
			     rs=prep.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中     
			if(rs.next()) {
				//创建一个新的用户对象，赋值给用户变量
				user = new UserVo();
				/*
				 *调用结果集的getXXX方法，取出各个字段的值，
				 *然后再调用用户对象的setXXX方法，给用户对象的属性赋值
				 *最后新创建的对象中包含了结果集中所有字段的值 
				 */
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPower(rs.getString("power"));
				user.setBirth(rs.getDate("birth"));
			}
			
		 }catch (SQLException e1) {
				System.out.println("SQL语言运行错误");
				e1.printStackTrace();
		    }finally {
		    	//调用DBUtil类中的closeStatement方法关闭结果集对象和预编译对象
		    	DBUtil.closeStatement(rs, prep);
				
		    }
		return user;
	}

	/**
	 * 用户添加
	 */
	public boolean addUser(UserVo user) {
		//声明预编译对象变量，用于进行数据库操作的载体
		PreparedStatement prep = null;
		//声明结果集对象变量，用于保存数据库查询结果
//		int rs = -1;
	    //声明用户对象变量，用于保存从结果集中提取出来的数据
		boolean flag = false;
		String username = user.getUsername();
		String password = user.getPassword();
		String email = user.getEmail();
		String power = user.getPower();
		try {
			     prep = conn.prepareStatement
			    		 ("insert into T_user( username, password, email, power,  status) values( ?, ?, ?, ?, 1)"); 
		         prep.setString(1, username);
		         prep.setString(2, password);
		         prep.setString(3, email);
		         prep.setString(4, power);
		         prep.setDate(5, new java.sql.Date(user.getBirth().getTime()));
			     prep.executeUpdate();
			     flag = true;
//			     if(rs > 0) {
//			    	 return true;
//			     }else {
//			    	 return false;
//			     }
		 }catch (SQLException e) {
				System.out.println("SQL语言运行错误");
				e.printStackTrace();
		    }finally {
		    	//调用DBUtil类中的closeStatement方法关闭结果集对象和预编译对象
		    	DBUtil.closeStatement(null, prep);
		    }
		return flag;
//		if(user != null) {
//			return true;
//		}else {
//			return false;
//		}
	}
}
