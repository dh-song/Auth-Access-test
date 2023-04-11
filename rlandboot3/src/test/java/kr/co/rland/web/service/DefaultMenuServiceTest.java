package kr.co.rland.web.service;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.rland.web.entity.Menu;

@SpringBootTest
@AutoConfigureMybatis
class DefaultMenuServiceTest {

	@Autowired
	private MenuService service;
	
	@Test
	void test() {
		//service.pointUp();
		//List<MenuView> list = service.getViewList();
		//System.out.println(list);
		
		Menu menu = service.getById(617L);
		System.out.println(menu);
		
		System.out.println("작업완료");
	}

}
