package com.sjw.v2.service;

import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(singleton = false)
public class UserService {

	public String getUser(){
		return "kulen";
	}
}
