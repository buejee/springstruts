package com.xxx.springstruts.web.entity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="xx_user")
@JsonIgnoreProperties({"createDate","modifyDate"})
public class User extends BaseEntity{
	private String username;
	private String password;
	private String mobile;
	private Date lastLoginTime;
	private Integer status;
	@OneToOne
	@JoinTable(name="xx_user_role",joinColumns= {@JoinColumn(name="user_id")},inverseJoinColumns= {@JoinColumn(name="role_id")})
	private Role role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
