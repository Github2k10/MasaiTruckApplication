package com.masai.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Truck {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tid;
	
	private String name;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
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
	
	public Truck() {}

	public Truck(String name, User user) {
		this.name = name;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Truck [tid=" + tid + ", name=" + name + ", user=" + user + "]";
	}
}
