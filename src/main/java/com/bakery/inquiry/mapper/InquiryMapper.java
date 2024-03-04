package com.bakery.inquiry.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InquiryMapper {

	
	public int insertInquiry (
			@Param("userId")int userId, 
			@Param("subject")String subject, 
			@Param("content")String content, 
			@Param("imagePath")String imagePath);
}
