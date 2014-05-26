package com.sjw.v2.bbs.dao;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sjw.v2.bbs.entity.Post;
import com.sjw.v2.bbs.entity.PostState;
import com.sjw.v2.dao.SJWDao;

@IocBean(singleton = false, create = "initial")
public class PostDao extends SJWDao<Post> {

	public void initial() {
		super.initialCon();
		super.initialType(Post.class);
	}
	
	public List<Post> find(Long categoryId, PostState postState){
		return dao.query(Post.class, Cnd.where("category_id", "=", categoryId).and("state", "=", postState.name()));
	}
}
