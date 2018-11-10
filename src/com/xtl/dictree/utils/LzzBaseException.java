package com.xtl.dictree.utils;

public class LzzBaseException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 异常编码
	 */
	private String code = "001";
	
	public LzzBaseException(String message){
		super(message);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
