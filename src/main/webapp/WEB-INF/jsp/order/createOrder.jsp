<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="d-flex justify-content-center">주문서 작성</h1>
<div class="d-flex justify-content-center col-9">
	<table class="table text-center col-8">
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
								<td id="price${product.id}" class="price" data-product-price="${product.sellingPrice * cart.count}" data-product-id="${product.id}">${product.sellingPrice} * ${cart.count} = ${product.sellingPrice * cart.count}</td>
							</c:if>
						</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
</div>
<h3 class="d-flex justify-content-center col-6">주문하는 분</h3>
<div class="d-flex justify-content-center col-6">
			<table class="text-center col-6 table">
				<tr>
					<th>이름</th>
					<td>${user.name}</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>${user.phoneNumber}</td>
				</tr>
			</table>
</div>

<div class="d-flex justify-content-center col-6">
	<h3 class="mr-3">받으시는 분</h3>
	<div class="d-flex ml-3">
		 <span class="mr-3">내 주소로</span><input type="checkbox" class="my" name="my">
	</div>
</div>
<div class="d-flex justify-content-center col-6">
			<table class="text-center col-6 table">
				<tr>
					<th>받는사람</th>
					<td><input type="text" class="border-0"></td>
				</tr>
				<tr>
					<th>휴대폰 번호</th>
					<td><input type="text" class="border-0"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" class="border-0"></td>
				</tr>
				<tr>
					<th>주문시 요청사항</th>
					<td><input type="text" class="border-0"></td>
				</tr>
				
			</table>
</div>

<div class="d-flex justify-content-center col-6"> 
	<h3>결제 수단</h3>
</div>
<div class="d-flex justify-content-center col-6"> 
	
</div>

<div class="d-flex justify-content-center col-6"> 
	<h3 class="font-weight-bold">총 결제 금액 : </h3>
</div>

<script>
	$(document).ready(function(){
		let productId = $(".price").data("product-id");
		let price = $("#price"+productId).data("product-price");
		console.log(price);
	});//document
</script>
