package com.auto.eventwisher;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import graphql.kickstart.tools.SchemaParserOptions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.auto.eventwisher.*")
@EnableMongoRepositories
@EnableScheduling
public class AutoEventWisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoEventWisherApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		//http://modelmapper.org/examples/flattening/#example-1

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return new ModelMapper();
	}


	//https://github.com/graphql-java-kickstart/graphql-spring-boot/issues/32
	@Bean
	SchemaParserOptions schemaParserOptions() {
		ObjectMapper objectMapper =
				new ObjectMapper().registerModule(new JavaTimeModule())
						.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		return SchemaParserOptions.newOptions()
				.objectMapperProvider(fieldDefinition -> objectMapper)
				.build();
	}

}


