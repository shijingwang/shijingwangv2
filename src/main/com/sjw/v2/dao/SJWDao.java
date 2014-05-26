package com.sjw.v2.dao;

import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.loader.annotation.Inject;

import com.sjw.v2.service.DbConPool;

public class SJWDao<T> {

	@Inject("refer:dbConPool")
	DbConPool dcp;

	protected Dao dao;

	private Class<T> type;

	public void initialType(Class<T> type) {
		this.type = type;
	}

	public void initialCon() {
		dao = new NutDao(dcp.getDataSource());
	}

	public void insert(Object record) {
		dao.insert(record);
	}

	public void update(Object record) {
		dao.update(record);
	}

	public void delete(Object record) {
		dao.delete(record);
	}

	public T findById(Long id) {
		return (T) dao.fetch(type, id);
	}
	
	public List<T> findAll(){
		return (List<T>) dao.query(type, null);
	}
}
