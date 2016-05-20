package net.tsolval.config.property;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class PropertyConfiguratorTest {
	@Value("${test.prop.app}")
	private String app;
	@Value("${test.prop.app.model}")
	private String appModel;
	@Value("${test.prop.app.model.web}")
	private String appModelWeb;
	@Value("${test.prop.app.db}")
	private String appDb;
	@Value("${test.prop.app.jvm}")
	private String appJvm;

	@BeforeClass
	public static void setJvmProps() {
		System.setProperty("test.prop.app.jvm", "works");
	}

	@Test
	public void testSpringConfigLoaded() {
		assertEquals("works", app);
		assertEquals("works", appModel);
		assertEquals("works", appModelWeb);
		assertEquals("works", appDb);
		assertEquals("works", appJvm);
	}
}
