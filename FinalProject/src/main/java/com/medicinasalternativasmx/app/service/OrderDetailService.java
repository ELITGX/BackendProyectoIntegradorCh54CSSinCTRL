package com.medicinasalternativasmx.app.service;

import java.util.Set;
import com.medicinasalternativasmx.app.model.OrderDetail;

public interface OrderDetailService {

	Iterable<OrderDetail> findAll();
	
	OrderDetail findById(Long id);
	
	OrderDetail save(OrderDetail orderDetail);
	
	OrderDetail update(Long id, OrderDetail orderDetail);
	
	void deleteById(Long id);
	
	Set<String> getDeliveriessWithSpecificOrderDetailId(Long id);
}
