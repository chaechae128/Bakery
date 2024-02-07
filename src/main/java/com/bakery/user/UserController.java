package com.bakery.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bakery.user.bo.UserBO;
import com.bakery.user.domain.User;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserBO userBO;
	
	/**
	 * 회원가입 화면
	 * @param model
	 * @return
	 */
	@RequestMapping("/sign-up-view")
	public String signUpView(Model model) {
		model.addAttribute("viewName", "/user/signUp");
		
		return "template/bakeryLayout";
	}
	
	/**
	 * 로그인 화면
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("sign-in-view")
	public String signInView(Model model,HttpSession session) {
		model.addAttribute("viewName", "/user/signIn");
		String userName = (String) session.getAttribute("userName");
		model.addAttribute("userName", userName);
		return "template/bakeryLayout";
	}
	
	@RequestMapping("/sign-out")
	public String signOut(HttpSession session) {
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		
		return "redirect:/bakery/home-view";
	}
	
	@RequestMapping("/find-id-view")
	public String findIdView(Model model) {
		model.addAttribute("viewName", "/user/findId");
		return "template/bakeryLayout";
	}
	
	@RequestMapping("/find-id")
	public String findId(
			@RequestParam("email") String email,
			@RequestParam("name") String name,
			Model model){
		//db select
		User user = userBO.selectUserByEmailName(email, name);
		
		model.addAttribute("user", user);
		model.addAttribute("viewName", "/user/completeFindId");
		return "template/bakeryLayout";
	}
	
	
	/**
	 * 관리자- 회원관리 화면
	 * @param model
	 * @return
	 */
	@RequestMapping("/user-manage-view")
	public String  userManageview(Model model) {
		model.addAttribute("viewName", "/user/userManage");
		List<User> userList = userBO.selectUserList();
		model.addAttribute("userList", userList);
		return "template/managerLayout";
	}
	
}
