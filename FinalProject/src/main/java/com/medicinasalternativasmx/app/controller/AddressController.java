package com.medicinasalternativasmx.app.controller;

import com.medicinasalternativasmx.app.dto.AddressDTO;
import com.medicinasalternativasmx.app.model.Address;
import com.medicinasalternativasmx.app.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Address>> getAll() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody AddressDTO addressDto) {
        Address created = addressService.save(addressDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@PathVariable("id") Long id, @RequestBody AddressDTO addressDto) {
        return ResponseEntity.ok(addressService.update(id, addressDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        addressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Address>> getByUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(addressService.findByUserId(userId));
    }
}
