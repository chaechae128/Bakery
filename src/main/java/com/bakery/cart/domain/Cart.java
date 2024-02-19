package com.bakery.cart.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Cart {
	private int id;
	private int productId;
	private int userId;
	private int count;
	private Date createdAt;
	private Date updatedAt;
	
}	
