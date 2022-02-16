package com.auto.eventwisher;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.auto.eventwisher.*")
@EnableMongoRepositories
public class AutoEventWisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoEventWisherApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
