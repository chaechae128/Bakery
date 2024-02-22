<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="d-flex justify-content-center">주문서 작성</h1>
<div class="d-flex margin-left my-3">
	<table class="table text-center" data-count="${productCount}" id="table">
			<thead>
				<th></th>
				<th>상품사진</th>
				<th>상품명</th>
				<th>수량</th>
				<th>상품 금액</th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach items="${cartList}" var="cart">
					<c:forEach items="${productList}" var="product" varStatus="status">
						<tr>
							<c:if test="${cart.productId eq product.id}">
								<td>${status.count}</td>
								<td><a href="/product/product-detail-view?productId=${product.id}"><img src="${product.imagePath}" width="100px"></a></td>
								<td>${product.productName}</td>
								<td>${cart.count}</td>
								<td id="${status.count}" class="price" data-product-price="${product.sellingPrice * cart.count}" data-product-id="${product.id}">${product.sellingPrice} * ${cart.count} = ${product.sellingPrice * cart.count}</td>
							</c:if>
						</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
</div>
<div class="d-flex justify-content-around col-8 margin-left my-3">
	<div class="col-4">
		<h3 class="d-flex justify-content-center">주문하는 분</h3>
		<div class="d-flex">
					<table class="text-center table">
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
	</div>
	<div  class="col-4">
		<div class="d-flex justify-content-center align-items-center"> 
		<h3 class="mr-4">결제 수단</h3>
		<input type='radio' name='payOption' value='card' class="ml-4 mr-2"/><span>카드</span>
	    <input type='radio' name='payOption' value='deposit' class="mr-2"/><span>무통장입금</span> 
</div>
	</div>
</div>
<hr>
<div class="d-flex margin-left justify-content-center col-3 my-3">
	<h3 class="">받으시는 분</h3>
	<div class="d-flex ml-3">
		 <span class="mr-3">내 주소로</span><input type="checkbox" id="my" class="my" name="my" data-user-name="${user.name}" data-user-phone-number="${user.phoneNumber}" data-user-address="${user.address}">
	</div>
</div>
<div class="d-flex justify-content-center margin-left">
			<table class="text-center col-5 table">
				<tr>
					<th>받는사람 : </th>
					<td><input type="text" class="border-0" id="taker"></td>
				</tr>
				<tr>
					<th>휴대폰 번호 : </th>
					<td><input type="text" class="border-0" id="phoneNumber"></td>
				</tr>
				<tr>
					<th>주소 : </th>
					<td><input type="text" class="border-0" id="address"></td>
				</tr>
			</table>
			
			<div class="col-6 "> 
			
				<h3 class="font-weight-bold">주문 상품 금액 : <input type="number" class="border-0" id="ProductPrice"></h3>
				<h3 class="font-weight-bold">배달비 :  <input type="number" class="border-0" id="deliveryPrice"></h3>
				<h3 class="font-weight-bold">총 결제 금액 : <input type="number" class="border-0" id="totalPrice"></h3>
			</div>
</div>


<script>
	$(document).ready(function(){
		$("#my").on('change', function(){
			//alert("클릭");
			let chk = $("input[type=checkbox]");
			if(chk.is(":checked")) {
				$("#taker").attr("value", $(this).data("user-name"));
				$("#phoneNumber").attr("value", $(this).data("user-phone-number"));
				$("#address").attr("value", $(this).data("user-address"));
				//console.log( $(this).data("user-number"));
			} else {
				$("#taker").attr("value", "");
				$("#phoneNumber").attr("value", "");
				$("#address").attr("value","");
			}
			
		});
		
		let id = "";
		let ProductPrice = 0;
		//상품 개수
		let count = $("#table").data("count");
		for(let i = 1; i<=count; i++) {
			let price = parseInt($("#"+i).data("product-price"));
			ProductPrice += price;
			//console.log(totalPrice);
		}
		$("#ProductPrice").attr("value", ProductPrice);
		
		if(ProductPrice >= 100000) {
			$("#deliveryPrice").attr("value", 0);
		} else{
			$("#deliveryPrice").attr("value", 3000);
		}
		
		$("#totalPrice").attr("value",  parseInt(ProductPrice)+ parseInt($("#deliveryPrice").val()));
		
	});//document
</script>
