package org.jsonhoist.spring.boot;

import static org.junit.jupiter.api.Assertions.*;

import org.jsonhoist.HoistMetaData;
import org.jsonhoist.trans.JsonTransformationRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JsonHoistAutoConfiguration.class)
@DirtiesContext
public class JsonHoistAutoConfigurationLoadFromCPEnabledTest {

	@Autowired
	JsonTransformationRepository r;

	@BeforeAll
	static void setup() {
		System.setProperty("jsonhoist.repository.classpath.enabled", "true");
	}

	@Test
	void testEnabledProperty() throws Exception {

		assertNotNull(r.defaultPath(HoistMetaData.of("Foo", 1), HoistMetaData.of("Foo", 2)));
	}
}