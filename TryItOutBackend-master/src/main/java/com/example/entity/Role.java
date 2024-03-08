package com.example.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "role_table")
public class Role {
	@Id
	private int roleId;
	
	@Column(unique=true)
	private String Description;
	
	@CreationTimestamp
	private Timestamp creationTimestamp;
	
	@UpdateTimestamp
	private Timestamp updationTimestamp;
	
	@OneToMany(mappedBy = "role")
	@JsonIgnore
	private List<User> userList;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Role(int roleId, String description) {
		super();
		this.roleId = roleId;
		Description = description;
	}
	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Timestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public Timestamp getUpdationTimestamp() {
		return updationTimestamp;
	}

	public void setUpdationTimestamp(Timestamp updationTimestamp) {
		this.updationTimestamp = updationTimestamp;
	}

	public Role() {
		
	}
	
}
