package kr.co.rland.web.controller.admin;

import java.security.Principal;
import java.util.List;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.service.MenuService;

@Controller("adminMenuController")
@RequestMapping("/admin/menu")
public class MenuController {
	
	@Autowired
	private MenuService service;

	@GetMapping("list")
	public String list(
			@RequestParam(name = "p", defaultValue = "1") int page,
			@RequestParam(name="c", required = false) Integer categoryId,
			@RequestParam(name="q", required = false) String query,
			Model model,
			HttpSession session
			){
		
//		if(session.getAttribute("isAuth") == null){
//			return "redirect:/user/login";
//		}
		
		List<MenuView> list = service.getViewList(page,categoryId, query);
		model.addAttribute("list", list);
		
		return "admin/menu/list";
	}
	
	@GetMapping("detail")
	public String detail(
			int id,
			Model model) {
		
		Menu menu = service.getById(id);
		model.addAttribute("menu", menu);
		
		return "admin/menu/detail";
	}
	
	// /admin/menu/reg
	// /admin/menu/reg.html
	// /admin/menu/reg.jsp
	
	// 등록폼을 주세요
	//@RequestMapping("reg")//-> service():Get/Post를 내가 다 처리하는 매핑
	@GetMapping("reg")
	public String reg() {
		return "/WEB-INF/view/admin/menu/reg.jsp";
	}
	
	// 폼입력해서 제출이요
	//@RequestMapping("reg")
	@PostMapping("reg")
	public String reg(String title,
			Authentication authentication,
			 Principal principa) {
		String userName = authentication.getName();
		System.out.println(userName);
		
		UserDetails user = (UserDetails)authentication.getPrincipal();
		System.out.println(user);
		
		System.out.println(principa.getName());
		
		
		
		// 등록하고
		System.out.println("메뉴 등록 완료");
		 //Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 사용자 권한 확인
		return "redirect:list";
	}
}
