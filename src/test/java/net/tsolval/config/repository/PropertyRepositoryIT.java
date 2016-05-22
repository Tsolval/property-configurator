package net.tsolval.config.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.tsolval.config.data.Property;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class PropertyRepositoryIT {
	@Autowired
	PropertyRepository repository;

	@Test
	public void test() {
		List<Property> properties = repository.findByContext("app");
		assertNotNull("No Properties object returned!", properties);
		assertFalse("Response was empty!", properties.isEmpty());
		assertEquals("Response didn't contain expected property key!", "test.prop.app.db", properties.get(0).getKey());
		assertEquals("Response didn't contain expected property value!", "works", properties.get(0).getValue());
	}
}
