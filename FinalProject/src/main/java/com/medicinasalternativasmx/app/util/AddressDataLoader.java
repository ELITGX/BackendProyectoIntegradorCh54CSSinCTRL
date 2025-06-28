package com.medicinasalternativasmx.app.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.medicinasalternativasmx.app.model.Address;
import com.medicinasalternativasmx.app.repository.AddressRepository;

@Component
@Profile("h2")
public class AddressDataLoader implements CommandLineRunner {

    private final AddressRepository addressRepository;

    public AddressDataLoader(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        addressRepository.save(new Address(null, "Ciudad de México", "CDMX", "08200", "México"));
        addressRepository.save(new Address(null, "Guadalajara", "Jalisco", "44100", "México"));
        addressRepository.save(new Address(null, "Monterrey", "Nuevo León", "64000", "México"));
        addressRepository.save(new Address(null, "Puebla", "Puebla", "72000", "México"));
        addressRepository.save(new Address(null, "Tijuana", "Baja California", "22000", "México"));
    }
}
