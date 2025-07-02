package com.medicinasalternativasmx.app.repository;

import org.springframework.data.repository.CrudRepository;
import com.medicinasalternativasmx.app.model.Address;
import java.util.List;


public interface AddressRepository extends CrudRepository<Address, Long> {
	List<Address> findByUserId(Long userId);
}
