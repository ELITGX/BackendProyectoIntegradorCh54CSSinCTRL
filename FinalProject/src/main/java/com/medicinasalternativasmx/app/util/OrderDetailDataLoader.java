package com.medicinasalternativasmx.app.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.*;
import com.medicinasalternativasmx.app.model.OrderDetail;
import com.medicinasalternativasmx.app.repository.OrderDetailRepository;

@Component
@Profile("h2")
public class OrderDetailDataLoader implements CommandLineRunner{

	OrderDetailRepository orderDetailRepesitory;


	public OrderDetailDataLoader(OrderDetailRepository orderDetailRepesitory) {
		this.orderDetailRepesitory = orderDetailRepesitory;
	}



	@Override
	public void run(String... args) throws Exception {
		orderDetailRepesitory.save(new OrderDetail(null, "Estafeta", "En preparación", false ));
		
	}
}
