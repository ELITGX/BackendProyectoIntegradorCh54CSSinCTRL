package com.medicinasalternativasmx.app.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Table(name = "orders")
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private LocalDate purchaseDate;
	@Column(length=250, nullable=false)
	private String description;
	@Column(nullable=false)
	private Double totalAmount;
	
	
	// Relación con entidad User
    @ManyToOne
	@JoinColumn(name="user_id", nullable = false)
       
    private User user;
    
    // Relación con entidad OrderDetails
    @ManyToOne
	@JoinColumn(name="order_details_id", nullable = false)
    private OrderDetail orderDetail;
    
    @OneToMany(mappedBy= "order")
	private Set<OrderHasProduct> ordersHasProduct = new HashSet<>();

	public Order() {}
	public Order(Long id, LocalDate purchaseDate, String description, Double totalAmount) {
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.description = description;
		this.totalAmount = totalAmount;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	public Set<OrderHasProduct> getOrdersHasProduct() {
		return ordersHasProduct;
	}
	public void setOrdersHasProduct(Set<OrderHasProduct> ordersHasProduct) {
		this.ordersHasProduct = ordersHasProduct;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=");
		builder.append(id);
		builder.append(", purchaseDate=");
		builder.append(purchaseDate);
		builder.append(", description=");
		builder.append(description);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append("]");
		return builder.toString();
	}
	
	

}
