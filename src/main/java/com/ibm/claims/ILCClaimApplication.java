package com.ibm.claims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ILCClaimApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ILCClaimApplication.class, args);
	}

}
