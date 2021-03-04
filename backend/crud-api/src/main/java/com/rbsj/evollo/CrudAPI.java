package com.rbsj.evollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CrudAPI {

	public static void main(String[] args) {
		SpringApplication.run(CrudAPI.class, args);
	}
}