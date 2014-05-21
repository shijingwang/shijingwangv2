package com.sjw.v2.entity;

/**
 * @Author Kulen
 * @CreateTime 2010-5-13上午09:31:17
 * @Version 1.0
 * @Explanation 
 */
public enum FavoriteType{
	
	ARTICLE("文章"),VIDEO("视频"),GOODS("商品"),POST("帖子");

	private String name;

	private FavoriteType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String getEnumValue(){
		return super.name();
	}
}
