package com.bakery.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bakery.cart.bo.CartBO;
import com.bakery.cart.domain.Cart;
import com.bakery.order.bo.OrderBO;
import com.bakery.order.bo.OrderProductBO;
import com.bakery.order.domain.Order;
import com.bakery.order.domain.OrderProduct;
import com.bakery.orderDetail.bo.OrderDetailBO;
import com.bakery.orderDetail.domain.OrderDetail;
import com.bakery.product.bo.ProductBO;
import com.bakery.product.entity.ProductEntity;
import com.bakery.user.bo.UserBO;
import com.bakery.user.domain.User;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private ProductBO productBO;

	@Autowired
	private CartBO cartBO;

	@Autowired
	private UserBO userBO;

	@Autowired
	private OrderBO orderBO;

	@Autowired
	private OrderProductBO orderProductBO;
	
	@Autowired
	private OrderDetailBO orderDetailBO;

	/**
	 * 장바구니에서 주문 하기 화면
	 * 
	 * @param choice
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/order-create-view")
	public String cartToOrderCreateView(@RequestParam(value = "choice", required = false) List<Integer> choice,
			@RequestParam(value = "count", required = false) Integer count,
			@RequestParam(value = "productId", required = false) Integer productId, Model model, HttpSession session) {
		int userId = (int) session.getAttribute("userId");
		User user = userBO.selectByUserId(userId);
		model.addAttribute("user", user);
		if (choice != null) {
			List<Cart> cartList = cartBO.selectCarListByUserId(userId);
			model.addAttribute("cartList", cartList);
			List<ProductEntity> productList = productBO.selectByOrder(choice);
			model.addAttribute("productList", productList);
			model.addAttribute("productCount", productList.size());

		} else {
			ProductEntity product = productBO.selectByProductId(productId);
			model.addAttribute("product", product);
			model.addAttribute("count", count);
			model.addAttribute("productCount", 1);

		}

		model.addAttribute("viewName", "/order/createOrder");
		// model.addAttribute("viewName", "/order/testOrder");

		return "template/bakeryLayout";
	}

	/**
	 * 결제 성공 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/order-complete-view")
	public String orderCompleteView(Model model) {
		model.addAttribute("viewName", "/order/completeOrder");
		return "template/bakeryLayout";
	}

	/**
	 * 주문 관리 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/order-manage-view")
	public String orderManageView(Model model) {
		List<Order> orderList = orderBO.selectOrder();
		model.addAttribute("viewName", "/order/orderManage");
		model.addAttribute("orderList", orderList);
		return "template/managerLayout";
	}

	/**
	 * 관리자 - 주문 상세 관리
	 * 
	 * @param orderId
	 * @param model
	 * @return
	 */
	@GetMapping("/order-detail-view")
	public String orderDetailView(@RequestParam("orderId") int orderId, Model model) {
		List<OrderProduct> orderProductList = orderProductBO.selectOrderProductById(orderId);
		List<Integer> productIdList = new ArrayList<>();
		for (int i = 0; i < orderProductList.size(); i++) {
			productIdList.add(orderProductList.get(i).getProductId());
		}
		model.addAttribute("orderProductList", orderProductList);

		List<ProductEntity> productList = productBO.selectProductList(productIdList);
		model.addAttribute("productList", productList);
		model.addAttribute("listSize", orderProductList.size());

		model.addAttribute("viewName", "/order/orderDetail");
		return "template/bakeryLayout";
	}

	@RequestMapping("/my-order-list-view")
	public String myOrderListView(Model model, HttpSession session) {
		int userId = (int) session.getAttribute("userId");
		List<OrderDetail> orderDetailList = orderDetailBO.selectOrderDetailByUserId(userId);
		model.addAttribute("orderDetailList", orderDetailList);
		model.addAttribute("viewName", "/myPage/order");
		model.addAttribute("userId", userId);
		return "template/bakeryLayout";
	}

}
