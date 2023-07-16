package com.Dmartready.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class AppConfig {

	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> {
			auth.requestMatchers(HttpMethod.POST, "stock/customers").permitAll()
					.requestMatchers(HttpMethod.GET,"stock/customers").hasRole("ADMIN")
					.requestMatchers(HttpMethod.DELETE, "/stock/delete/**").hasRole("ADMIN")
					.requestMatchers(HttpMethod.PUT, "/stock/update/**").hasRole("ADMIN")
					.requestMatchers(HttpMethod.POST, "/stock/add").hasRole("ADMIN")
					.requestMatchers(HttpMethod.POST, "/stock/move/**").hasRole("ADMIN")
					
					.requestMatchers(HttpMethod.GET, "stock/customers/**").hasAnyRole("ADMIN", "USER")
					.requestMatchers(HttpMethod.GET, "/stock/view/**").hasAnyRole("ADMIN", "USER").anyRequest()
					.authenticated();
		}).csrf(csrf -> csrf.disable()).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
