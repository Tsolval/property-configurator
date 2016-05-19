package net.tsolval.config.property;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:app-db-context.xml" })
@TestPropertySource({ "classpath:app.properties", "classpath:app_model.properties",
		"classpath:app_model_web.properties" })
public class PropertyConfiguratorTest {
	@Autowired
	private Environment env;

	@Test
	public void testSpringConfigLoaded() {
		System.setProperty("test.prop.app.jvm", "works");
		assertEquals("works", env.getProperty("test.prop.app"));
		assertEquals("works", env.getProperty("test.prop.app.model"));
		assertEquals("works", env.getProperty("test.prop.app.model.web"));
		// assertEquals("works", props.getProperty("test.prop.app.db"));
		// assertEquals("works", env.getProperty("test.prop.app.jvm"));
	}
}
