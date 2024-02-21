<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="margin-left"><h1>장바구니 목록</h1></div>
<hr>
<div class="d-flex justify-content-center">
	<form action="/order/order-create-view" method="post">
		<table class="table text-center col-9">
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
					<c:forEach items="${productList}" var="product">
						<tr>
							<c:if test="${cart.productId eq product.id}">
								<td><label><input type="checkbox" checked class="choice" name="choice" value="${product.id}" id="${product.id}" data-product-price="${product.sellingPrice * cart.count}"></label></td>
								<td><a href="/product/product-detail-view?productId=${product.id}"><img src="${product.imagePath}" width="100px"></a></td>
								<td>${product.productName}</td>
								<td>${cart.count}</td>
								<td>${product.sellingPrice} * ${cart.count} = ${product.sellingPrice * cart.count}</td>
								<td><button class="btn bg-lemon deleteBtn" data-product-id="${product.id}">삭제</button></td>
							</c:if>
						</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
		
<div class="d-flex justify-content-center col-11">
	<button class="btn bg-lemon col-4 mb-3" id="orderBtn" >주문하기</button>
</div>
	</form>	
</div>

<!-- <div >
	<hr>
	<h2 class="display-4 margin-left">주문금액</h2>
	<hr>
	<div class="d-flex justify-content-around">
		<h3 class="display-6 ">상품금액: </h3>
		<h3 class="display-6 margin-left"><input class="text border-0" id="productPrice" value=""></h3>
	</div>
	<div class="d-flex justify-content-around">
		<h3 class="display-6 ">배송비: </h3>
		<h3 class="display-6 margin-left">3,000 원</h3>
	</div>
	<hr>
	<div class="justify-content-end">
		<h4 class="display-4 margin-left font-weight-bold">총 금액:</h4>
	</div>
</div> -->

<script>
	$(document).ready(function(){
		/*  $("#orderBtn").on('click', function(){
			 let productIdArray = [];
			 let product = $("input[name='choice']:checked");
			 $(product).each(function() {
				 productIdArray.push($(this).val());
			 });
			 //console.log(productIdArray); 
			 
			 $.ajax({
				type:"POST"
				,url:"/order/order-create-view"
				,data:{"productIdArray":productIdArray}
			 	,traditional: true
			 	,success:function() {
			 		location.href="/order/order-create-view";
			 		//location.href="/order/order-create-view?productIdArray"+productIdArray;
		         }
		        ,error:function(request, status, error){
		            	alert("주문서 작성으로 가지 못했습니다");
			 	}
			 });
			 
		});//choice */
		
		$(".deleteBtn").on('click', function(){
			let productId = $(this).data("product-id");
			//alert(productId);
			$.ajax({
				type:"DELETE"
				,url:"/cart/cart-out"
				,data: {"productId":productId}
				,success:function(data){
					if(data.code == 200){
						alert("삭제가 완료되었습니다");
						location.reload();
					} else {
						alert(data.error_message);
					}
				}
				,error:function(request, status, error){
					alert("삭제에 실패하였습니다");
				} 
			});
		});//deleteBtn
	
		
	});//document
</script>