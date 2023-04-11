package kr.co.rland.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rland.web.dto.MenuListData;
import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.service.MenuService;

@RestController("apiMenuController")
//@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("menus")
public class MenuController {
	
	@Autowired
	private MenuService service;
		
	@GetMapping
	public Map<String, Object> getList(
			@RequestParam(name="p", defaultValue = "1") int page, 
			@RequestParam(name = "c", required = false) Integer categoryId, 
			@RequestParam(name = "q", required = false) String query){
		
		List<MenuView> list = service.getViewList(page, categoryId, query);
		// List<MenuView> newMenuList = service.getNewList();
		List<MenuView> newList = service.getViewList(2, categoryId, query); 
		
//		MenuListData data = new MenuListData();
//		data.setList(list);
//		data.setNewMenuList(newMenuList);
		
		Map<String, Object> data = new HashMap<>();
		data.put("list", list);
		data.put("newList", newList);
						
		return data;
	}
	
	@GetMapping("{id}")
	public Menu get(
			@PathVariable("id") int id){
		
		Menu menu = service.getById(id);
		
		return menu;
	}
	
	@PutMapping
	public String edit(
			@PathVariable("id") int id){
		return "menu edit:"+id;		
	}
	
	@DeleteMapping("{id}")
	public String delete(
			@PathVariable("id") int id){
		return "menu del:"+id;		
	}
	
	@PostMapping
	public String insert(@RequestBody Menu menu){
		menu.setCategoryId(1);
		service.add(menu);
		//int id = service.lastMenuId();
		//Menu lastMenu = service.last();
		
		return "ok";		
	}
}
