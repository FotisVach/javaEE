package com.javaee.fotis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.javaee.fotis.rest.BookEndpoint;

/**
 * Test class for {@link BookEndpoint}
 */
@SuppressWarnings({ "nls", "javadoc" })
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TestIndex {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	/**
	 * BookEndpoint
	 */
	@Test
	void test_countBooks() {
		assertFalse(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)
				.contains("JavaEE Example"));
		assertTrue(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)
				.contains("Available Books"));
	}

}
