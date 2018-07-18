package com.lingnan.usersys.usermar.business.dao;

import com.lingnan.usersys.DAO.BaseDao;
import com.lingnan.usersys.usermar.domain.UserVo;

public interface UserDao extends BaseDao {
	
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
	public boolean addUser(UserVo user);

}
