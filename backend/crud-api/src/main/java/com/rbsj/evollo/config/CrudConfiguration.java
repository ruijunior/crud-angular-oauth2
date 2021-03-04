package com.rbsj.evollo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CrudConfiguration {
	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

}
