package net.tsolval.config.property

import net.tsolval.config.data.Property
import net.tsolval.config.repository.PropertyRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.EnvironmentAware
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component

@Component
class ApplicationProperties implements EnvironmentAware {
	@Autowired
	ConfigurableEnvironment environment
	@Autowired
	PropertyRepository repository

	@Override
	public void setEnvironment(Environment env) {
		environment=env
	}

	/** Refresh the database properties in the environment **/
	public void refreshEnvironment(){
		MutablePropertySources sources = environment.getPropertySources()
	}

	public void getProperties() {
		final Properties databaseProperties = new Properties()

		List<Property> properties = repository.findByContext('app')
		properties.each {property ->
			databaseProperties.put(property.key, property.value)
		}
	}

	static main(args) {
		ApplicationProperties properties = new ApplicationProperties()
	}
}
