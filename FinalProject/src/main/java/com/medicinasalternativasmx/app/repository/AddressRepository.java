package com.medicinasalternativasmx.app.repository;

import org.springframework.data.repository.CrudRepository;
import com.medicinasalternativasmx.app.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
