package com.lingnan.usersys.usermar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lingnan.usersys.controller.UserController;
import com.lingnan.usersys.usermar.domain.UserVo;
import com.lingnan.usersys.util.TypeUtils;

public class IndexFrame implements BaseFrame{
	
	public void show() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("欢迎来到CL的用户管理系统");
			System.out.println("---------------------------------------------------");
			System.out.println("1、用户登录");
			System.out.println("2、用户注册");
			System.out.println("3、退出系统");
			int i = -1;
			while(true) {
				try {
					i = Integer.parseInt(br.readLine());
					break;
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					System.out.println("你的输入有误，只能输入1~3的数字");
					System.out.println("请重新输入");
				}
			}
			
			switch(i) {
			case 1:
				this.loginShow();
				break;
			case 2:
				this.addShow("注册");
				break;
			case 3:
				System.out.println("感谢您的使用，欢迎下次继续使用本系统，再见！");
				System.exit(0);
			
			default:
				System.out.println("您的输入操作不正确，请重新输入");
			}
		}
	}
	
	
	public void loginShow() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String username = null;
		String password = null;
		System.out.println("用户登录界面");
		System.out.println("---------------------------------------------------");
		System.out.println("请输入你的用户名:");
		try {
			username = br.readLine();
			System.out.println("请输入您的密码:");
			password = br.readLine();
			UserController uc = new UserController();
			UserVo user = uc.dologin(username, password);
			if(user != null) {
				System.out.println("恭喜登陆成功！");
				System.out.println("---------------------------------------------------");
				AdminFrame af = new AdminFrame(user);
				af.loginSuccShow();
			}
			else {
				System.out.println("登陆失败！请检查您的用户名和密码是否正确");
			}
		}catch(Exception e){
			System.out.println("您的输入有误请重新输入");
		}
		
	}
	
	public void addShow(String type) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if("注册".equals(type)) {		
		System.out.println("用户登录界面");
		System.out.println("---------------------------------------------------");
		}else {
			
		}
		
		System.out.println("请输入您的用户名:");
		try {
			UserVo uv = new UserVo();
			uv.setUsername(br.readLine());
			System.out.println("请输入您的密码:");
			uv.setPassword(br.readLine());
			while(true) {
				System.out.println("请输入您的邮箱:");
				String email = br.readLine();
				if(TypeUtils.checkEmail(email)) {
					uv.setEmail(email);
					break;
				}
			}
//			System.out.println("请输入您的生日(YYYY-MM-DD):");
//			uv.setBirth(TypeUtils.strToDate(br.readLine()));			
			UserController uc = new UserController();
			boolean flag = uc.doregister(uv);
			if(flag) {
				if("注册".equals(type)) {
					System.out.println("恭喜注册成功，请前往登陆");
					System.out.println("---------------------------------------------------");
				}
				else {
					System.out.println("添加用户成功");
				}

			}else {
				if("注册".equals(type)) {
					System.out.println("注册成功");
				}
				else {
					System.out.println("添加用户失败");
				}
			}
		}catch(Exception e){
			System.out.println("您的输入有误请重新输入");
		}
		
	}

}
