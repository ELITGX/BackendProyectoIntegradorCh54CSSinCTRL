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

import com.medicinasalternativasmx.app.model.OrderDetail;
import com.medicinasalternativasmx.app.service.OrderDetailService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/ordersDetails")
public class OrderDetailController {
	
	OrderDetailService orderDetailService;

	public OrderDetailController(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}
	
	@GetMapping // ("/api/v1/ordersDetails") http://localhost:8080/api/v1/ordersDetails
	 ResponseEntity<Iterable<OrderDetail>> getAllOrderDetail(){
			Iterable<OrderDetail> ordersDetails = orderDetailService.findAll();
			// new ResponseEntity<Iterable<OrderDetail>>(orderDetailService, HttpStatus.OK);
			return ResponseEntity.ok(ordersDetails);		
	}
	
	@PostMapping
	ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail ) {
		OrderDetail newOrderDetail = orderDetailService.save(orderDetail);
		return new ResponseEntity<OrderDetail>(newOrderDetail, HttpStatus.CREATED); // 201
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> deleteOrderDetail(@PathVariable("id") Long id) {
		orderDetailService.deleteById(id);
		return ResponseEntity.noContent().build(); // 204- Sin contenido
	}
	
	@GetMapping("/{id}")
    public OrderDetail getOrderDetailById( @PathVariable("id") Long id )
    {
        return orderDetailService.findById(id);
    }
	
	
	@PutMapping("/{id}")
	OrderDetail updateOrderDetail (@RequestBody OrderDetail orderDetail, @PathVariable("id") Long id) {
		OrderDetail updatedOrderDetail = orderDetailService.update(id, orderDetail);
		return updatedOrderDetail;
	}
	
	
	@GetMapping("orders/{id}")
	public Set<String> getDeliveriessWithSpecificOrderDetailId ( @PathVariable("id") Long id )
    {
        return orderDetailService.getDeliveriessWithSpecificOrderDetailId(id);
    }
	
	
	
	
	

}
