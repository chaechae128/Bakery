package com.bakery.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bakery.aop.TimeTrace;
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
	 * 
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
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@TimeTrace
	@RequestMapping("sign-in-view")
	public String signInView(Model model, HttpSession session) {
		model.addAttribute("viewName", "/user/signIn");
		String userName = (String) session.getAttribute("userName");
		Integer userId = (Integer) session.getAttribute("userId");
		model.addAttribute("userName", userName);
		model.addAttribute("userId", userId);
		return "template/bakeryLayout";
	}

	/**
	 * 로그아웃
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/sign-out")
	public String signOut(HttpSession session) {
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");

		return "redirect:/bakery/home-view";
	}

	/**
	 * 아이디 찾기 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/find-id-view")
	public String findIdView(Model model) {
		model.addAttribute("viewName", "/user/findId");
		return "template/bakeryLayout";
	}

	/**
	 * 아이디 찾기
	 * 
	 * @param email
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping("/find-id")
	public String findId(@RequestParam("email") String email, @RequestParam("name") String name, Model model) {
		// db select
		User user = userBO.selectUserByEmailName(email, name);

		model.addAttribute("user", user);
		model.addAttribute("viewName", "/user/completeFindId");
		return "template/bakeryLayout";
	}

	/**
	 * 비밀번호 찾기 화면
	 * @param model
	 * @return
	 */
	@RequestMapping("/find-password-view")
	public String findPasswordView(Model model) {
		model.addAttribute("viewName", "/user/findPassword");
		return "template/bakeryLayout";
	}


	/**
	 * 비밀번호 찾기 - 인증번호 확인
	 * @param model
	 * @return
	 */
	@RequestMapping("/check-certificationCode-view")
	public String checkCertificationCodeView(Model model) {
		model.addAttribute("viewName", "/user/checkCertification");
		return "template/bakeryLayout";
	}
	
	/**
	 * 비밀번호 찾기 - 비밀번호 재설정
	 * @param model
	 * @return
	 */
	@RequestMapping("/reset-password-view")
	public String resetPasswordView(Model model) {
		model.addAttribute("viewName", "/user/resetPassword");
		return "template/bakeryLayout";
	}
	/**
	 * 관리자- 회원관리 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/user-manage-view")
	public String userManageview(Model model) {
		model.addAttribute("viewName", "/user/userManage");
		List<User> userList = userBO.selectUserList();
		model.addAttribute("userList", userList);
		return "template/managerLayout";
	}

	/**
	 * 관리자 - 회원 검색
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping("/searchUser")
	public String searchUser(
			@RequestParam("userName") String userName,
			Model model){
		//db select
		List<User> userList = userBO.selectUserByName(userName);
		model.addAttribute("viewName", "/user/userManage");
		model.addAttribute("userList", userList);
		return "template/managerLayout";
	}
	
	@GetMapping("/myPage") 
	public String myPage(
			@RequestParam("userId") int userId,
			Model model,
			HttpSession session) {
		int userid = (int) session.getAttribute("userId");
		User user = userBO.selectByUserId(userid);
		
		model.addAttribute("user", user);
		model.addAttribute("viewName", "/myPage/userInformation");
		return "template/bakeryLayout";
	}
	
}
