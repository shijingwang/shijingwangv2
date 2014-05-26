package com.sjw.v2.bbs.dao;

import org.nutz.ioc.loader.annotation.IocBean;

import com.sjw.v2.bbs.entity.PostRevert;
import com.sjw.v2.dao.SJWDao;

@IocBean(singleton = false, create = "initial")
public class PostRevertDao extends SJWDao<PostRevert> {

	public void initial() {
		super.initialCon();
		super.initialType(PostRevert.class);
	}
}
