package com.bakery.orderDetail.domain;

import java.util.List;

import com.bakery.order.domain.Order;
import com.bakery.order.domain.OrderProduct;
import com.bakery.product.entity.ProductEntity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderDetail {
	private Order order;
	
	private List<ProductEntity> productList;
	
	private List<Integer> countList;
	
	
}
