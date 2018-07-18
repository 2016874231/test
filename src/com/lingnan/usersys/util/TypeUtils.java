package com.lingnan.usersys.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lingnan.usersys.exception.DateException;
import com.lingnan.usersys.exception.EmailException;

public class TypeUtils {
	
	/**
	 * 字符串转为日期
	 * str 指定字符串
	 * 转换后日期
	 */
	public static Date strToDate(String str) {
		Date date = null;
		//设置要格式化的日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//调用parse方法，将字符串解析成指定格式的日期类型
			date = (Date) sdf.parse(str);
		} catch (ParseException e) {
			//将异常封装成自定义异常
			throw new DateException("字符转换日期出错", e);
		}
		//返回转换后的值
		return date;
	}
	
	
	/**
	 * 字符串转为日期
	 * str 指定字符串
	 * 转换后日期
	 */
	public static String dateToStr(Date date) {
		String str = null;
		try {
			//设置要格式化的日期格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//调用format方法，将日期格式转换为字符串
			str = sdf.format(date);
		} catch (Exception e) {
			//将异常封装成自定义异常
			throw new DateException("日期转换字符串出错", e);
		}
		//返回转换后的值
		return str;
	}
	
	/**
	 * 检测邮箱格式
	 * str 指定字符串
	 * 
	 */
	public static boolean checkEmail(String email) {
		boolean b = false;
		try {
			//指定邮箱格式
			Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");
			//与输入的字符串对比，正确返回true，错误返回false
			Matcher m = p.matcher(email);
			b = m.matches();
			//返回布尔值
		} catch (Exception e) {
			//将异常封装成自定义异常
			throw new EmailException("邮箱检测出错", e);
		}
		return b;
	}

	
}
