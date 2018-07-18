package com.lingnan.usersys.exception;

/**
 * service异常类
 * @author dell
 *
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 默认构造方法
	 * @return 
	 */
	public ServiceException() {		
	}

	/**
	 * 构造方法
	 * @param arg0 异常类的详细信息
	 */
	public ServiceException(String arg0) {
		super(arg0);
	}
	
	/**
	 * 
	 * @param arg1 产生异常的原因
	 */
	public ServiceException(Throwable arg1) {
		super(arg1);
	}
	
	/**
	 * 
	 * @param arg0 异常的详细信息
	 * @param arg1 产生异常的原因
	 */
	public ServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
