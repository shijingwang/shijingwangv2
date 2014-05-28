package com.sjw.v2.dao;

import org.nutz.ioc.loader.annotation.IocBean;

import com.sjw.v2.entity.Website;

@IocBean(singleton = false, create = "initial")
public class WebsiteDao extends SJWDao<Website> {

	public void initial() {
		super.initialCon();
		super.initialType(Website.class);
	}
}
