package com.medicinasalternativasmx.app.service.Impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.medicinasalternativasmx.app.model.OrderDetail;
import com.medicinasalternativasmx.app.repository.OrderDetailRepository;
import com.medicinasalternativasmx.app.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	private final OrderDetailRepository orderDetailRepository;

	
	public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
		this.orderDetailRepository = orderDetailRepository;
	}
	

	@Override
	public Iterable<OrderDetail> findAll() {
		return orderDetailRepository.findAll();
	}
	

	@Override
	public OrderDetail findById(Long id) {
		
		Optional<OrderDetail> OrderDetailOpt = orderDetailRepository.findById(id);
		if( OrderDetailOpt.isEmpty() ) { // no hay objeto, la variable contiene null
			throw new IllegalStateException("OrderDetail does not exist with id " + id);
		}
		OrderDetail existingOrderDetail = OrderDetailOpt.get();
		return existingOrderDetail;
	}
	

	@Override
	public OrderDetail save(OrderDetail orderDetail) {
		orderDetail.setId(null);
		OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
		return newOrderDetail;
	}

	@Override
	public OrderDetail update(Long id, OrderDetail orderDetail) {
		OrderDetail existingOrderDetail = findById(id);
		existingOrderDetail.setDelivery(orderDetail.getDelivery());
		existingOrderDetail.setOrder_state(orderDetail.getOrder_state());
		existingOrderDetail.setIs_completed(orderDetail.getIs_completed());
		OrderDetail updateOrderDetail = orderDetailRepository.save(existingOrderDetail);
		return updateOrderDetail;
	}

	@Override
	public void deleteById(Long id) {
		OrderDetail existingOrderDetail = findById(id);
		orderDetailRepository.delete(existingOrderDetail);
		
	}

	@Override
	public Set<String> getDeliveriessWithSpecificOrderDetailId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
