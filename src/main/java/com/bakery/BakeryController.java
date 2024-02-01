package com.bakery;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bakery")
public class BakeryController {

	
	@RequestMapping("/home-view")
	public String homeView(Model model) {
		model.addAttribute("viewName", "home/homeView");
		return "template/bakeryLayout";
	}
}
