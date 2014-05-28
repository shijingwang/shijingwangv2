package com.sjw.v2.dao;

import org.nutz.ioc.loader.annotation.IocBean;

import com.sjw.v2.entity.Customer;

@IocBean(singleton = false, create = "initial")
public class CustomerDao extends SJWDao<Customer> {

	public void initial() {
		super.initialCon();
		super.initialType(Customer.class);
	}

	public Customer findByEmail(String email) {
		return dao.fetch(Customer.class, email);
	}
}
