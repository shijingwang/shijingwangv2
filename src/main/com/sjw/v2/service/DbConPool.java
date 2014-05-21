package com.sjw.v2.service;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.mchange.v2.c3p0.DataSources;

@IocBean(singleton = true, create = "initialDbConnection")
public class DbConPool {

	@Inject("java:$config.get('shijingwang.db.url')")
	private String url;

	@Inject("java:$config.get('shijingwang.db.user')")
	private String user;

	@Inject("java:$config.get('shijingwang.db.password')")
	private String password;

	DataSource pooled;

	public void initialDbConnection() throws SQLException {
		DataSource unpooled = DataSources.unpooledDataSource(url, user, password);
		pooled = DataSources.pooledDataSource(unpooled);
	}

	public DataSource getDataSource() {
		return pooled;
	}

	//Check Parameter
	public String getParams() {
		return url;
	}
}
