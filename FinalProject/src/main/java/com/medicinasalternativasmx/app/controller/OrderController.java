package com.medicinasalternativasmx.app.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicinasalternativasmx.app.model.Order;
import com.medicinasalternativasmx.app.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
	
	OrderService orderService ;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping // ("/api/v1/orders") http://localhost:8080/api/v1/orders
	 ResponseEntity<Iterable<Order>> getAllOrders(){
			Iterable<Order> orders = orderService.findAll();
			// new ResponseEntity<Iterable<Order>>(orders, HttpStatus.OK);
			return ResponseEntity.ok(orders);		
	}

	
	@PostMapping
	ResponseEntity<Order> createOrder(@RequestBody Order order ) {
		Order newOrder = orderService.save(order);
		return new ResponseEntity<Order>(newOrder, HttpStatus.CREATED); // 201
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
		orderService.deleteById(id);
		return ResponseEntity.noContent().build(); // 204- Sin contenido
	}
	
	@GetMapping("/{id}")
    public Order getOrderById( @PathVariable("id") Long id )
    {
        return orderService.findById(id);
    }
	
	@PutMapping("/{id}")
	Order updateOrder(@RequestBody Order order, @PathVariable("id") Long id) {
		Order updatedOrder = orderService.update(id, order);
		return updatedOrder;
	}
	
	@GetMapping("products/{id}")
	public Set<String> getUsersWithSpecificOrderId ( @PathVariable("id") Long id )
    {
        return orderService.getProductsWithSpecificOrderId(id);
    }

}
