package kr.co.rland.web.dto;

import java.util.List;

import kr.co.rland.web.entity.MenuView;

public class MenuListData {
	private List<MenuView> list;
	private List<MenuView> newMenuList;
	
	public MenuListData() {
		// TODO Auto-generated constructor stub
	}

	public List<MenuView> getList() {
		return list;
	}

	public void setList(List<MenuView> list) {
		this.list = list;
	}

	public List<MenuView> getNewMenuList() {
		return newMenuList;
	}

	public void setNewMenuList(List<MenuView> newMenuList) {
		this.newMenuList = newMenuList;
	}

	@Override
	public String toString() {
		return "MenuListData [list=" + list + ", newMenuList=" + newMenuList + "]";
	}	
}
