package net.tsolval.config.property

import net.tsolval.config.ApplicationDomainConfig

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
		// TODO: fetch PropertyRepository from beanFactory

		final Properties databaseProperties = new Properties()

		// TODO: Fetch properties from PropertyRepository for each domain/subdomain combo

		databaseProperties << ['test.prop.app.db':'works']
		setProperties(databaseProperties)

		super.postProcessBeanFactory(beanFactory);
	}
}
