package test.com.sjw.v2.service;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.log.Logs;

import com.sjw.v2.service.UserService;
import com.sjw.v2.util.MyLog4jLogAdapter;

public class IocTest {

	public static void main(String[] args) throws ClassNotFoundException {
		//MyLog4jLogAdapter mla = new MyLog4jLogAdapter();
		//Logs.setAdapter(mla);
		Ioc ioc = new NutIoc(new ComboIocLoader(
				"*org.nutz.ioc.loader.json.JsonLoader",
				"core.js", 
				"*org.nutz.ioc.loader.annotation.AnnotationIocLoader", 
				"com.sjw.v2.service"
				)); 
		UserService us = ioc.get(UserService.class);
		System.out.println(us.getUser());
	}
}
