package com.medicinasalternativasmx.app.util;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.medicinasalternativasmx.app.model.Order;
import com.medicinasalternativasmx.app.repository.OrderRepository;

@Component
@Profile("h2")
public class OrderDataLoader implements CommandLineRunner{
	
	private OrderRepository orderRepository;
	

	public OrderDataLoader(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		orderRepository.save(new Order(null, LocalDate.of(2025, 5, 28),"2 x NAC, 1 x Manganeso", 13780.00));
	}

}
