package kr.co.rland.web.entity;

import java.util.Date;

public class MenuView extends Menu {
	private String categoryName;
	
	public MenuView() {
		// TODO Auto-generated constructor stub
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public MenuView(Long id, String name, Integer price, String img, Date regDate, Integer categoryId,
			Long regMemberId, String categoryName) {
		super(id, name, price, img, regDate, categoryId, regMemberId);
		// TODO Auto-generated constructor stub
		this.categoryName = categoryName;
	}

	public MenuView(String name, Integer price, String img, Integer categoryId, Long regMemberId, String categoryName) {
		super(name, price, img, categoryId, regMemberId);
		// TODO Auto-generated constructor stub
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "MenuView [categoryName=" + categoryName + "]";
	}
	
	
	
	
}
