package com.example.council.data.hub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;

@SpringBootApplication
public class CouncilDataHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouncilDataHubApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);

		corsConfiguration.setAllowedOrigins(Arrays.asList(
				"https://council-data-hub.netlify.app",
				"http://localhost:4200",
				"https://test32123.netlify.app"
		));

		corsConfiguration.setAllowedHeaders(Arrays.asList(
				"Origin", "Content-Type", "Accept", "Authorization",
				"X-Requested-With", "Access-Control-Request-Method",
				"Access-Control-Request-Headers"
		));

		corsConfiguration.setExposedHeaders(Arrays.asList(
				"Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"
		));

		corsConfiguration.setAllowedMethods(Arrays.asList(
				"GET", "POST", "PUT", "DELETE", "OPTIONS"
		));

		// Set up URL-based CORS configuration
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

		// Return a new CORS filter based on the configuration
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
