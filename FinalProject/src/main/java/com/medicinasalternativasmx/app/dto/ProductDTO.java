package com.medicinasalternativasmx.app.dto;



public class ProductDTO {

	private Long categoryId;
	private Long productPropertyId;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	private Integer stock;

    
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getProductPropertyId() {
		return productPropertyId;
	}
	public void setProductPropertyId(Long productPropertyId) {
		this.productPropertyId = productPropertyId;
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
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
    
    
	public ProductDTO(Long categoryId, Long productPropertyId, String name, String description, Double price,
			String imgUrl, Integer stock) {
		super();
		this.categoryId = categoryId;
		this.productPropertyId = productPropertyId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
		this.stock = stock;
	}
	
	public ProductDTO() {
		
	}
	
}

