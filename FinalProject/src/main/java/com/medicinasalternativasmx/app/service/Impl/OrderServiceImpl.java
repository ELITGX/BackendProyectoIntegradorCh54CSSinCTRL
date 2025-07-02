package com.medicinasalternativasmx.app.service.Impl;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.medicinasalternativasmx.app.dto.OrderDTO;
import com.medicinasalternativasmx.app.model.Order;
import com.medicinasalternativasmx.app.model.OrderDetail;
import com.medicinasalternativasmx.app.model.OrderHasProduct;
import com.medicinasalternativasmx.app.model.User;
import com.medicinasalternativasmx.app.repository.OrderDetailRepository;
import com.medicinasalternativasmx.app.repository.OrderRepository;
import com.medicinasalternativasmx.app.repository.UserRepository;
import com.medicinasalternativasmx.app.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	private final OrderRepository orderRepository;
	private final UserRepository userRepository;
	private final OrderDetailRepository orderDetailRepository;
	
	
	

	public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository,
			OrderDetailRepository orderDetailRepository) {
		this.orderRepository = orderRepository;
		this.userRepository = userRepository;
		this.orderDetailRepository = orderDetailRepository;
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
	public Order save(OrderDTO orderDTO) {
		
		Optional<User> user = userRepository.findById(orderDTO.getUserId());
		Optional<OrderDetail> orderDetail = orderDetailRepository.findById(orderDTO.getOrderDetailsId());
		
		if(user.isPresent() || orderDetail.isPresent()) {
			Order order = new Order();
			order.setPurchaseDate(orderDTO.getPurchaseDate());
			order.setDescription(orderDTO.getDescription());
			order.setTotalAmount(orderDTO.getTotalAmount());
			order.setUser(user.get());
			System.out.println(user.toString());
			order.setOrderDetail(orderDetail.get());
			return orderRepository.save(order);
			
		}
		else {
			System.out.println("nadagggggggg##########################3" + orderDTO.getOrderDetailsId() + orderDTO.getUserId());
		}
		return null;
		
	}

	@Override
	public Order update(Long id, OrderDTO orderDTO) {
		Order updateOrder = findById(id);
		updateOrder.getClass();
		updateOrder.setDescription(orderDTO.getDescription());
		updateOrder.setPurchaseDate(orderDTO.getPurchaseDate());
		updateOrder.setTotalAmount(orderDTO.getTotalAmount());
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
