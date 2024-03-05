package com.bakery.inquiry;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bakery.inquiry.bo.InquiryBO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/inquiry")
public class InquiryRestController {
	
	@Autowired
	private InquiryBO inquiryBO;

	/**
	 * 문의글 작성 API
	 * @param subject
	 * @param content
	 * @param file
	 * @param session
	 * @return
	 */
	@RequestMapping("/create")
	public Map<String, Object> create(
			@RequestParam("subject") String subject,
			@RequestParam("content") String content,
			@RequestParam(value="file", required = false) MultipartFile file,
			HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		Map<String, Object> result = new HashMap<>();
		// 로그인 되어있는지 확인
		if (userId == null) {
			result.put("code", 300);
			result.put("error_message", "로그인이 되어있지 않습니다. 로그인 후 이용해주세요");
			return result;
		}
		
		//db insert
		int count = inquiryBO.addInquiry(userId, subject, content, file);
		
		if (count > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "실패");
		}
		return result;
	}
	
	/**
	 * 문의글 수정 API
	 * @param inquiryId
	 * @param subject
	 * @param content
	 * @param file
	 * @param session
	 * @return
	 */
	@RequestMapping("/update")
	public Map<String, Object> update (
			@RequestParam("inquiryId") int inquiryId,
			@RequestParam("subject") String subject,
			@RequestParam("content") String content,
			@RequestParam(value="file", required = false) MultipartFile file,
			HttpSession session) {
		
		Integer userId = (Integer) session.getAttribute("userId");
		Map<String, Object> result = new HashMap<>();
		// 로그인 되어있는지 확인
		if (userId == null) {
			result.put("code", 300);
			result.put("error_message", "로그인이 되어있지 않습니다. 로그인 후 이용해주세요");
			return result;
		}
		
		//db update
		int count = inquiryBO.updateInquiry(inquiryId, subject, content, file);
		
		if (count > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "실패");
		}
		return result;
	}
	
	/**
	 * 문의글 답변 달기 API
	 * @param inquiryId
	 * @param reply
	 * @return
	 */
	@RequestMapping("/reply")
	public Map<String, Object> reply(
			@RequestParam("inquiryId") int inquiryId,
			@RequestParam("reply") String reply
			) {
		Map<String, Object> result = new HashMap<>();
		//db update
		int count = inquiryBO.updateReplyById(inquiryId, reply);
		
		if (count > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "실패");
		}
		return result;
		
	}
	
}
