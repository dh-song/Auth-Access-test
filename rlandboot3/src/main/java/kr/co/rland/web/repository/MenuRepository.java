package kr.co.rland.web.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;

@Mapper
public interface MenuRepository {	
//	List<Menu> findAll();
//	List<Menu> findAll(Integer offset, Integer size);
	List<Menu> findAll(
						Integer offset, 
						Integer size, 
						String query, 
						Integer categoryId,
						Integer price,
						String orderField,
						String orderDir);
	List<MenuView> findViewAll(
			Integer offset, 
			Integer size, 
			String query, 
			Integer categoryId,
			Integer price,
			String orderField,
			String orderDir);
	List<Menu> findAllByIds(List<Long> ids);
	Menu findById(long id);
	int count(
			String query, 
			Integer categoryId,
			Integer price);
	int insert(Menu menu);
	@Transactional
	int update(Menu menu);
	void delete(long id);
}
