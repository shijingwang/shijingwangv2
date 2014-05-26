package com.sjw.v2.entity;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * @Author Kulen
 * @CreateTime 2010-6-28上午01:50:41
 * @Version 1.0
 * @Explanation
 */
@Table("core_favorite")
public class Favorite {

	@Id
	private Long id;

	@Column("favorite_id")
	private String favoriteId;

	@Column("reference_id")
	private String referenceId;

	@Column("customer_id")
	private String customerId;

	@Column
	private FavoriteType type;

	@Column("create_time")
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(String favoriteId) {
		this.favoriteId = favoriteId;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public FavoriteType getType() {
		return type;
	}

	public void setType(FavoriteType type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
