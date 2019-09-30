package petshop.ssm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("PageResourse")
public class PageToController {

	@RequestMapping("toPetshop")
	public String toPetShop() { 
		return "jsp/petshop";
	}
	
	@RequestMapping("toLogin")
	public String toLoginPage() {
		return "login";
	}
}
