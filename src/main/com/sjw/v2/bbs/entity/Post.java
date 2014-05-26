package com.sjw.v2.bbs.entity;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * @Author Kulen
 * @CreateTime 2010-4-26下午04:04:14
 * @Version 1.0
 * @Explanation 论坛的贴子
 */
@Table("bbs_post")
public class Post {

	/**
	 * 实体编号
	 */
	@Id
	private Long id;

	@Column("author_customer_id")
	private String authorCustomerId;

	@Column("author_customer_name")
	private String authorCustomerName;

	@Column
	private String title;

	@Column("auto_release")
	private boolean autoRelease;

	@Column("auto_release_time")
	private Date autoReleaseTime;

	@Column("state")
	private PostState state;

	private PostType type;

	@Column
	private boolean revert;

	@Column("has_picture")
	private boolean hasPicture;

	@Column("has_attachment")
	private boolean hasAttachment;

	@Column
	private boolean original;

	@Column
	private boolean top;

	@Column("top_start_time")
	private Date topStartTime;

	@Column("top_stop_time")
	private Date topStopTime;

	@Column
	private int priority;

	@Column("total_view_number")
	private int totalViewNumber;

	@Column("hour_view_number")
	private int hourViewNumber;

	@Column("day_view_number")
	private int dayViewNumber;

	@Column("week_view_number")
	private int weekViewNumber;

	@Column("month_view_number")
	private int monthViewNumber;

	@Column("revert_number")
	private int revertNumber;

	@Column("content_size")
	private int contentSize;

	@Column("revert_customer_id")
	private String revertCustomerId;

	@Column("revert_customer_name")
	private String revertCustomerName;

	@Column("create_time")
	private Date createTime;

	@Column("revert_time")
	private Date revertTime;

	@Column("category_id")
	private Long categoryId;

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Post)) {
			return false;
		}
		Post targetObject = (Post) obj;
		if (targetObject.getId().equals(id)) {
			return true;
		}
		return false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthorCustomerId() {
		return authorCustomerId;
	}

	public void setAuthorCustomerId(String authorCustomerId) {
		this.authorCustomerId = authorCustomerId;
	}

	public String getAuthorCustomerName() {
		return authorCustomerName;
	}

	public void setAuthorCustomerName(String authorCustomerName) {
		this.authorCustomerName = authorCustomerName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAutoRelease() {
		return autoRelease;
	}

	public void setAutoRelease(boolean autoRelease) {
		this.autoRelease = autoRelease;
	}

	public Date getAutoReleaseTime() {
		return autoReleaseTime;
	}

	public void setAutoReleaseTime(Date autoReleaseTime) {
		this.autoReleaseTime = autoReleaseTime;
	}

	public boolean isRevert() {
		return revert;
	}

	public void setRevert(boolean revert) {
		this.revert = revert;
	}

	public boolean isHasPicture() {
		return hasPicture;
	}

	public void setHasPicture(boolean hasPicture) {
		this.hasPicture = hasPicture;
	}

	public boolean isHasAttachment() {
		return hasAttachment;
	}

	public void setHasAttachment(boolean hasAttachment) {
		this.hasAttachment = hasAttachment;
	}

	public boolean isOriginal() {
		return original;
	}

	public void setOriginal(boolean original) {
		this.original = original;
	}

	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public Date getTopStartTime() {
		return topStartTime;
	}

	public void setTopStartTime(Date topStartTime) {
		this.topStartTime = topStartTime;
	}

	public Date getTopStopTime() {
		return topStopTime;
	}

	public void setTopStopTime(Date topStopTime) {
		this.topStopTime = topStopTime;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getTotalViewNumber() {
		return totalViewNumber;
	}

	public void setTotalViewNumber(int totalViewNumber) {
		this.totalViewNumber = totalViewNumber;
	}

	public int getHourViewNumber() {
		return hourViewNumber;
	}

	public void setHourViewNumber(int hourViewNumber) {
		this.hourViewNumber = hourViewNumber;
	}

	public int getDayViewNumber() {
		return dayViewNumber;
	}

	public void setDayViewNumber(int dayViewNumber) {
		this.dayViewNumber = dayViewNumber;
	}

	public int getWeekViewNumber() {
		return weekViewNumber;
	}

	public void setWeekViewNumber(int weekViewNumber) {
		this.weekViewNumber = weekViewNumber;
	}

	public int getMonthViewNumber() {
		return monthViewNumber;
	}

	public void setMonthViewNumber(int monthViewNumber) {
		this.monthViewNumber = monthViewNumber;
	}

	public int getRevertNumber() {
		return revertNumber;
	}

	public void setRevertNumber(int revertNumber) {
		this.revertNumber = revertNumber;
	}

	public long getContentSize() {
		return contentSize;
	}

	public void setContentSize(int contentSize) {
		this.contentSize = contentSize;
	}

	public String getRevertCustomerId() {
		return revertCustomerId;
	}

	public void setRevertCustomerId(String revertCustomerId) {
		this.revertCustomerId = revertCustomerId;
	}

	public String getRevertCustomerName() {
		return revertCustomerName;
	}

	public void setRevertCustomerName(String revertCustomerName) {
		this.revertCustomerName = revertCustomerName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getRevertTime() {
		return revertTime;
	}

	public void setRevertTime(Date revertTime) {
		this.revertTime = revertTime;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public PostState getState() {
		return state;
	}

	public void setState(PostState state) {
		this.state = state;
	}

	public PostType getType() {
		return type;
	}

	public void setType(PostType type) {
		this.type = type;
	}
}
