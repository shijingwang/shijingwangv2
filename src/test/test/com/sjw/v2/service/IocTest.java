package test.com.sjw.v2.service;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;

import com.sjw.v2.bbs.dao.PostDao;
import com.sjw.v2.bbs.entity.Post;

public class IocTest {

	public static void main(String[] args) throws ClassNotFoundException {
		//MyLog4jLogAdapter mla = new MyLog4jLogAdapter();
		//Logs.setAdapter(mla);
		Ioc ioc = new NutIoc(new ComboIocLoader(
				"*org.nutz.ioc.loader.json.JsonLoader", 
				"core.js", 
				"*org.nutz.ioc.loader.annotation.AnnotationIocLoader", 
				"com.sjw.v2.service", 
				"com.sjw.v2.dao", 
				"com.sjw.v2.bbs.dao"));
		UserService us = ioc.get(UserService.class);
		System.out.println(us.getUser());
		PostDao postDao = ioc.get(PostDao.class);
		Post post = postDao.findById(5l);
		System.out.println(post.getAuthorCustomerName());
		System.out.println(post.getTitle());
	}
}
