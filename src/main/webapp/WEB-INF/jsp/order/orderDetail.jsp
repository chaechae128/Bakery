<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="d-flex justify-content-center">
	<div class="col-10">
		<div class="d-flex justify-content-between">
			<h2>주문관리</h2>
			<!--검색-->
			<div class="d-flex  align-items-center">
				<input type="text" class="d-flex justify-content-end search"
					id="order" name="order">
				<button id="orderSearchBtn" class="btn">
					<img
						src="https://img.freepik.com/premium-vector/magnifying-glass-icon-vector-illustration_230920-960.jpg"
						alt="searchIcon" height="35px">
				</button>
				<a href="/order/order-manage-view" class="btn bg-lemon">전체 조회</a>
			</div>

		</div>
	</div>



</div>
<div class="w-100 mt-3">
	<table class="table text-center">
		<thead class="bg-lemon">
			<th>주문 번호</th>
			<th>상품 번호</th>
			<th>개수</th>
			<th>주문일시</th>
		</thead>
		<tbody>
			<c:forEach items="${orderProductList}" var="orderProduct">
				<c:forEach items="${productList}" var="product">
					<c:if test="${orderProduct.productId eq product.id}">
						<tr>
							<td>${orderProduct.orderId}</td>
							<td>${product.productName}</td>
							<td>${orderProduct.count}</td>
							<td>${orderProduct.createdAt}</td>
						</tr>
					</c:if>
				</c:forEach>
			</c:forEach>

		</tbody>
	</table>
</div>