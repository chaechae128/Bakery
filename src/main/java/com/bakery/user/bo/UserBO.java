package com.bakery.user.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakery.certification.bo.CertificationBO;
import com.bakery.certification.bo.MailBO;
import com.bakery.certification.domain.Mail;
import com.bakery.user.domain.User;
import com.bakery.user.mapper.UserMapper;

@Service
public class UserBO {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private CertificationBO certificationBO;
	
	@Autowired
	private MailBO mailBO;
	//input:  loginId  //output:성공한 행의 개수(count)
	public int isDuplicatedId(String loginId) {
		int count = userMapper.isDuplicatedId(loginId); 
		return count;
	}
	
	//input: 파라미터들 //output:성공한 행 개수
	public int addUser(String loginId, String password, String name, String email, String phoneNumber, int postCode, String address) {
		return  userMapper.insertUser(loginId, password, name, email, phoneNumber, postCode, address);
	}
	
	//input:x output:List<User>
	public List<User> selectUserList() {
		return userMapper.selectUserList();
	}
	
	//input:name output:List<User>
	public List<User> selectUserByName(String name){
		return userMapper.selectUserByName(name);
	}
	
	//input:loginId, password   output:User
	public User selectUserByLoginIdPassword(String loginId, String password) {
		return userMapper.selectUserByLoginIdPassword(loginId, password);
	}
	
	//input:email, name output:User
	public User selectUserByEmailName(String email, String name) {
		return userMapper.selectUserByEmailName(email, name);
	}
	
	
	//input:user
	public void sendEmail(User user) {
		String certificationCode = mailBO.getCertificationCode();
		Mail mail = mailBO.createMailAndChangePassword(user.getEmail(), certificationCode);
		mailBO.mailSend(mail);
		certificationBO.insertCertificationCode(certificationCode, user.getId());
	}
	
	//input: password, userId
	public void updatePassword(int userId, String password) {
		userMapper.updatePassword(userId, password);
	}
	
	
	
}
