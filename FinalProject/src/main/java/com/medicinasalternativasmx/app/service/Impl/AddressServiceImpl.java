package com.medicinasalternativasmx.app.service.Impl;

import com.medicinasalternativasmx.app.dto.AddressDTO;
import com.medicinasalternativasmx.app.model.Address;
import com.medicinasalternativasmx.app.model.User;
import com.medicinasalternativasmx.app.repository.AddressRepository;
import com.medicinasalternativasmx.app.service.AddressService;
import com.medicinasalternativasmx.app.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    
    private UserService userService;

	public AddressServiceImpl(AddressRepository addressRepository, UserService userService) {
		super();
		this.addressRepository = addressRepository;
		this.userService = userService;
	}

	

    @Override
    public Iterable<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Address does not exist with id " + id));
    }

    @Override
    public Address save(AddressDTO addressDto) {
    	User user = userService.findById(addressDto.getUserId());
    	Address address = new Address();
    	address.setCity(addressDto.getCity());
    	address.setCountry(addressDto.getCountry());
    	address.setId(addressDto.getId());
    	address.setPostalCode(addressDto.getPostalCode());
    	address.setState(addressDto.getState());
    	address.setUser(user);
        return addressRepository.save(address);
    }

    @Override
    public Address update(Long id, AddressDTO addressDto) {
    	// User user = userService.findById(addressDto.getUserId());
        Address existing = findById(id);
        existing.setCity(addressDto.getCity());
        existing.setState(addressDto.getState());
        existing.setPostalCode(addressDto.getPostalCode());
        existing.setCountry(addressDto.getCountry());
        return addressRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        Address existing = findById(id);
        addressRepository.delete(existing);
    }

    @Override
    public List<Address> findByUserId(Long userId) {
        return addressRepository.findByUserId(userId);
    }
}
