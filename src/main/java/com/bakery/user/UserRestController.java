package com.bakery.user;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bakery.certification.bo.CertificationBO;
import com.bakery.certification.bo.MailBO;
import com.bakery.certification.domain.Certification;
import com.bakery.certification.domain.Mail;
import com.bakery.common.EncryptUtils;
import com.bakery.user.bo.UserBO;
import com.bakery.user.domain.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserRestController {
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private MailBO mailBO;
	
	@Autowired
	private CertificationBO certificationBO;

	/**
	 * 아이디 중복확인 API
	 * @param loginId
	 * @return
	 */
	@RequestMapping("/is-duplicated-id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId){
		//db 중복확인
		Map<String, Object> result = new HashMap<>();
		int count = userBO.isDuplicatedId(loginId);
		if(count > 0) {
			result.put("code", 200);
			result.put("is_duplicated_id", true);
		} else {
			result.put("code", 200);
			result.put("is_duplicated_id", false);
		}
		
		return result;
	}
	
	/**
	 * 회원가입 API
	 * @param loginId
	 * @param password
	 * @param name
	 * @param email
	 * @param phoneNumber
	 * @param postCode
	 * @param address
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@RequestMapping("/sign-up")
	public Map<String, Object> signUp(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("postCode") int postCode,
			@RequestParam("address") String address) throws NoSuchAlgorithmException{
		String hashedPassword = EncryptUtils.sha256(password);
		
		//db insert
		int count = userBO.addUser(loginId, hashedPassword, name, email, phoneNumber, postCode, address);
		
		//count 가 0이 아니면 성공
		Map<String, Object> result = new HashMap<>();
		if(count > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("result", "실패");
		}
		return result;
	}
	/**
	 * 로그인API
	 * @param loginId
	 * @param password
	 * @param request
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@RequestMapping("/sign-in")
	public Map<String, Object> signIn(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			HttpServletRequest request) throws NoSuchAlgorithmException{
		
		String hashedPassword = EncryptUtils.sha256(password);
		User user = userBO.selectUserByLoginIdPassword(loginId, hashedPassword);
		Map<String, Object> result = new HashMap<>();
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userName", user.getName());
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 300);
			result.put("error_message", "존재하지 않는 사용자 입니다.");
		}
		
		return result;
	}
	
	@RequestMapping("/reset-pw")
	public  Map<String, Object> resetPw(
			@RequestParam("loginId") String loginId,
			@RequestParam("email") String email,
			@RequestParam("name") String name) {
		
		
		Map<String, Object> result = new HashMap<>();
		return result;
	}
	
	
	@RequestMapping("/searchUser")
	public Map<String, Object> searchUser(
			@RequestParam("name") String name){
		//db select
		List<User> userListByName = userBO.selectUserByName(name);
		//응답값
		Map<String, Object> result = new HashMap<>();
		if(userListByName != null) {
			result.put("code", 200);
			result.put("result", "성공");
			result.put("userListByName", userListByName);
		}
		else {
			result.put("code", 500);
			result.put("result", "실패");
		}
		return result;
	}
	
	
	
	@RequestMapping("find-password")
	public Map<String, Object> findPassword(
			@RequestParam("email")String email,
			@RequestParam("name") String name,
			HttpServletRequest request) {
		
		User user = userBO.selectUserByEmailName(email, name);
		
		Map<String, Object> result = new HashMap<>();
		
		if (user == null) {
			result.put("code", 500);
			result.put("error_message", "비밀번호 찾기에 실패했습니다.");
		} else {
			userBO.sendEmail(user);
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			result.put("code", 200);
			result.put("result", "성공");
		}
		return result;
	}
	
	/**
	 * 인증 번호 확인API
	 * @param code
	 * @return
	 */
	@RequestMapping("/check-certificationCode")
	public Map<String, Object> checkCertificationCode(
			@RequestParam("code") String code,
			HttpSession session){
		int userId = (Integer)session.getAttribute("userId");
		
		//인증번호가 db에 있는지 확인
		Certification certification = certificationBO.selectCertification(userId,code);
		
		//확인 후 응답 값
		Map<String, Object> result = new HashMap<>();
		if(certification != null) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "인증번호가 일치하지 않습니다.");
		}
		//확인 된 인증번호 db에서 delete
		certificationBO.deleteCertification(userId, code);
		
		return result;
	}
	
	@RequestMapping("/reset-password")
	public Map<String, Object> resetPassword(
			@RequestParam("password") String password,
			HttpSession session) throws NoSuchAlgorithmException{
		int userId = (Integer)session.getAttribute("userId");
		String hashedPassword = EncryptUtils.sha256(password);
		//비밀번호 재설정
		userBO.updatePassword(userId, hashedPassword);
		//응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
	
}
