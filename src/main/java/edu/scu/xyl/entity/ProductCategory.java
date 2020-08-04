package edu.scu.xyl.entity;

import java.util.Date;

public class ProductCategory {

	private Long product_category_id;
	private Long shop_id;
	private String product_category_name;
	private Integer priority;
	private Date createTime;

	public Long getProduct_category_id() {
		return product_category_id;
	}

	public void setProduct_category_id(Long product_category_id) {
		this.product_category_id = product_category_id;
	}

	public Long getShop_id() {
		return shop_id;
	}

	public void setShop_id(Long shop_id) {
		this.shop_id = shop_id;
	}

	public String getProduct_category_name() {
		return product_category_name;
	}

	public void setProduct_category_name(String product_category_name) {
		this.product_category_name = product_category_name;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
