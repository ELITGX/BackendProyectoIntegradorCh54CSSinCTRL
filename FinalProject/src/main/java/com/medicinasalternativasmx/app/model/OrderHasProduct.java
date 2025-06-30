package com.medicinasalternativasmx.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name="order_has_products")
@Entity
@IdClass(OrderHasProductId.class)
public class OrderHasProduct {
	
	@Column(nullable=false)
	private Integer orderQuantity;
	
	// Relación con entidad Order
	@Id
    @ManyToOne
	@JoinColumn(name="order_id", nullable = false)
    private Order order;
    
 // Relación con entidad Product
    @Id
    @ManyToOne
	@JoinColumn(name="product_id", nullable = false)
    private Product product;
    
	public OrderHasProduct() {}

	public OrderHasProduct(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderHasProduct [orderQuantity=");
		builder.append(orderQuantity);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
