package com.sjw.v2.service;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(singleton = true)
public class DbConPool {

	@Inject("java:$config.get('shijingwang.db.url')")
	private String url;

	private String root;

	private String password;

	public String getParams() {

		return url;
	}
}
