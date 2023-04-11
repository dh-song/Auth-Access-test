package kr.co.rland.web.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import kr.co.rland.web.entity.Menu;

@AutoConfigureTestDatabase(replace=Replace.NONE)
@MybatisTest
//@AutoConfigureMybatis
//@SpringBootTest
class MenuRepositoryTest {

	@Autowired
	private MenuRepository repository;
//	
	@Test
	void testFindAll() {
		List<Menu> list = repository.findAll(0,10,null,null,null,null,null);
		System.out.println(list);
	}
	
	/*
	아메리카노 / 5000원 | / 음료 / 함께하면 좋은 메뉴:5개 / 좋아요 : 2 / 댓글 : 3
	소금라떼 / 20000원 	| / 음료 / 함께하면 좋은 메뉴:2개 / 좋아요 : 2 / 댓글 : 5
	초코쿠키 / 1000원	| / 스낵 / 함께하면 좋은 메뉴:1개 / 좋아요 : 2  / 댓글 : 5
	아메리카노 / 5000원	| / 음료 / 함께하면 좋은 메뉴:5개 / 좋아요 : 2  / 댓글 : 5
	아메리카노 / 5000원	| / 음료 / 함께하면 좋은 메뉴:5개 / 좋아요 : 2  / 댓글 : 5
	아메리카노 / 5000원	| / 음료 / 함께하면 좋은 메뉴:5개 / 좋아요 : 2  / 댓글 : 5
	 */
	
	//@Test
	void testFindAllByIds() {
		List<Long> ids = new ArrayList<>();
		ids.add(616L);
		ids.add(617L);
		ids.add(713L);
		ids.add(737L);
		
		List<Menu> list = repository.findAllByIds(ids);
		System.out.println(list);
	}

	//@Test
	void testUpdate() {
		Menu menu = new Menu();
		menu.setId(856L);
		menu.setName("아마아마리카노");
		
		int result = repository.update(menu);
		System.out.println(result);
	}
	
	@Test
	void testCount() {
		int count = repository.count(null,null,null);
		System.out.println(count);				
	}

}
