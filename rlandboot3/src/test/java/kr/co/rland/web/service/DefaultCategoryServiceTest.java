package kr.co.rland.web.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.rland.web.entity.Category;

@SpringBootTest
@AutoConfigureMybatis
class DefaultCategoryServiceTest {

	@Autowired
	private CategoryService service;
	@Test
	void testGetList() {
		List<Category> list = service.getList();
		System.out.println(list);
	}

}
