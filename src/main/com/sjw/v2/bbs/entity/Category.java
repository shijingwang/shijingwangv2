package com.sjw.v2.bbs.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * @Author Kulen
 * @CreateTime 2010-4-26下午07:33:19
 * @Version 1.0
 * @Explanation 论坛的栏目
 */
@Table("bbs_category")
public class Category {

	@Id
	private Long id;

	@Column
	private String name;

	@Column
	private CategoryState state;

	@Column
	private String keywords;

	@Column
	private String description;

	@Column("post_number")
	private int postNumber;

	@Column
	private int priority;

	@Column
	private String master;

	private List<String> masterIdList;

	@Column("create_time")
	private Date createTime;

	private String titleImage;

	public List<String> getMasterIdList() {
		masterIdList = new ArrayList<String>();
		if (master != null && master.trim().length() > 0) {
			for (String masterId : master.split(",")) {
				masterIdList.add(masterId);
			}
		}
		return masterIdList;
	}

	public void setMasterIdList(List<String> masterIdList) {
		this.masterIdList = masterIdList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public CategoryState getState() {
		return state;
	}

	public void setState(CategoryState state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTitleImage() {
		return titleImage;
	}

	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
}
