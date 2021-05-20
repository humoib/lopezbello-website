package things;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({ "dev", "bar" })
class FooBarProfileTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(FooBarProfileTest.class);

	@Test
	void test() {
		// test something

		LOGGER.debug("############ TEST ##");
		
	}

}