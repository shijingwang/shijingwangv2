package com.sjw.v2.dao;

import org.nutz.ioc.loader.annotation.IocBean;

import com.sjw.v2.entity.Employee;

@IocBean(singleton = false, create = "initial")
public class EmployeeDao extends SJWDao<Employee> {

	public void initial() {
		super.initialCon();
		super.initialType(Employee.class);
	}
	
	public Employee findByUserName(String userName){
		return dao.fetch(Employee.class, userName);
	}
}
