package com.javaee.fotis;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * spring boot template test
 */
@Disabled
@SpringBootTest
class FotisApplicationTests {

	/** Template test method */
	@Transactional
	@Test
	void contextLoads() {
		// Empty
	}

}
