<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="d-flex justify-content-center">주문서 작성</h1>
<div class="d-flex justify-content-center">
	<table class="table text-center col-9">
			<thead>
				<th>상품사진</th>
				<th>상품명</th>
				<th>수량</th>
				<th>상품 금액</th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach items="${cartList}" var="cart">
					<c:forEach items="${productList}" var="product">
						<tr>
							<c:if test="${cart.productId eq product.id}">
								<td><a href="/product/product-detail-view?productId=${product.id}"><img src="${product.imagePath}" width="100px"></a></td>
								<td>${product.productName}</td>
								<td>${cart.count}</td>
								<td>${product.sellingPrice} * ${cart.count} = ${product.sellingPrice * cart.count}</td>
							</c:if>
						</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
</div>