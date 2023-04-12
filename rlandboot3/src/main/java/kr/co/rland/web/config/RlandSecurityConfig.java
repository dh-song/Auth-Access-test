package kr.co.rland.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import kr.co.rland.web.entity.Member;

@Configuration
public class RlandSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.cors()
		.and()
		
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.requestMatchers("/admin/**").hasAnyRole("ADMIN")
		.requestMatchers("/member/**").hasAnyRole("ADMIN", "MEMBER")
		.anyRequest().permitAll()
		
		.and()
		.formLogin()
		.loginPage("/user/login")
//		.loginProcessingUrl("/user/login")
		.loginProcessingUrl("/user/loginsdfsdf")
		.usernameParameter("uid")
        .passwordParameter("pwd")
		.defaultSuccessUrl("/admin/index")
		
		.and()
		.logout()
		.logoutUrl("/user/logoutt")
		.logoutSuccessUrl("/index");
		return http.build();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails newlec = User.builder().username("newlec").password(passwordEncoder().encode("111")).roles("ADMIN","MEMBER").build();
		UserDetails dragon = User.builder().username("dragon").password(passwordEncoder().encode("123")).roles("MEMBER").build();

		
		return new InMemoryUserDetailsManager(newlec, dragon);
	
	}
}
