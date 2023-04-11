package kr.co.rland.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class RlandSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
		.requestMatchers("/admin/**").hasAnyRole("ADMIN")
		.requestMatchers("/member/**").hasAnyRole("ADMIN", "MEMBER")
		.anyRequest().permitAll();
		
		
		return http.build();
	}
}
