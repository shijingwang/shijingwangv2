package com.sjw.v2.entity;

/**
 * @Author Kulen
 * @CreateTime 2010-5-13上午09:31:17
 * @Version 1.0
 * @Explanation 文章状态
 */
public enum BulletinState{
	CREATE("创建"),RELEASE("发布"), FORBID("禁止");

	private String name;

	private BulletinState(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String getEnumValue(){
		return super.name();
	}
}
