package com.sjw.v2.bbs.vo;

import java.util.Date;

import com.sjw.v2.entity.Customer;

/**
 * @Author Kulen
 * @CreateTime 2010-4-27上午12:12:38
 * @Version 1.0
 * @Explanation 系统运行信息
 */
public class BbsRunInfo {

	/**
	 * 总的在线人数
	 */
	private int totalOnline;

	/**
	 * 注册会员数
	 */
	private int totalCustomerNumber;

	/**
	 * 会员在线人数
	 */
	private int customerOnline;

	/**
	 * 游客在线人数
	 */
	private int guestOnline;

	/**
	 * 今日新贴
	 */
	private int newPostTodayNumber;
	
	/**
	 * 最近注册的会员
	 */
	private Customer lastRegisterCustomer;

	/**
	 * 总的帖子数量
	 */
	private int totalPostNumber;

	
	/**
	 * 最后更新的时间
	 */
	private Date lastUpdateTime;
	
	private static final long UPDATE_CYCLE = 1000L * 60L * 5L;
	
	//使其时间小于当前时间５分钟，如果超过５分钟，数据读取的时候会进行相应的更新
	public BbsRunInfo(){
		lastUpdateTime = new Date(System.currentTimeMillis() - UPDATE_CYCLE - 1000L);
	}
	
	public boolean isRequireUpdate(){
		return System.currentTimeMillis() - lastUpdateTime.getTime() > UPDATE_CYCLE;
	}

	public Customer getLastRegisterCustomer() {
		return lastRegisterCustomer;
	}

	public void setLastRegisterCustomer(Customer lastRegisterCustomer) {
		this.lastRegisterCustomer = lastRegisterCustomer;
	}

	public int getTotalOnline() {
		return totalOnline;
	}

	public void setTotalOnline(int totalOnline) {
		this.totalOnline = totalOnline;
	}

	public int getTotalCustomerNumber() {
		return totalCustomerNumber;
	}

	public void setTotalCustomerNumber(int totalCustomerNumber) {
		this.totalCustomerNumber = totalCustomerNumber;
	}

	public int getCustomerOnline() {
		return customerOnline;
	}

	public void setCustomerOnline(int customerOnline) {
		this.customerOnline = customerOnline;
	}

	public int getGuestOnline() {
		return guestOnline;
	}

	public void setGuestOnline(int guestOnline) {
		this.guestOnline = guestOnline;
	}

	public int getNewPostTodayNumber() {
		return newPostTodayNumber;
	}

	public void setNewPostTodayNumber(int newPostTodayNumber) {
		this.newPostTodayNumber = newPostTodayNumber;
	}

	public int getTotalPostNumber() {
		return totalPostNumber;
	}

	public void setTotalPostNumber(int totalPostNumber) {
		this.totalPostNumber = totalPostNumber;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
