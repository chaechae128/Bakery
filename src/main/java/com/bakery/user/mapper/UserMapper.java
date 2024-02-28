package com.bakery.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bakery.user.domain.User;

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
	
	//user List
	public List<User> selectUserList();
	
	public List<User> selectUserByName(String name);
	
	public User selectUserByLoginIdPassword(
			@Param("loginId")String loginId, 
			@Param("password")String password);
	
	
	public User selectUserByEmailName(
			@Param("email")String email, 
			@Param("name")String name);
	
	public void updatePassword(
			@Param("userId")int userId, 
			@Param("password")String password);
	
	public User selectByUserId(int userId);
	
	public int updateUser(
			@Param("userId")int userId, 
			@Param("upEmail")String upEmail, 
			@Param("upNumber")String upNumber, 
			@Param("upAddress")String upAddress);
	
	public int deleteUserByUserId(int userId);
}
