package kr.co.rland.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.repository.MenuRepository;

@Service
public class DefaultMenuService implements MenuService {

	@Autowired
	private MenuRepository repository;
	
	public void setRepository(MenuRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Menu> getList() {
		// TODO Auto-generated method stub		
		return repository.findAll(0,10,"",1,null,"regDate", "desc");
	}

	@Override
	public List<Menu> getList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> getList(int page, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> getList(int page, Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> getList(int page, Integer categoryId, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuView> getViewList() {
		// TODO Auto-generated method stub
		int page=1;
		int size=10;
		List<MenuView> list = repository.findViewAll(page, size, null, null, null, null, null);
		
		return list;
	}

	@Override
	public List<MenuView> getViewList(int page) {
		// TODO Auto-generated method stub
		
		int size=10;
		List<MenuView> list = repository.findViewAll(page, size, null, null, null, null, null);
		
		return list;
	}

	@Override
	public List<MenuView> getViewList(int page, String query) {
		// TODO Auto-generated method stub
		int size=10;
		List<MenuView> list = repository.findViewAll(page, size, query, null, null, null, null);
		
		return list;
	}

	@Override
	public List<MenuView> getViewList(int page, Integer categoryId) {
		int size=10;
		List<MenuView> list = repository.findViewAll(page, size, null, categoryId, null, null, null);
		
		return list;
	}

	@Override
	public List<MenuView> getViewList(int page, Integer categoryId, String query) {
		
		int size=9;
		int offset = (page-1)*size; // 1->0, 2->10, 3->20,
		String orderField = "reg_date";
		String order = "desc";
		
		List<MenuView> list = repository.findViewAll(offset, size, query, categoryId, null, orderField, order);
		
		return list;
	}
	

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void pointUp() {
		
		Menu menu1 = new Menu();
		//menu.setId(919L);
		menu1.setName("아유~아메리지요");
		menu1.setRegMemberId(1L);
		menu1.setPrice(3000);
		repository.insert(menu1);

		Menu menu = new Menu();
		menu.setId(919L);
		menu.setPrice(8000);
		repository.update(menu);
	}

	@Override
	public Menu getById(long id) {
		
		Menu menu = repository.findById(id);
		
		return menu;
	}

	@Override
	public void add(Menu menu) {
		// TODO Auto-generated method stub
		repository.insert(menu);
	}


}
