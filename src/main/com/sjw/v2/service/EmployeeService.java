package com.sjw.v2.service;

import java.util.Date;

import com.sjw.common.security.MD5;
import com.sjw.v2.dao.EmployeeDao;
import com.sjw.v2.entity.Employee;
import com.sjw.v2.exception.SJWException;

/**
 * @Author Kulen
 * @CreateTime 2010-6-24下午05:15:24
 * @Version 1.0
 * @Explanation
 */
public class EmployeeService {

	private EmployeeDao employeeDao;

	private MD5 md5;

	public Employee getEmployee(String employeeId) {
		return employeeDao.findById(Long.parseLong(employeeId));
	}

	public void validateEmployee(String userName, String password) throws SJWException {
		Employee employee = employeeDao.findByUserName(userName);
		if (employee == null) {
			throw new SJWException(SJWException.S_ERR_USER, "输入的用户名不存在");
		}
		if (!employee.getPassword().equals(md5.getMD5ofStr(password))) {
			throw new SJWException(SJWException.S_ERR_PASSWORD, "输入的密码错误");
		}
		if (!employee.isAvailable()) {
			throw new SJWException(SJWException.S_ERR_STATUS, "员工的状态不正确");
		}
	}

	public void registerEmployee(Employee employee) {
		employee.setPassword(md5.getMD5ofStr(employee.getPassword()));
		employee.setCreateTime(new Date());
		employeeDao.insert(employee);
	}

	/**
	 * 重置密码
	 * 
	 * @param employeeId
	 */
	public void resetPassword(String employeeId) {
		Employee employee = employeeDao.findById(Long.parseLong(employeeId));
		employee.setPassword(md5.getMD5ofStr(Employee.INITIAL_PASSWORD));
		employeeDao.update(employee);
	}

	/**
	 * 修改密码
	 * 
	 * @param employeeId
	 * @param originalPassword
	 * @param newPassword
	 */
	public void changePassword(String employeeId, String originalPassword, String newPassword) throws SJWException {
		Employee employee = employeeDao.findById(Long.parseLong(employeeId));
		if (!employee.getPassword().equals(md5.getMD5ofStr(originalPassword))) {
			throw new SJWException(SJWException.S_ERR_PASSWORD, "输入的原密码错误");
		}
		employee.setPassword(md5.getMD5ofStr(newPassword));
		employeeDao.update(employee);
	}

	public void updateEmployee(Employee employee) {
		employeeDao.update(employee);
	}
}
