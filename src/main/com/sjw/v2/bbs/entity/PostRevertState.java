package com.sjw.v2.bbs.entity;

/**
 * @Author Kulen
 * @CreateTime 2010-5-13上午09:31:17
 * @Version 1.0
 * @Explanation 
 */
public enum PostRevertState{
	
	AUTO_SAVE("自动保存"),RELEASE("发布"),FORBID("禁用");

	private String name;

	private PostRevertState(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String getEnumValue(){
		return super.name();
	}
}
