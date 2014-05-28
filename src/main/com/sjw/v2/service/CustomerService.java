package com.sjw.v2.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sjw.common.security.MD5;
import com.sjw.v2.dao.CustomerDao;
import com.sjw.v2.entity.Customer;
import com.sjw.v2.exception.SJWException;

/**
 * @Author Kulen
 * @CreateTime 2010-5-19上午10:56:41
 * @Version 1.0
 * @Explanation
 */
public class CustomerService {

	static final Logger log = LogManager.getLogger(CustomerService.class);

	private CustomerDao customerDao;

	private WebsiteService websiteService;

	private FileStorageService fileStorageService;

	private MD5 md5;

	public String resetPassword(String email) throws SJWException {
		Customer customer = customerDao.findByEmail(email);
		if (customer == null) {
			log.error("无法发现电子邮件为%s的会员", email);
			throw new SJWException(SJWException.S_ERR_EMAIL, String.format("无法发现电子邮件为%s的会员", email));
		}
		String resetPassword = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
		customer.setPassword(md5.getMD5ofStr(resetPassword));
		customerDao.update(customer);
		return resetPassword;
	}

	public Customer getCustomer(Long customerId) {
		Customer customer = customerDao.findById(customerId);
		return customer;
	}

	// FIXME 效率问题
	public int getTotalCustomerNumber() {
		List<Customer> customerList = customerDao.findAll();
		return customerList.size();
	}

	// FIXME 效率问题
	public Customer getLastRegisterCustomer() {
		List<Customer> customerList = customerDao.findAll();
		Collections.sort(customerList, new CustomerComparator());
		return customerList.get(0);
	}

	// FIXME 攻击编程
	public void registerCustomer(Customer customer) {
		Customer customerCheck = customerDao.findByEmail(customer.getEmail());
		if (customerCheck != null) {
			throw new SJWException(SJWException.S_ERR_EMAIL, "Email[" + customer.getEmail() + "]已经被使用.");
		}
		customer.setPassword(md5.getMD5ofStr(customer.getPassword()));
		customerDao.insert(customer);
	}

	public void forbidCustomer(Long customerId) {
		Customer customer = customerDao.findById(customerId);
		customer.setAvailable(false);
		customerDao.update(customer);
	}

	public void allowCustomer(Long customerId) {
		Customer customer = customerDao.findById(customerId);
		customer.setAvailable(true);
		customerDao.update(customer);
	}

	public void updateCustomer(Customer customer) {
		customerDao.update(customer);
	}

	public void validateCustomer(String email, String password) {
		Customer customer = customerDao.findByEmail(email);
		if (customer == null) {
			throw new SJWException(SJWException.S_ERR_USER, "用户名不存在");
		}
		if (!customer.getPassword().equals(md5.getMD5ofStr(password))) {
			throw new SJWException(SJWException.S_ERR_PASSWORD, "密码不正确");
		}
		if (!customer.isAvailable()) {
			throw new SJWException(SJWException.S_ERR_STATUS, "会员帐号已经被停用");
		}
	}

	public void changePassword(Long customerId, String originalPassword, String newPassword) {
		Customer customer = customerDao.findById(customerId);
		if (customer == null) {
			throw new SJWException(SJWException.S_ERR_PARAM, "无法发现编号为" + customerId + "的会员");
		}
		if (!customer.getPassword().equals(md5.getMD5ofStr(originalPassword))) {
			throw new SJWException(SJWException.S_ERR_PASSWORD, "输入的旧密码错误");
		}
		customer.setPassword(md5.getMD5ofStr(newPassword));
		customerDao.update(customer);
	}

	public String getCustomerHeadPortrait(String customerId) {
		String customerHeadPortrait = fileStorageService.getPictureFile(CommonConstant.FILE_UPLOAD_CUSTOMER_HEAD_PORTRAIT, customerId);
		if (customerHeadPortrait == null || customerHeadPortrait.trim().length() == 0) {
			customerHeadPortrait = "image/noneCustomerHeadPortrait.gif";
		}
		return websiteService.getBasePath() + "/" + customerHeadPortrait;
	}
}
