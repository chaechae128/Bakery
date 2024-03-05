package com.bakery.inquiry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bakery.inquiry.bo.InquiryBO;
import com.bakery.inquiry.domain.Inquiry;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/inquiry")
@Controller
public class InquiryController {
	
	@Autowired
	private InquiryBO inquiryBO;
	
	/**
	 * 문의글 목록
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/inquiry-list-view") 
	public String inquiryListView(
			Model model,
			HttpSession session) {
		int userid = (int) session.getAttribute("userId");
		List<Inquiry> inquiryList = inquiryBO.selectInquiryByUserId(userid);
		model.addAttribute("viewName", "/myPage/inquiryList");
		model.addAttribute("inquiryList", inquiryList);
		return "template/bakeryLayout";
	}
	
	/**
	 * 문의글 작성
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/inquiry-create-view") 
	public String inquiryCreateView(
			Model model,
			HttpSession session) {
		
		model.addAttribute("viewName", "/myPage/inquiryCreate");
		return "template/bakeryLayout";
	}
	
	/**
	 * 회원 문의글 자세히
	 * @param model
	 * @param session
	 * @param inquiryId
	 * @return
	 */
	@GetMapping("/inquiry-detail-view")
	public String inquiryDetailView(Model model,
			HttpSession session,
			@RequestParam("inquiryId") int inquiryId) {
		Inquiry inquiry = inquiryBO.selectInquiryById(inquiryId);
		
		model.addAttribute("inquiry", inquiry);
		model.addAttribute("viewName", "/myPage/inquiryDetail");
		return "template/bakeryLayout";
		
	}
	
	/**
	 * 관리자 - 문의글 리스트
	 * @param model
	 * @return
	 */
	@RequestMapping("/inquiry-manage-view")
	public String inquiryManageView (Model model) {
		List<Inquiry> inquiryList = inquiryBO.selectInquiryList();
		model.addAttribute("inquiryList", inquiryList);
		model.addAttribute("viewName", "/inquiry/inquiryManage");
		return "template/managerLayout";
	}
	
	/**
	 * 문의글 답변달기 화면
	 * @param model
	 * @param inquiryId
	 * @return
	 */
	@GetMapping("/inquiry-reply-view")
	public String inquiryReplyView(Model model,
			@RequestParam("inquiryId") int inquiryId) {
		Inquiry inquiry = inquiryBO.selectInquiryById(inquiryId);
		
		model.addAttribute("inquiry", inquiry);
		model.addAttribute("viewName", "/inquiry/inquiryReply");
		return "template/managerLayout";
	}
}
