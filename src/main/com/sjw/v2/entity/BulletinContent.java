package com.sjw.v2.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * @Author Kulen
 * @CreateTime 2010-6-8上午10:42:44
 * @Version 1.0
 * @Explanation
 */
@Table("core_bulletin_content")
public class BulletinContent {

	@Id
	private Long oid;

	@Column("bulletin_id")
	private String bulletinId;

	@Column
	private String content;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getBulletinId() {
		return bulletinId;
	}

	public void setBulletinId(String bulletinId) {
		this.bulletinId = bulletinId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
