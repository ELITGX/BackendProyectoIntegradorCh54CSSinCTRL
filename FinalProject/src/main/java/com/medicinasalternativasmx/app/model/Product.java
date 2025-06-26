package com.medicinasalternativasmx.app.model;

import jakarta.persistence.*;
@Table(name="products")
@Entity
public class Product {
	
	// Define la primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=50, nullable=false)
	private String name;
	@Column(length=50, nullable=false)
	private String description;
	@Column(nullable=false)
	private Double price;
	@Column(length=250, nullable=false)
	private String img_url;
	@Column(nullable=false)
	private Integer stock;
	
	
	// POJO
	public Product(Long id, String name, String description, Double price, String img_url, Integer stock) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.img_url = img_url;
		this.stock = stock;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", price=");
		builder.append(price);
		builder.append(", img_url=");
		builder.append(img_url);
		builder.append(", stock=");
		builder.append(stock);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
