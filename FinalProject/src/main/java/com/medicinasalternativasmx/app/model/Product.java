package com.medicinasalternativasmx.app.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name= "img_url", length=250, nullable=false)
	private String imgUrl;

	@Column(nullable=false)
	private Integer stock;
	
	@OneToMany(mappedBy= "product", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<OrderHasProduct> orderHasProduct = new HashSet<>();
	
	// Relación con entidad Category
    @ManyToOne
	@JoinColumn(name="category_id", nullable = false)  
    @JsonIgnore
    private Category category;
    
 // Relación con entidad ProductProperty
    @ManyToOne
	@JoinColumn(name="product_properties_id", nullable = false)  
    @JsonIgnore
    private ProductProperty productProperty;
	
	// POJO

    public Product () {
    	
    }
	public Product(Long id, String name, String description, Double price, String imgUrl, Integer stock) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;

		this.imgUrl = imgUrl;

		this.stock = stock;
	}

	
	public ProductProperty getProductProperty() {
		return productProperty;
	}
	public void setProductProperty(ProductProperty productProperty) {
		this.productProperty = productProperty;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public Category getCategory() {
		return category;
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

	public String getImgUrl() {
		return imgUrl;
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
		builder.append(", imgUrl=");
		builder.append(imgUrl);
		builder.append(", stock=");
		builder.append(stock);
		builder.append("]");
		return builder.toString();
	}
	

}
