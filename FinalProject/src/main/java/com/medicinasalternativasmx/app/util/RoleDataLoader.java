package com.medicinasalternativasmx.app.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.medicinasalternativasmx.app.model.Role;
import com.medicinasalternativasmx.app.repository.RoleRepository;


@Component
@Profile("h2")
public class RoleDataLoader implements CommandLineRunner{

	RoleRepository roleRepositoy;
	
	public RoleDataLoader (RoleRepository roleRepositoy) {
		this.roleRepositoy = roleRepositoy;
	}
	
	
	
	@Override
	public void run(String... args) throws Exception {
		roleRepositoy.save(new Role(null,"jesus","usuario de e comerce"));
		
	}

}
