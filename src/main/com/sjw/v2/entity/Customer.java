package com.sjw.v2.entity;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * @Author Kulen
 * @CreateTime 2010-6-8上午08:58:43
 * @Version 1.0
 * @Explanation
 */
@Table("core_customer")
public class Customer {
	
	//会员的通用信息
	@Id
	private Long oid;

	@Column("customer_id")
	private String customerId;
	
	private boolean available;
	
	@Column("employee")
	private boolean employee;

	@Column("user_name")
	private String userName;
	
	@Column("nick_name")
	private String nickName;
	
	private String originalPassword;
	
	@Column
	private String password;
	
	private String confirmPassword;
	
	@Column
	private String gender;
	
	@Column
	private Date birthday;
	
	@Column("create_time")
	private Date createTime;
	
	@Column
	private String email;
	
	@Column("email_authentication")
	private boolean emailAuthentication;
	
	@Column
	private String qq;
	
	@Column
	private String msn;
	
	@Column
	private String yahooMessenger;
	
	@Column
	private String blog;
	
	@Column
	private String weibo;
	
	@Column("favorite_food")
	private String favoriteFood;
	
	@Column("style_cooking")
	private String styleCooking;
	
	@Column
	private String signet;
		
	//会员的私人的信息
	@Column("real_name")
	private String realName;
	
	@Column
	private String cell;
	
	@Column
	private String phone;
	
	@Column("identity_card_id")
	private String identityCardId;
	
	@Column("post_code")
	private String postCode;
	
	@Column
	private String address;
	
	@Column
	private String diploma;
	
	@Column
	private String major;
	
	private String headPortrait;

	public Customer() {
		this.emailAuthentication = false;
		this.available = true;
		this.employee = false;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public boolean isEmployee() {
		return employee;
	}

	public void setEmployee(boolean employee) {
		this.employee = employee;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getIdentityCardId() {
		return identityCardId;
	}

	public void setIdentityCardId(String identityCardId) {
		this.identityCardId = identityCardId;
	}

	public String getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public String getStyleCooking() {
		return styleCooking;
	}

	public void setStyleCooking(String styleCooking) {
		this.styleCooking = styleCooking;
	}

	public String getDiploma() {
		return diploma;
	}

	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}

	public String getSignet() {
		return signet;
	}

	public void setSignet(String signet) {
		this.signet = signet;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getYahooMessenger() {
		return yahooMessenger;
	}

	public void setYahooMessenger(String yahooMessenger) {
		this.yahooMessenger = yahooMessenger;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getOriginalPassword() {
		return originalPassword;
	}

	public void setOriginalPassword(String originalPassword) {
		this.originalPassword = originalPassword;
	}

	public boolean isEmailAuthentication() {
		return emailAuthentication;
	}

	public void setEmailAuthentication(boolean emailAuthentication) {
		this.emailAuthentication = emailAuthentication;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
}
