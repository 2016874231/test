package com.lingnan.usersys.usermar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lingnan.usersys.usermar.domain.UserVo;

public class AdminFrame extends NormalFrame{
	
	public AdminFrame(UserVo user) {
		super(user);
	}
	
	public void loginSuccShow() {
		System.out.println("欢迎登陆本系统");
		System.out.println(user.getUsername()+"你好"+"       你的权限为:"+user.getPower());
		System.out.println("---------------------------------------------------");
		if(user.getPower().equals("管理员")) {
			this.show();
		}else {
			new NormalFrame(user).show();
		}
	}
	
	public void show() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("添加用户---------------1");
			System.out.println("删除用户---------------2");
			System.out.println("修改用户---------------3");
			System.out.println("查询用户---------------4");
			System.out.println("退出登陆---------------5");
			int i = -1;
			while(true) {
				try {
					i = Integer.parseInt(br.readLine());
					break;
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					System.out.println("你的输入有误，只能输入1~5的数字");
					System.out.println("请重新输入");
				}
			}
			IndexFrame idf = new IndexFrame();
			switch(i) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				idf.show();
				break;
				
			default:
				System.out.println("您的输入操作不正确，请重新输入");
			}
		}
	}

}
