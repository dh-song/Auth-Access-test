package kr.co.rland.web.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;

// 스프링이 제공하는 객체 생성 어노테이션
//@Component
//	@Controller
//	@Service
//	@Repository
//	@Configuration
//		@Bean

//@Controller
public class Config {


	
	@Bean
	public List list() {	
		return new ArrayList();
	}
	
	@Bean
	public String hello() {
		return "Hello 콩자루?";
	}
	
}
