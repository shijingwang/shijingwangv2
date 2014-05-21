package test.com.sjw.v2.service;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;

import com.sjw.v2.bbs.entity.Category;
import com.sjw.v2.service.DbConPool;

public class Daotest {
	public static void main(String args[]) throws ClassNotFoundException {
		Ioc ioc = new NutIoc(new ComboIocLoader(
				"*org.nutz.ioc.loader.json.JsonLoader",
				"core.js", 
				"*org.nutz.ioc.loader.annotation.AnnotationIocLoader", 
				"com.sjw.v2.service"
				)); 
		DbConPool dcp = ioc.get(DbConPool.class);
		Dao dao = new NutDao(dcp.getDataSource());
		Category c = dao.fetch(Category.class, 1);
		System.out.println(c.getName());
		System.out.println(c.getState());
		System.out.println(c.getPostNumber());
		System.out.println(c.getCategoryId());
		c.setOid(null);
		c.setCategoryId("Test1");
		dao.insert(c);
		
	}
}
