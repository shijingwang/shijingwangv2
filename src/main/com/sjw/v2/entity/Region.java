package com.sjw.v2.entity;

import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * @Author Kulen
 * @CreateTime 2010-6-17上午12:13:49
 * @Version 1.0
 * @Explanation
 */
@Table("core_region")
public class Region {

	public static final int PROVINCE = 1;

	public static final int CITY = 2;

	public static final int DISTRICT = 3;

	@Id
	private Long oid;

	private Region parentRegion;

	private List<Region> childRegion;

	@Column("region_name")
	private String regionName;

	@Column("region_type")
	private int regionType;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Region getParentRegion() {
		return parentRegion;
	}

	public void setParentRegion(Region parentRegion) {
		this.parentRegion = parentRegion;
	}

	public List<Region> getChildRegion() {
		return childRegion;
	}

	public void setChildRegion(List<Region> childRegion) {
		this.childRegion = childRegion;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public int getRegionType() {
		return regionType;
	}

	public void setRegionType(int regionType) {
		this.regionType = regionType;
	}
}
