package edu.scu.xyl.entity;

import java.util.Date;

public class ProductImg {
	private Long product_img_id;
	private String img_addr;
	private String img_desc;
	private Integer priority;
	private Date createTime;
	private Long product_id;

	public Long getProduct_img_id() {
		return product_img_id;
	}

	public void setProduct_img_id(Long product_img_id) {
		this.product_img_id = product_img_id;
	}

	public String getImg_addr() {
		return img_addr;
	}

	public void setImg_addr(String img_addr) {
		this.img_addr = img_addr;
	}

	public String getImg_desc() {
		return img_desc;
	}

	public void setImg_desc(String img_desc) {
		this.img_desc = img_desc;
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

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

}
