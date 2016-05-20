package net.tsolval.config

import org.springframework.stereotype.Component;

@Component
class ApplicationDomainConfig {
	String domain
	List<String> subDomains

	def setSubDomains(List<String> subDomainList){
		subDomains=subDomainList
	}

	def setSubDomains(String subDomainString){
		subDomains=subDomainString.split(/,/);
	}

	public static void main(String[] args){
		ApplicationDomainConfig config = new ApplicationDomainConfig()
		config.setDomain("app");
		config.setSubDomains(['model', 'web'])
		assert config.getSubDomains()==['model', 'web']
		config.setSubDomains('model,web')
		assert config.getSubDomains()==['model', 'web']
	}
}
