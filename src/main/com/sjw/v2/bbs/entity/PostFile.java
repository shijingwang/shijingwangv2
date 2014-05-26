package com.sjw.v2.bbs.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * @Author Kulen
 * @CreateTime 2010-4-26下午07:12:39
 * @Version 1.0
 * @Explanation 帖子文件一览表，表明帖子中使用了那些文件
 */
@Table("bbs_post_file_list")
public class PostFile {

	@Id
	private Long id;

	@Column("post_id")
	private Long postId;

	@Column("file_original_name")
	private String fileOriginalName;

	@Column("file_new_name")
	private String fileNewName;

	@Column("storage_path")
	private String storagePath;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getFileOriginalName() {
		return fileOriginalName;
	}

	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}

	public String getFileNewName() {
		return fileNewName;
	}

	public void setFileNewName(String fileNewName) {
		this.fileNewName = fileNewName;
	}

	public String getStoragePath() {
		return storagePath;
	}

	public void setStoragePath(String storagePath) {
		this.storagePath = storagePath;
	}
}
