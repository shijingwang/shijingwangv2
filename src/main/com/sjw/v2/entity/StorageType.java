package com.sjw.v2.entity;

/**
 * @Author Kulen
 * @CreateTime 2010-5-13上午09:31:17
 * @Version 1.0
 * @Explanation 
 */
public enum StorageType{
	
	GOODS_FILE("商品文件"),MARKETING_FILE("营销活动文件"),SUPPLIER_FILE("供应商的文件"),ARTICLE_FILE("文章文件"),BULLETIN_FILE("公告文件"),CUSTOMER_FILE("会员文件"),POST_FILE("帖子文件"),POST_REVERT_FILE("帖子回复文件"),BBS_CATEGORY_FILE("论坛频道文件");

	private String name;

	private StorageType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String getEnumValue(){
		return super.name();
	}
}
