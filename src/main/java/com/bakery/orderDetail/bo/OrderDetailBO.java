package com.bakery.orderDetail.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakery.order.bo.OrderBO;
import com.bakery.order.bo.OrderProductBO;
import com.bakery.order.domain.Order;
import com.bakery.order.domain.OrderProduct;
import com.bakery.orderDetail.domain.OrderDetail;
import com.bakery.product.bo.ProductBO;
import com.bakery.product.entity.ProductEntity;

@Service
public class OrderDetailBO {
	@Autowired
	private OrderBO orderBO;
	
	@Autowired
	private OrderProductBO orderProductBO;
	
	@Autowired
	private ProductBO productBO;
	
	public List<OrderDetail> selectOrderDetailByUserId(int userId) {
		List<OrderDetail> orderDetailList = new ArrayList<>();
		
		List<Order> orderList = orderBO.selectOrderByUserId(userId);
		
		for(int i = 0; i < orderList.size(); i++) {
			OrderDetail orderDetail = new OrderDetail();
			
			//주문번호 가져오기
			int orderId = orderList.get(i).getId();
			
			//가져온 주문번호로 orderProduct에서 List<orderProduct> 가져오기
			List<OrderProduct> orderProductList = orderProductBO.selectOrderProductById(orderId);
			
			//가져온 orderProductList에서 productId로 List<ProductEntity> 만들기
			List<ProductEntity> productList = new ArrayList<>();
			List<Integer> countList = new ArrayList<>();
			for (int j = 0; j < orderProductList.size(); j++) {
				ProductEntity product = productBO.selectByProductId(orderProductList.get(j).getProductId());
				productList.add(product);
				countList.add(orderProductList.get(j).getCount());
			}
			
			orderDetail.setProductList(productList);
			orderDetail.setOrder(orderList.get(i));;
			orderDetail.setCountList(countList);
			
			orderDetailList.add(orderDetail);
			
		}
		
		return orderDetailList;
	}
}
