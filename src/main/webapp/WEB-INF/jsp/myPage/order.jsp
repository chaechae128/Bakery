<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div class="d-flex">
	<!-- 메뉴 -->
	<div>
		<div class="m-3">
			<h3>나의 쇼핑 정보</h3>
			<div class="m-3"><a href="/order/my-order-list-view" class="font-gray">주문/배송내역</a></div>
			<div class="m-3"><a href="/like/like-list-view" class="font-gray">찜</a></div>
			<div class="m-3"><a href="/cart/cart-list-view" class="font-gray">장바구니</a></div>
		</div>
		
		<div class="m-3">
			<h3>나의 문의 글</h3>
			<div class="m-3"><a href="/inquiry/inquiry-list-view" class="font-gray">Q & A</a></div>
		</div>
		
		<div class="m-3">
			<h3>개인 정보</h3>
			<div class="m-3"><a href="/user/user-update-view" class="font-gray">회원 정보 수정</a></div>
		</div>
	</div>
		
	<div class="ml-3">
		<table class="table text-center">
			<thead>
				<th>No.</th>
				<th>상품명</th>
				<th>주문일자</th>
				<th>주문금액</th>
				<th>진행현황</th>
			</thead>
			<tbody>
				<c:forEach items="${orderList}" var="order" varStatus="status">
					<c:forEach items="${orderProductList}" var="orderProduct">
						<tr>
							<c:if test="${orderProduct.orderId eq order.id}">
								<td>${status.count}</td>
								<td></td>
								<td>${order.createdAt}</td>
								<td>${order.productSellingPrice}</td>
								<td>${order.status}</td>
							</c:if>
						</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</div>