package com.bakery.inquiry.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bakery.common.FileManagerService;
import com.bakery.inquiry.mapper.InquiryMapper;

@Service
public class InquiryBO {
	@Autowired
	private FileManagerService fileManagerService;
	
	@Autowired
	private InquiryMapper inquiryMapper;
	
	//input subject, content, imageFile
	public int addInquiry (int userId, String subject, String content, MultipartFile file) {
		String imagePath = null;
		if(file != null) {
			imagePath = fileManagerService.saveFile(file);
		}
		
		
		return inquiryMapper.insertInquiry(userId, subject, content, imagePath);
		
		
	}
}
