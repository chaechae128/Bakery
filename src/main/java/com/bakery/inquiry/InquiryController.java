package com.bakery.inquiry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/inquiry")
@Controller
public class InquiryController {
	
	@RequestMapping("/inquiry-list-view") 
	public String inquiryListView(
			Model model,
			HttpSession session) {
		int userid = (int) session.getAttribute("userId");
		
		model.addAttribute("viewName", "/myPage/inquiryList");
		return "template/bakeryLayout";
	}
	
	
	@RequestMapping("/inquiry-create-view") 
	public String inquiryCreateView(
			Model model,
			HttpSession session) {
		
		model.addAttribute("viewName", "/myPage/inquiryCreate");
		return "template/bakeryLayout";
	}
}
