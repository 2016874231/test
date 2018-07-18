package com.lingnan.usersys.usermar.business.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lingnan.usersys.DAO.DaoFactory;
import com.lingnan.usersys.constant.EnumType;
import com.lingnan.usersys.exception.DaoException;
import com.lingnan.usersys.exception.ServiceException;
import com.lingnan.usersys.usermar.business.dao.UserDao;
import com.lingnan.usersys.usermar.domain.UserVo;
import com.lingnan.usersys.util.DBUtil;

public class UserServiceImpl implements UserService{
	/**
	 * 用户service类实例
	 */
     private static UserService userService =  new UserServiceImpl();
     
     /**
      * 构造方法
      */
     private UserServiceImpl() {
    	 
     }
     
     /**
      * 取得用户service实例
      * 
      * @return 实例对象
      */
     public static UserService getInstance() {
    	 return userService;
     }
     
 	/**
 	 * 用户登录
 	 * @param user 用户信息
 	 * @return 用户信息
 	 */
 	public UserVo login(String username, String password) {
 		//声明预编译对象变量，用于进行数据库操作的载体
 		Connection conn = null;
 		UserVo user = null;
 		try {
 			     //调用数据库getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
 			     conn = DBUtil.getConnection();
 			     //调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
 			     UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
 			     //调用dao中的login方法，进行登录操作，结果赋值给登录结果变量
 			     user = userMgrDao.login(username, password);
 		 }catch (DaoException e) {
 			//将自定义异常抛出
 			 throw e;
		    }catch (Exception e) {
		    	//将异常封装成自定义异常并抛出
		    	throw new ServiceException("用户登录错误",e);		    	
 		    }finally {
 		    	//调用DBUtil类中的closeConnection方法关闭连接对象
 		    	DBUtil.closeConnection(conn);
 				
 		    }
 		//返回用户登录结果
 		return user;
 	}
 	
 	/**
 	 * 用户注册
 	 * @param user 用户信息
 	 * @return 用户信息
 	 */
 	public boolean register(UserVo user) {
 		//声明预编译对象变量，用于进行数据库操作的载体
 		Connection conn = null;
 		boolean flag = false;
 		try {
 			     //调用数据库getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
 			     conn = DBUtil.getConnection();
 			     //调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
 			     UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
 			     //调用数据库工具类中的beginTransaction方法，开启事务
 			     DBUtil.beginTransaction(conn);
 			     //设置用户为普通用户
 			     user.setPower("普通用户");
 			     //调用dao的addUser方法，进行数据插入操作，结果赋值给插入结果变量
 			     flag = userMgrDao.addUser(user);
 			     //调用数据库工具类中的committ方法，提交事务
 			     DBUtil.committ(conn);
 		 }catch (DaoException e) {
 			//将自定义异常抛出
 			 throw e;
		    }catch (Exception e) {
		    	//调用数据库工具类中的rollback方法，回滚事务
		    	DBUtil.rollback(conn);
		    	//将异常封装成自定义异常并抛出
		    	throw new ServiceException("用户注册错误",e);		    	
 		    }finally {
 		    	//调用DBUtil类中的closeConnection方法关闭连接对象
 		    	DBUtil.closeConnection(conn);
 				
 		    }
 		//返回用户登录结果
 		return flag;
 	}
}
