package com.masai.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Authority {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer authId;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public Integer getAuthId() {
		return authId;
	}

	public void setAuthId(Integer authId) {
		this.authId = authId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Authority [authId=" + authId + ", name=" + name + ", user=" + user + "]";
	}
}

