package com.bakery.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bakery.user.bo.UserBO;
import com.bakery.user.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserBO userBO;
	
	@RequestMapping("/sign-up-view")
	public String signUpView(Model model) {
		model.addAttribute("viewName", "/user/signUp");
		
		return "template/bakeryLayout";
	}
	
	@RequestMapping("/user-manage-view")
	public String  userManageview(Model model) {
		model.addAttribute("viewName", "/user/userManage");
		List<User> userList = userBO.selectUserList();
		model.addAttribute("userList", userList);
		return "template/managerLayout";
	}
}
