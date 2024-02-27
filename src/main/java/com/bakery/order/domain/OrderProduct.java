package com.bakery.order.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class OrderProduct {
	private int orderId;
	private int productId;
	private int count;
	private Date createdAt;
}
