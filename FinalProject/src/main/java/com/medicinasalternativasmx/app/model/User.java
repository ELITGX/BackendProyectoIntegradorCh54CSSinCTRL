package com.medicinasalternativasmx.app.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=50, nullable=false)
	private String name;
	@Column(length=75, nullable=false)
	private String last_name;
	@Column(length=50, nullable=false)
	private String email;
	@Column(length=15, nullable=false)
	private String phone;
	@Column(length=120, nullable=false)
	private String password;
	
	public User(Long id, String name, String last_name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getLast_name() {
		return last_name;
	}

	public final void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getPhone() {
		return phone;
	}

	public final void setPhone(String phone) {
		this.phone = phone;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", last_name=");
		builder.append(last_name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
