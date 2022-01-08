package com.javaee.fotis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Run this class as a java application to start this web app
 */
@ServletComponentScan
@SpringBootApplication
public class FotisApplication {

	@SuppressWarnings("javadoc")
	public static void main(String[] args) {
		SpringApplication.run(FotisApplication.class, args);
	}
	
}
