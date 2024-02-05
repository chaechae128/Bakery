package com.bakery.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.bakery.user.mapper.UserMapper;

@Service
public class UserBO {
	@Autowired
	private UserMapper userMapper;
	//input:  loginId  //output:성공한 행의 개수(count)
	public int isDuplicatedId(String loginId) {
		int count = userMapper.isDuplicatedId(loginId); 
		return count;
	}
	
	//input: 파라미터들 //output:성공한 행 개수
	public int addUser(String loginId, String password, String name, String email, String phoneNumber, int postCode, String address) {
		return  userMapper.insertUser(loginId, password, name, email, phoneNumber, postCode, address);
	}
	
}
