package com.sjw.v2.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * @Author Kulen
 * @CreateTime 2010-5-28上午09:24:50
 * @Version 1.0
 * @Explanation 
 */
@Table("common_file_storage_path")
public class FileStoragePath {
	
	@Id
	private Long oid;
	
	@Column("reference_id")
	private String referenceId;
	
	@Column("storage_type")
	private StorageType storageType;
	
	@Column("first_path")
	private String firstPath;
	
	@Column("second_path")
	private String secondPath;
	
	@Column("third_path")
	private String thirdPath;
	
	public String getPath(){
		return firstPath + "/"	+ secondPath + "/"	+ thirdPath;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public StorageType getStorageType() {
		return storageType;
	}

	public void setStorageType(StorageType storageType) {
		this.storageType = storageType;
	}

	public String getFirstPath() {
		return firstPath;
	}

	public void setFirstPath(String firstPath) {
		this.firstPath = firstPath;
	}

	public String getSecondPath() {
		return secondPath;
	}

	public void setSecondPath(String secondPath) {
		this.secondPath = secondPath;
	}

	public String getThirdPath() {
		return thirdPath;
	}

	public void setThirdPath(String thirdPath) {
		this.thirdPath = thirdPath;
	}
}
