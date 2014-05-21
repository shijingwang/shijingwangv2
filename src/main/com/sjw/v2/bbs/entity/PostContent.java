package com.sjw.v2.bbs.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * @Author Kulen
 * @CreateTime 2010-4-26下午07:07:01
 * @Version 1.0
 * @Explanation 帖子的内容
 */
@Table("bbs_post_content")
public class PostContent {

	@Id
	private Long oid;

	@Column("post_id")
	private String postId;

	@Column
	private String content;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
