package com.bakery.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
	
	//아이디 중복확인
	public int isDuplicatedId(String loginId);
	
	//회원가입
	public int insertUser(
			@Param("loginId")String loginId, 
			@Param("password")String password, 
			@Param("name")String name, 
			@Param("email")String email, 
			@Param("phoneNumber")String phoneNumber, 
			@Param("postCode")int postCode, 
			@Param("address")String address);
}
