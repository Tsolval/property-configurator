package net.tsolval.config.property

import net.tsolval.config.ApplicationDomainConfig
import net.tsolval.config.data.Property;
import net.tsolval.config.repository.PropertyRepository;

import java.io.IOException

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Component

/** @see https://gist.github.com/rponte/3989915 for more information **/
@Component
class DBPropertySourcesPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		ApplicationDomainConfig domainConfig = beanFactory.getBean('domainConfig')
		PropertyRepository repository = beanFactory.getBean('propertyRepository')

		final Properties databaseProperties = new Properties()

		List<Property> properties = repository.findByContext('app')
		properties.each {property ->
			databaseProperties.put(property.key, property.value)
		}

		setProperties(databaseProperties)

		super.postProcessBeanFactory(beanFactory);
	}
}
