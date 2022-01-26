package com.Gojjo.house;

import com.Gojjo.house.security.User;
import com.Gojjo.house.security.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class HouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseApplication.class, args);
	}

	@Autowired
	PasswordEncoder encoder;
	
	@Bean
	 public CommandLineRunner dataLoader(UserRepository repo) {
		 return args -> {
		  User admin = new User();
		  admin.setPassword(encoder.encode("12345"));
	      admin.setUsername("Benon");
		  admin.setEmail("addisumotora3@gmail.com");
		  admin.setFullName("Addisu Motora");
		  admin.setRole("ADMIN");
		  repo.save(admin);
		};
	 }

}
