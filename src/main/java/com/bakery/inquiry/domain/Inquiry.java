package com.bakery.inquiry.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Inquiry {
	private int id;
	private int userId;
	private String subject;
	private String content;
	private String imagePath;
	private String reply;
	private Date createdAt;
	private Date updatedAt;
}
