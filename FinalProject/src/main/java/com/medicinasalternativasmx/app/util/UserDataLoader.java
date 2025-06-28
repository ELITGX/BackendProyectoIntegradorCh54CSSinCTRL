package com.medicinasalternativasmx.app.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.medicinasalternativasmx.app.model.User;
import com.medicinasalternativasmx.app.repository.UserRepository;

@Component
@Profile("h2")
//Order(n)
public class UserDataLoader implements CommandLineRunner {
	
	UserRepository userRepository;
	
	public UserDataLoader(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User(
				null, "Alberto", "Solorzano", "AlbSoloz@gmail.com", "+521111111111", "AZ123#1no"));
		userRepository.save(new User(
				null, "Fernando", "Hernandez", "Fehz@gmail.com", "‪+522222222222‬", "HFFH#1vbo"));
		userRepository.save(new User(
				null , "Hernando", "Fernandez", "HeFz@gmail.com", "‪+523333333333‬", "FHHF#1kqM"));
		userRepository.save(new User(
				null , "Eliar", "Lopéz", "ElLo@gmail.com", "‪+524444444444‬", "LoEl#@14no"));
		userRepository.save(new User(
				null , "José", "Chan", "JoCh@gmail.com", "‪+525555555555‬", "JojoCh#54"));
		
	}
	
	
	
}
