package com.lingnan.usersys.controller;

import com.lingnan.usersys.usermar.business.service.UserService;
import com.lingnan.usersys.usermar.business.service.UserServiceImpl;
import com.lingnan.usersys.usermar.domain.UserVo;

public class UserController {
	//声明用户service接口对象，用于业务处理
	UserService userMgrService = UserServiceImpl.getInstance();
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
	public UserVo dologin(String username, String password) {
		UserVo user = null;
		try {
			//调用用户service接口中的login方法，进行用户登录操作
		     user = userMgrService.login(username, password);
		}catch(Exception e){
			//显示异常信息
			System.out.println("用户登录的时候出错了"+e.getMessage());
		}
		return user;
	}
	
	/**
	 * 用户注册
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
	public boolean doregister(UserVo user) {
		boolean flag = false;
		try {
			//调用用户service接口中的register方法，进行用户注册操作
			flag = userMgrService.register(user);
		}catch(Exception e){
			//显示异常信息
			System.out.println("用户注册的时候出错了"+e.getMessage());
		}
		return flag;
	}

}
