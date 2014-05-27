package test.com.sjw.v2.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(singleton = false)
public class UserService {
	
	static final Logger log = LogManager.getLogger(UserService.class);

	public String getUser(){
		log.info("***************************");
		log.info("获取用户信息:%s", "user");
		return "kulen";
	}
}
