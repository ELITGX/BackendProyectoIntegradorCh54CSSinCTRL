package com.medicinasalternativasmx.app.dto;

import java.time.LocalDate;



public class OrderDTO {
	private LocalDate purchaseDate;
	private String description;
	private Double totalAmount;
    private Long userId;
    private Long orderDetailsId;
    
    
    
	public OrderDTO() {
		
	}



	public OrderDTO(LocalDate purchaseDate, String description, Double totalAmount, Long userId, Long orderDetailsId) {
		this.purchaseDate = purchaseDate;
		this.description = description;
		this.totalAmount = totalAmount;
		this.userId = userId;
		this.orderDetailsId = orderDetailsId;
	}



	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}



	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public Long getOrderDetailsId() {
		return orderDetailsId;
	}



	public void setOrderDetailsId(Long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}
	
	
    
    
}
