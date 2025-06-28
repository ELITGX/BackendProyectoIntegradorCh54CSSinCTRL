package com.medicinasalternativasmx.app.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Table(name = "orders")
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//private Long id_user;
	//private Long id_order_details;
	@Column(nullable=false)
	private LocalDate purchase_date;
	@Column(length=250, nullable=false)
	private String description;
	@Column(nullable=false)
	private Double total_amount;
	
	public Order(Long id, LocalDate purchase_date, String description, Double total_amount) {
		this.id = id;
		this.purchase_date = purchase_date;
		this.description = description;
		this.total_amount = total_amount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(LocalDate purchase_date) {
		this.purchase_date = purchase_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=");
		builder.append(id);
		builder.append(", purchase_date=");
		builder.append(purchase_date);
		builder.append(", description=");
		builder.append(description);
		builder.append(", total_amount=");
		builder.append(total_amount);
		builder.append("]");
		return builder.toString();
	}
	
	

}
