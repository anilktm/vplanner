
package com.ibm.claims.config;

import javax.servlet.MultipartConfigElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;


@Configuration
@EnableConfigurationProperties(CloudantConfigurationProperties.class)
public class CloudDatabaseConfiguration {

    private final Logger logger = LoggerFactory.getLogger(CloudDatabaseConfiguration.class);
    
	@Autowired
	CloudantConfigurationProperties properties;

	@Bean
	public CloudantClient client() {
		ClientBuilder builder = ClientBuilder
			.account(properties.getAccount())
			.username(properties.getUserName())
			.password(properties.getPassword());
		return builder.build();
	}
	
	@Bean
	public Database getDataBase() {
		logger.info("get cloudant database");
		return client().database(properties.getDataBase(), false);
	}
	
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // Single data size
        factory.setMaxFileSize(DataSize.ofKilobytes(102400));
       // factory.setMaxFileSize("10240KB"); // KB,MB
        /// Total upload data size
        //factory.setMaxRequestSize("102400KB");
        factory.setMaxRequestSize(DataSize.ofKilobytes(102400));
        return factory.createMultipartConfig();
    }
}
