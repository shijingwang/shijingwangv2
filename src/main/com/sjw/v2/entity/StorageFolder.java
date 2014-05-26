package com.sjw.v2.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * @Author Kulen
 * @CreateTime 2010-5-28上午10:14:55
 * @Version 1.0
 * @Explanation
 */
@Table("common_storage_folder")
public class StorageFolder {

	@Id
	private Long id;

	@Column("storage_type")
	private StorageType storageType;

	@Column("first_path")
	private int firstPath;

	@Column("second_path")
	private int secondPath;

	@Column("third_path")
	private int thirdPath;

	public String getAllFirstPath() {
		return this.getAllPath(firstPath);
	}

	public String getAllSecondPath() {
		return this.getAllPath(secondPath);
	}

	public String getAllThirdPath() {
		return this.getAllPath(thirdPath);
	}

	private String getAllPath(int path) {
		String tmpPath = String.valueOf(path);
		while (tmpPath.length() < 3) {
			tmpPath = "0" + tmpPath;
		}
		return tmpPath;
	}

	public String getPath() {
		return this.getAllFirstPath() + "/" + this.getAllSecondPath() + "/" + this.getAllThirdPath();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StorageType getStorageType() {
		return storageType;
	}

	public void setStorageType(StorageType storageType) {
		this.storageType = storageType;
	}

	public int getFirstPath() {
		return firstPath;
	}

	public void setFirstPath(int firstPath) {
		this.firstPath = firstPath;
	}

	public int getSecondPath() {
		return secondPath;
	}

	public void setSecondPath(int secondPath) {
		this.secondPath = secondPath;
	}

	public int getThirdPath() {
		return thirdPath;
	}

	public void setThirdPath(int thirdPath) {
		this.thirdPath = thirdPath;
	}
}
