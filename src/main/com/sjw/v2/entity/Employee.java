package com.sjw.v2.entity;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * @Author Kulen
 * @CreateTime 2010-5-19上午10:57:25
 * @Version 1.0
 * @Explanation
 */
@Table("core_employee")
public class Employee {

	@Id
	private Long id;

	@Column("customer_id")
	private String customerId;

	@Column
	private boolean available;

	@Name
	@Column("user_name")
	private String userName;

	@Column("real_name")
	private String realName;

	@Column
	private String password;

	@Column
	private String sex;

	@Column
	private String address;

	@Column
	private String cell;

	@Column
	private String phone;

	@Column
	private Date birthday;

	@Column("create_time")
	private Date createTime;

	@Column("memo")
	private String memo;

	public static final String INITIAL_PASSWORD = "111111";

	public Employee() {
		this.available = true;
		this.password = Employee.INITIAL_PASSWORD;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
