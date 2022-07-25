package com.javaee.fotis;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * PROD Config
 */
@Profile("prod")
@Configuration
public class ConfigurationPROD {
	
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
				.url("jdbc:postgresql://localhost:5432/prod")
				.username(username)
				.password(password)
				.build();
	}
	
}
