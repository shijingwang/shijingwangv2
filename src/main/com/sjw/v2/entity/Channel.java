package com.sjw.v2.entity;

import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * @Author Kulen
 * @CreateTime 2010-6-8上午10:38:19
 * @Version 1.0
 * @Explanation 
 */
@Table("core_channel")
public class Channel {
	
	@Id
	private Long oid;
	
	@Column("channel_id")
	private String channelId;
	
	//页面展示使用
	private String prefix;
	
	private boolean hasChild=false;
	
	@Column
	private String name;
	
	@Column
	private String keywords;
	
	@Column
	private String description;
	
	@Column("access_path")
	private String accessPath;
	
	@Column("index_path")
	private String indexPath;
	
	@Column("priority")
	private int priority;
	
	private Channel parentChannel;
	
	private List<Channel> childChannel;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAccessPath() {
		return accessPath;
	}

	public void setAccessPath(String accessPath) {
		this.accessPath = accessPath;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Channel getParentChannel() {
		return parentChannel;
	}

	public void setParentChannel(Channel parentChannel) {
		this.parentChannel = parentChannel;
	}

	public List<Channel> getChildChannel() {
		return childChannel;
	}

	public void setChildChannel(List<Channel> childChannel) {
		this.childChannel = childChannel;
	}

	public String getIndexPath() {
		return indexPath;
	}

	public void setIndexPath(String indexPath) {
		this.indexPath = indexPath;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}
}
