package com.sjw.v2.bbs.entity;

import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * @Author Kulen
 * @CreateTime 2010-4-26下午11:26:52
 * @Version 1.0
 * @Explanation 帖子回复列表
 */
@Table("bbs_post_revert")
public class PostRevert {

	@Id
	private Long oid;

	@Column
	private int floor;

	@Column
	private PostRevertState state;

	@Column("post_id")
	private String postId;
	
	/**
	 * 页面显示使用，不做相应的持久化
	 */
	private String title;

	@Column("post_revert_id")
	private String postRevertId;

	@Column("author_customer_id")
	private String authorCustomerId;

	@Column("author_customer_name")
	private String authorCustomerName;

	@Column
	private String content;

	@Column
	private int up;

	@Column("parent_number")
	private int parentNumber;

	@Column("create_time")
	private Date createTime;

	private PostRevert parentPostRevert;

	private List<PostRevert> childRevert;
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PostRevert)){
			return false;
		}
		PostRevert targetObject = (PostRevert) obj;
		if(targetObject.getPostRevertId().equals(this.postRevertId)){
			return true;
		}
		return false;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public PostRevertState getState() {
		return state;
	}

	public void setState(PostRevertState state) {
		this.state = state;
	}

	public String getPostRevertId() {
		return postRevertId;
	}

	public void setPostRevertId(String postRevertId) {
		this.postRevertId = postRevertId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getParentNumber() {
		return parentNumber;
	}

	public void setParentNumber(int parentNumber) {
		this.parentNumber = parentNumber;
	}

	public PostRevert getParentPostRevert() {
		return parentPostRevert;
	}

	public void setParentPostRevert(PostRevert parentPostRevert) {
		this.parentPostRevert = parentPostRevert;
	}

	public List<PostRevert> getChildRevert() {
		return childRevert;
	}

	public void setChildRevert(List<PostRevert> childRevert) {
		this.childRevert = childRevert;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
