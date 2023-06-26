package com.masai.module;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	
	@Column(unique = true)
	private String username;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Truck> trucks;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Authority> authorities = new ArrayList<>();

	public String getUsername() {
		return username;
	}
	
	public User() {}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
