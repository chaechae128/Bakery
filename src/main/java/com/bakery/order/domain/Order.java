package com.bakery.order.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Order {
	private int id;
	private int userId;
	private int productSellingPrice;
	private int deliveryPrice;
	private String address;
	private String phoneNumber;
	private String status;
	private Date createdAt;
	private Date updatedAt;
}
