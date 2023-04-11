package kr.co.rland.web.controller.admin;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller("adminHomeController")
@RequestMapping("admin")
public class HomeController {

	@GetMapping("index")
	public String index(HttpSession session) {
//		if (session.getAttribute("username")==null) {
//			return "redirect:/user/login?returnURL=/admin/index";
//		}  
		return "admin/index";
	}
}
