package com.medicinasalternativasmx.app.model;

import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=50, nullable=false)
	private String name;
	@Column(name ="last_name", length=75, nullable=false)
	private String lastName;
	@Column(length=50, nullable=false)
	private String email;
	@Column(length=15, nullable=false)
	private String phone;
	@Column(length=120, nullable=false)
	private String password;
	
	@ManyToMany
	@JoinTable( 
			name="user_has_role", 
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")			
			)
	private Set<Role> roles = new HashSet<>();
	
	// Relación con entidad Address
	@OneToMany(mappedBy= "user")
	private Set<Address> address = new HashSet<>();
	
	
	
	// public User() {}
	
	public User(Long id, String name, String lastName, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public  void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", lastName=");
		builder.append(lastName);
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
