package com.bakery.inquiry.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bakery.common.FileManagerService;
import com.bakery.inquiry.domain.Inquiry;
import com.bakery.inquiry.mapper.InquiryMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
	
	//input: userId
	public List<Inquiry> selectInquiryByUserId (int userId) {
		return inquiryMapper.selectInquiryByUserId(userId);
	}
	
	//input:inquiryId
	public Inquiry selectInquiryById (int inquiryId) {
		return inquiryMapper.selectInquiryById(inquiryId);
	}
	
	public int updateInquiry (int inquiryId, String subject, String content, MultipartFile file) {
		Inquiry inquiry = inquiryMapper.selectInquiryById(inquiryId);
		if (inquiry == null) {
			log.info("[글 수정] inquiry is null. inquiryId:{}", inquiryId ); //개인프로젝트 시 많이 찍어두는 것이 좋음
			return 0;
		}
		
		String imagePath = null;
		if(file != null) {
			imagePath = fileManagerService.saveFile(file);
			
			if(imagePath != null && inquiry.getImagePath() != null) {
				//업로드 성공하고 기존 이미지 있으면 서버의 파일 제거
				fileManagerService.deleteFile(inquiry.getImagePath()); //imagePath를 파라미터로 넘기면 방금 받아온 이미지를 삭제하는 것이기 떄문에 주의!
			}
		} 
		
		return inquiryMapper.updateInquiry(inquiryId, subject, content, imagePath);
	}
	
	//input:x output:List<Inquiry>
	public List<Inquiry> selectInquiryList () {
		return inquiryMapper.selectInquiryList();
	}
	
	//input: inquiryId, reply 
	public int updateReplyById (int inquiryId, String reply) {
		return inquiryMapper.updateReplyById(inquiryId, reply);
	}
}
