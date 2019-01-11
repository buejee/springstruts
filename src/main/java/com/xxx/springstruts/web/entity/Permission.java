package com.xxx.springstruts.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="xx_permission")
public class Permission extends BaseEntity{
	private String name;
	private Integer level;
	private Integer parentId;
	private String url;
	private Integer isMenu;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getIsMenu() {
		return isMenu;
	}
	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}
}
