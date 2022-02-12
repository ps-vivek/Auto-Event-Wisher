package com.love.lovebackend;

import com.love.lovebackend.Repositories.LogRepository;
import com.love.lovebackend.services.ILoveService;
import com.love.lovebackend.services.LoveService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoveBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoveBackendApplication.class, args);
	}
	@Autowired
	public LogRepository logRepository;

	@Bean
	public ILoveService loveService() {
		return new LoveService(logRepository);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
