package com.medicinasalternativasmx.app.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
@Table(name="categories")
@Entity
public class Category {
	
	// Define la primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=50, nullable=false)
	private String name;
	@Column(length=50, nullable=false)
	private String description;
	
	// Relación con entidad product
		@OneToMany(mappedBy= "category")
		private Set<Product> product = new HashSet<>();
			
	// POJO
		
	public Category () {
		
	}
	public Category(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
}