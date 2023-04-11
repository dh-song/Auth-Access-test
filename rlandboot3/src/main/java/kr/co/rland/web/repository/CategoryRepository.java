package kr.co.rland.web.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.rland.web.entity.Category;

@Mapper
public interface CategoryRepository {
	List<Category> findAll();
	Category findById(int id);
	int insert(Category category);
	int update(Category category);
	void delete(int id);
}
