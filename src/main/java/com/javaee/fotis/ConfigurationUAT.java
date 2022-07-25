package com.javaee.fotis;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * UAT Config
 */
@Profile("uat")
@Configuration
public class ConfigurationUAT {
	
	/**
	 * DB username
	 */
	@Value("${USER}")
	String username;
	
	/**
	 * DB password
	 */
	@Value("${PASS}")
	String password;
	
	/**
	 * Config UAT DB.
	 * 
	 * @return UAT datasource
	 */
	@SuppressWarnings("nls")
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.url("jdbc:postgresql://localhost:5432/uat")
				.username(username)
				.password(password)
				.build();
	}
	
}
