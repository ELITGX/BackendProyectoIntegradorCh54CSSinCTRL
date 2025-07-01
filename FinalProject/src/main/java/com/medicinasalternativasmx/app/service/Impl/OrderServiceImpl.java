package com.medicinasalternativasmx.app.service.Impl;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.medicinasalternativasmx.app.model.Order;
import com.medicinasalternativasmx.app.model.OrderHasProduct;
import com.medicinasalternativasmx.app.model.Product;
import com.medicinasalternativasmx.app.repository.OrderRepository;
import com.medicinasalternativasmx.app.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	private final OrderRepository orderRepository;
	
	
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Iterable<Order> findAll() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public Order findById(Long id) {
		Optional<Order> optOrder = orderRepository.findById(id);
		if(optOrder.isEmpty()) {
			throw new IllegalStateException("Order does not exist with id " + id);
		}
		return optOrder.get();
	}

	@Override
	public Order save(Order order) {
	
		return orderRepository.save(order);
	}

	@Override
	public Order update(Long id, Order order) {
		Order updateOrder = findById(id);
		updateOrder.getClass();
		updateOrder.setDescription(order.getDescription());
		updateOrder.setPurchaseDate(order.getPurchaseDate());
		updateOrder.setTotalAmount(order.getTotalAmount());
		return orderRepository.save(updateOrder);
	}

	@Override
	public void deleteById(Long id) {
		orderRepository.deleteById(id);
	}

	@Override
	public Set<String> getProductsWithSpecificOrderId(Long id) {
		Order order = findById(id);
		Set<OrderHasProduct> orderHasProducts = order.getOrdersHasProduct();
		
		
		Set<String> productWithSpecificOrder = new HashSet<String>(); 
		
		for (OrderHasProduct orderHasProduct : orderHasProducts) {
			productWithSpecificOrder.add(orderHasProduct.getProduct().getName());
		}
		
		return productWithSpecificOrder;
	}

}
