package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ViagemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViagemApplication.class, args);
		
		System.out.println(new BCryptPasswordEncoder().encode("01234"));
	}

}
