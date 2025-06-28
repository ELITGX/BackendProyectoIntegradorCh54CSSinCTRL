package com.medicinasalternativasmx.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.medicinasalternativasmx.app.model.Order;

public interface OrderRepository  extends CrudRepository<Order,Long>{

}
