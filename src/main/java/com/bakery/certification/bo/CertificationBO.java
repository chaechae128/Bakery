package com.bakery.certification.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakery.certification.domain.Certification;
import com.bakery.certification.mapper.CertificationMapper;

@Service
public class CertificationBO {
	@Autowired
	private CertificationMapper certificationMapper;
	
	//인증코드 업데이트
    public void insertCertificationCode(String certificationCode, int userId){
    	certificationMapper.insertCertificationCode(certificationCode, userId);
    	
    }
    
    //인증 번호 확인
    public Certification selectCertification(int userId, String code) {
    	Certification certification = certificationMapper.selectCertification(userId, code);
    	return certification;
    }
    
    public void deleteCertification(int userId, String code) {
    	certificationMapper.deleteCertification(userId, code);
    }
}
