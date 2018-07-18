package com.lingnan.usersys.usermar.business.service;

import com.lingnan.usersys.usermar.domain.UserVo;

public interface UserService {
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
	public UserVo login(String username, String password);
	
	/**
	 * 添加用户
	 * @param user 用户信息
	 * @return 用户信息
	 */
	public boolean register(UserVo user);

}
