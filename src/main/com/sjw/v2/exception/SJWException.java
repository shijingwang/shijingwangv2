package com.sjw.v2.exception;

import java.util.ArrayList;
import java.util.List;

public class SJWException extends Exception {

	private static final long serialVersionUID = 7645005552128257951L;

	public static final int S_ERR_PARAM = 1;

	public static final int S_ERR_USER = 2;

	public static final int S_ERR_PASSWORD = 3;

	public static final int S_ERR_STATUS = 4;
	
	public static final int S_ERR_EMAIL = 5;

	private int errorCode;

	private Object targetObject;

	private List<String> parameterList;

	public void addParameter(String parameter) {
		if (parameterList == null) {
			parameterList = new ArrayList<String>();
		}
		parameterList.add(parameter);
	}

	public SJWException() {
		super();
	}

	public SJWException(int errorCode) {
		this.errorCode = errorCode;
	}

	public SJWException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public SJWException(String message) {
		super(message);
	}

	public SJWException(String message, Throwable cause) {
		super(message, cause);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public Object getTargetObject() {
		return targetObject;
	}

	public void setTargetObject(Object targetObject) {
		this.targetObject = targetObject;
	}

	public List<String> getParameterList() {
		if (parameterList == null) {
			parameterList = new ArrayList<String>();
		}
		return parameterList;
	}
}
