package kr.co.rland.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class HomeController {

	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile[] imgs, HttpServletRequest request) throws IllegalStateException, IOException {		
		
		for(int i=0; i<imgs.length; i++)
		{
			MultipartFile img = imgs[i];
			
			if(img.isEmpty())
				continue;
			
			String urlPath = "/image/menu/"+img.getOriginalFilename();
			String realPath = request.getServletContext().getRealPath(urlPath); 
			//realPath = this.getClass().getResource("/").getPath();
			
			System.out.println(realPath);
			
	//		InputStream fis = img.getInputStream();
	//		OutputStream fos = new FileOutputStream(realPath);
	//		byte[] buf = new byte[1024];
	//		int size = 1024;
	//		while((size = fis.read(buf))!=-1)
	//			fos.write(buf, 0, size);
	//		
	//		fis.close();
	//		fos.close();
			
			img.transferTo(new File(realPath));
		}
		
		return "ok";
	}
	
	@RequestMapping("index")
	public String index(Model model, HttpServletResponse response) throws UnsupportedEncodingException {
		
		//String data = "Hello Data";
		
		String data = URLEncoder.encode("cookie 지륭~", "utf-8");		
		System.out.println(data);
		Cookie cookie = new Cookie("my", data);
		response.addCookie(cookie);		
		
		model.addAttribute("data", data);
		
		return "index";
	}	
}
