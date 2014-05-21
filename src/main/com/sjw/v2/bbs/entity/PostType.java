package com.sjw.v2.bbs.entity;

/**
 * @Author Kulen
 * @CreateTime 2010-5-13上午09:31:17
 * @Version 1.0
 * @Explanation 
 */
public enum PostType{
	
	HOT("热帖"),TOP("推荐"),NORMAL("正常");

	private String name;

	private PostType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String getEnumValue(){
		return super.name();
	}
}
