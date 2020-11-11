package com.codelabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

import com.codelabs.utility.Constants;

@SpringBootApplication
public class SpringBootCustomeValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCustomeValidatorApplication.class, args);
	}
	
	@Bean
	public HttpHeaders httpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set(Constants.STRICT_TRANSPORT_SECURITY,Constants.STRICT_TRANSPORT_SECURITY_VALUE); 
		return httpHeaders;
	}

}
