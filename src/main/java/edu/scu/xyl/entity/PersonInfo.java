package edu.scu.xyl.entity;

import java.util.Date;

public class PersonInfo {
	private Long user_id;
	private String name;
	private String profile_image;
	private String email;
	private String gender;
	private Integer enable_staus;
	// 1 customer 2 saler 3 supervisor
	private Integer userType;
	private Date createTime;
	private Date lastUpdateTime;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getEnable_staus() {
		return enable_staus;
	}

	public void setEnable_staus(Integer enable_staus) {
		this.enable_staus = enable_staus;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	

}
