package com.bakery.inquiry.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.bakery.inquiry.domain.Inquiry;

@Mapper
public interface InquiryMapper {

	
	public int insertInquiry (
			@Param("userId")int userId, 
			@Param("subject")String subject, 
			@Param("content")String content, 
			@Param("imagePath")String imagePath);
	
	public List<Inquiry> selectInquiryByUserId (int userId);
	
	public Inquiry selectInquiryById (int inquiryId);
	
	public int updateInquiry (
			@Param("inquiryId")int inquiryId, 
			@Param("subject")String subject, 
			@Param("content")String content,
			@Param("imagePath")String imagePath);
}
