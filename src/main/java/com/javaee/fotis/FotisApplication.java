package com.javaee.fotis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Run this class as a java application to start this web app
 */
@ServletComponentScan
@SpringBootApplication
@PropertySource({ "classpath:application_${envTarget:dev}.properties" })
public class FotisApplication {

	@SuppressWarnings("javadoc")
	public static void main(String[] args) {
		SpringApplication.run(FotisApplication.class, args);
	}
	
}
