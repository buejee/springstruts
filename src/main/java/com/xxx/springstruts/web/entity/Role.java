package com.xxx.springstruts.web.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="xx_role")
public class Role extends BaseEntity{
	private String name;
	@OneToMany
	@JoinTable(name="xx_role_permission",joinColumns= {@JoinColumn(name="role_id")},inverseJoinColumns= {@JoinColumn(name="permission_id")})
	private Set<Permission> permissions = new HashSet<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
}
