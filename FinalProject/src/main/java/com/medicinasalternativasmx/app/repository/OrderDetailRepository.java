package com.medicinasalternativasmx.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.medicinasalternativasmx.app.model.OrderDetail;


public interface OrderDetailRepository extends CrudRepository <OrderDetail, Long> {

}
