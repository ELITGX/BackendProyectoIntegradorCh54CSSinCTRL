package com.medicinasalternativasmx.app.model;

import jakarta.persistence.*;


@Table(name="order_details")
@Entity
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=80, nullable=false)
	private String delivery;
	@Column(length=80, nullable=false)
	private String order_state;
	@Column(nullable=false)
	private boolean is_completed;
	
	
	public OrderDetail(Long id, String delivery, String order_state, boolean is_completed) {
		this.id = id;
		this.delivery = delivery;
		this.order_state = order_state;
		this.is_completed = is_completed;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDelivery() {
		return delivery;
	}


	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}


	public String getOrder_state() {
		return order_state;
	}


	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}


	public boolean isIs_completed() {
		return is_completed;
	}


	public void setIs_completed(boolean is_completed) {
		this.is_completed = is_completed;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDetailDataLoader [id=");
		builder.append(id);
		builder.append(", delivery=");
		builder.append(delivery);
		builder.append(", order_state=");
		builder.append(order_state);
		builder.append(", is_completed=");
		builder.append(is_completed);
		builder.append("]");
		return builder.toString();
	}
}
