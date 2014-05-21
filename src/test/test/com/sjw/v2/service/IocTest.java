package test.com.sjw.v2.service;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;

import com.sjw.v2.service.DbConPool;
import com.sjw.v2.service.UserService;

public class IocTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Ioc ioc = new NutIoc(new ComboIocLoader(
				"*org.nutz.ioc.loader.json.JsonLoader",
				"core.js", 
				"*org.nutz.ioc.loader.annotation.AnnotationIocLoader", 
				"com.sjw.v2.service"
				)); 
		UserService us = ioc.get(UserService.class);
		DbConPool pool = ioc.get(DbConPool.class);
		System.out.println(pool.getParams());
	}
}
