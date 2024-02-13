package com.bakery.certification.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Certification {
	private int id;
	private int userId;
	private String certificationCode;
	private Date createdAt;
}
