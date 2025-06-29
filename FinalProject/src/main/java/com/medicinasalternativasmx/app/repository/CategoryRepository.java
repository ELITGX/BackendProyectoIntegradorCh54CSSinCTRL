package com.medicinasalternativasmx.app.repository;

import org.springframework.data.repository.*;

import com.medicinasalternativasmx.app.model.*;

public interface CategoryRepository extends CrudRepository <Product, Long> {
	

}