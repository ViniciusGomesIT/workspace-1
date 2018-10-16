package com.vinicius.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:messages.properties")
public class ResourcesConfiguration {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
	    return new PropertySourcesPlaceholderConfigurer();
	}

}
