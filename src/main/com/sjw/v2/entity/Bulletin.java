package com.sjw.v2.entity;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * @Author Kulen
 * @CreateTime 2010-7-20上午10:06:15
 * @Version 1.0
 * @Explanation
 */
@Table("core_bulletin")
public class Bulletin {

	@Id
	private Long oid;

	@Column("bulletin_id")
	private String bulletinId;

	@Column
	private String title;

	@Column
	private String keywords;

	@Column
	private String description;

	@Column
	private boolean top;

	@Column
	private boolean picture;

	@Column
	private int priority;

	@Column("channel_id")
	private String channelId;

	@Column
	private String author;

	@Column
	private BulletinState state;

	@Column("create_time")
	private Date createTime;

	@Column("release_time")
	private Date releaseTime;

	@Column("forbid_time")
	private Date forbidTime;

	@Column("view_number")
	private int viewNumber;

	@Column
	private String memo;

	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPicture() {
		return picture;
	}

	public void setPicture(boolean picture) {
		this.picture = picture;
	}

	public String getBulletinId() {
		return bulletinId;
	}

	public void setBulletinId(String bulletinId) {
		this.bulletinId = bulletinId;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BulletinState getState() {
		return state;
	}

	public void setState(BulletinState state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Date getForbidTime() {
		return forbidTime;
	}

	public void setForbidTime(Date forbidTime) {
		this.forbidTime = forbidTime;
	}

	public int getViewNumber() {
		return viewNumber;
	}

	public void setViewNumber(int viewNumber) {
		this.viewNumber = viewNumber;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
