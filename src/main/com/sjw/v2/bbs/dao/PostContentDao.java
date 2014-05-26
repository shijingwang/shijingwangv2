package com.sjw.v2.bbs.dao;

import org.nutz.ioc.loader.annotation.IocBean;

import com.sjw.v2.bbs.entity.Post;
import com.sjw.v2.bbs.entity.PostContent;
import com.sjw.v2.dao.SJWDao;

@IocBean(singleton = false, create = "initial")
public class PostContentDao extends SJWDao<PostContent> {

	public void initial() {
		super.initialCon();
		super.initialType(PostContent.class);
	}
}
