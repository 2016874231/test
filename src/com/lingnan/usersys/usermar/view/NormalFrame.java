package com.lingnan.usersys.usermar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lingnan.usersys.usermar.domain.UserVo;

public class NormalFrame extends IndexFrame{
	UserVo user = null;
	
	public  NormalFrame(UserVo user) {
		this.user = user;
	}
	
	public void show() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("查询自己的信息---------------1");
			System.out.println("修改自己的信息---------------2");
			System.out.println("退出登陆---------------3");
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
			IndexFrame idf = new IndexFrame();
			switch(i) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				idf.show();
				break;
				
			default:
				System.out.println("您的输入操作不正确，请重新输入");
			}
		}
	}

}
