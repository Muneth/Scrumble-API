package com.atempo.internal.scrumble;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.atempo.internal.scrumble.api")
@EnableTransactionManagement
@EnableJpaRepositories("com.atempo.internal.scrumble.repository")
@EnableConfigurationProperties
@EnableCaching
public class ApplicationConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		// mapper.addMappings();

		mapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE)
				.setSkipNullEnabled(true);
		return mapper;
	}

}
