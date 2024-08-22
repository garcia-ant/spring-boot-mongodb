package com.gpost.sprongmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gpost.sprongmongo.domain.User;
import com.gpost.sprongmongo.repository.UserRepository;

@Configuration
public class Instantation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User pio = new User(null, "Garcia Piota", "piota@gmail.com");
		User pombo = new User(null, "Albano Pombo", "pombo@gmail.com");
		User isi = new User(null, "Isidoro Capita", "isi@gmail.com");
		
		userRepository.saveAll(Arrays.asList(pio,pombo,isi));
	}
	
	

}
