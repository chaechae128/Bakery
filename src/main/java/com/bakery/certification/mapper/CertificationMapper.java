package com.bakery.certification.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bakery.certification.domain.Certification;

@Mapper
public interface CertificationMapper {
	public void insertCertificationCode(
			@Param("certificationCode")String certificationCode, 
			@Param("userId")int userId);
	
	public Certification selectCertification(
			@Param("userId")int userId, 
			@Param("code")String code);
	
	public void deleteCertification(
			@Param("userId")int userId, 
			@Param("code")String code);
}
