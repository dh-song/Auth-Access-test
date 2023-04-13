package kr.co.rland.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class RlandSecurityConfig {
	
	@Autowired
	private DataSource dataSource;
	
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
		
//		커스텀
//	@Bean
//	public UserDetailsService rlandUserDetailsService() {
//		
//		return new RlandUserDetailsService();
//	}
		
	}
//	@Bean JDBC 서비스
	public UserDetailsService jdbcUserdetailsService() {
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
		manager.setUsersByUsernameQuery("select username, pwd password, 1 enabled from member where username = ?");
		manager.setAuthoritiesByUsernameQuery("select username, 'ROLE_ADMIN' authority from member where username = ?");
		return manager;
	}
	
//	@Bean 서버 메모리 서비스
	public UserDetailsService userDetailsService() {
		UserDetails newlec = User.builder().username("newlec").password(passwordEncoder().encode("111")).roles("ADMIN","MEMBER").build();
		UserDetails dragon = User.builder().username("dragon").password(passwordEncoder().encode("123")).roles("MEMBER").build();

		
		return new InMemoryUserDetailsManager(newlec, dragon);
	
	}
}
