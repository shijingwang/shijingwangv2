package com.sjw.v2.bbs.dao;

import org.nutz.ioc.loader.annotation.IocBean;

import com.sjw.v2.bbs.entity.Category;
import com.sjw.v2.bbs.entity.Post;
import com.sjw.v2.dao.SJWDao;

@IocBean(singleton = false, create = "initial")
public class CategoryDao extends SJWDao<Category> {

	public void initial() {
		super.initialCon();
		super.initialType(Category.class);
	}
}
