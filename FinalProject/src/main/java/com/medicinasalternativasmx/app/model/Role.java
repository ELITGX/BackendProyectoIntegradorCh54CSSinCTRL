package com.medicinasalternativasmx.app.model;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;


@Table(name="Roles")
@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=50, nullable=false)
	private String name;
	@Column(length=250, nullable=false)
	private String description;
	
	@ManyToMany(mappedBy = "roles")
	@JsonIgnoreProperties({"name","lastName", "email", "phone", "password", "order" , "roles" , "address"})
	private Set<User> users = new HashSet<>();
	
	// Get necesario para solicitar los datos de la tabla many to many de user_has_role
	public Set<User> getUsers() {
		return users;
	}

	public Role(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Role () {}

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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}