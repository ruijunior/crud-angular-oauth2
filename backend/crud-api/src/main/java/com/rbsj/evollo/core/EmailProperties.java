package com.rbsj.evollo.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties("crud-api.email")
public class EmailProperties {

	private String remetente;
	
}
