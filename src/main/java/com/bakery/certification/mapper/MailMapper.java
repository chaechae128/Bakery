package com.bakery.certification.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MailMapper {
	public void insertCertificationCode(
			@Param("certificationCode")String certificationCode, 
			@Param("userId")int userId);
}
