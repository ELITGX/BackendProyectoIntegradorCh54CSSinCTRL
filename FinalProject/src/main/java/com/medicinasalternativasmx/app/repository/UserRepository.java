package com.medicinasalternativasmx.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.medicinasalternativasmx.app.model.User;

public interface UserRepository extends CrudRepository <User, Long>{

}
