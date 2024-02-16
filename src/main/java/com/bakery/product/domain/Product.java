package com.bakery.product.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Product {
	private int id;
	private String productName;
	private String imagePath;
	private int stock;
	private int costPrice;
	private int sellingPrice;
	private String category;
	private Date createdAt;
	private Date updatedAt;
	
	//로그인 한 사람이 하트 눌렀는지
	private boolean filledLike;
}
