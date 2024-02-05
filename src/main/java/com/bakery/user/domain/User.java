package com.bakery.user.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
	private int id;
	private String loginId;
	private String password;
	private String name;
	private String email;
	private String phoneNumber;
	private int postCode;
	private String address;
	private Date createdAt;
	private Date updatedAt;
}
