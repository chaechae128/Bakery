<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="d-flex justify-content-center p-3">
	<div>
		<img src="${product.imagePath}" width="300px">
 	</div>
 	<div class="margin-40">
 		<form action="/order/order-create-view" method="post">
 		<h1 class="font-weight-bold display-3">${product.productName}</h1>
 		<div class="d-flex justify-content-center">
 			<h4 class="text-danger  mx-3">할인율</h4>
 			<h6 class="mx-3"><del>${product.costPrice}</del></h6>
 			<h2 class="font-weight-bold display-6 mx-3">${product.sellingPrice}원</h2>
 		</div>
 		<input type="hidden" value="${product.id}" name="productId" id="productId">
 		<%--수량 체크 --%>
 		<div class="my-3 d-flex justify-content-center">
	 		<a href="#" class="btn border-0" id="minusBtn"><img src="/static/image/minus.jpg" width="30px"></a>
	 		<input type="text" id="count" name="count" value="1" class="text-center">
	 		<a href="#" class="btn border-0" id="plusBtn"><img src="/static/image/plus.jpg" width="30px"></a>
 		</div>
 		
 		<div class="d-flex justify-content-center">
	 		<button class="bg-lemon border-0" id="buyBtn">구매하기</button>
 		</div>
 		</form>	
 		<div class="d-flex mt-3 justify-content-center"> 
	 		<c:choose>
	 			<%--하트가 채워져 있을 때 --%>
				<c:when test="${isLike eq true}"> 
					<div class="d-flex justify-content-center"> 
						<button class="bg-lemon border-0 mr-3" id="dislikeBtn" data-product-id="${product.id}">찜하기  
			 			<img src="/static/image/heart-icon.png" width="20px">
	 					</button>
	 				</div>
				</c:when>
				<%--하트가 비워져 있을 때 --%>
				<c:otherwise>
					<div class="d-flex justify-content-center"> 
						<button class="bg-lemon border-0 mr-3" id="likeBtn" data-product-id="${product.id}">찜하기  
			 			<img src="/static/image/empty-heart-icon.png" width="20px">
	 					</button>
	 				</div>
				</c:otherwise>
			</c:choose>
			<button class="bg-lemon border-0 mr-3" id="cartBtn" data-product-id="${product.id}">장바구니</button>
 		</div>
		
 	</div>
</div>

<script>
	$(document).ready(function(){
		$("#minusBtn").on('click', function(){
			let count = $("#count").val();
			if(count != 0) {
				$("#count").attr('value', parseInt(count)-1);    	
			}
		});
		
		$("#plusBtn").on('click', function(){
			let count = $("#count").val();
			//console.log(parseInt(count) + 1);
			$("#count").attr('value', parseInt(count)+1);    
		});
		
		//찜하기
		$("#likeBtn").on('click', function(){
			let productId = $(this).data("product-id");
			//alert(productId);
			
			$.ajax({
				type:"GET"
				,url:"/like/like?productId=" + productId
				,data:{"productId":productId}
				,success:function(data){
					if(data.code == 200) {
						location.reload();
					} else {
						alert(data.error_message);
					}
				}
				,error:function(request, status, error){
					alert("찜하기에 실패했습니다");
				}
			});//ajax
			
		});//likeBtn
		
		$("#dislikeBtn").on('click', function(){
			let productId = $(this).data("product-id");
			//alert(productId);
			
			$.ajax({
				type:"GET"
				,url:"/like/dislike?productId=" + productId
				,data:{"productId":productId}
				,success:function(data){
					if(data.code == 200) {
						location.reload();
					} else {
						alert(data.error_message);
					}
				}
				,error:function(request, status, error){
					alert("찜하기에 실패했습니다");
				}
			});//ajax
			
		});//dislikeBtn
		
		$("#cartBtn").on('click', function(){
			let productId = $(this).data("product-id");
			let count =  $("#count").val();
			//alert(count);
			
			$.ajax({
				type:"POST"
				,url:"/cart/cart-in"
				,data:{"productId":productId, "count":count}
				,success:function(data){
					if(data.code == 200) {
						alert("장바구니에 상품이 담겼습니다");
						location.reload();
					} else {
						alert(data.error_message);
					}
				}
				,error:function(request, status, error){
					alert("장바구니에 담지 못했습니다");
				}
			});//ajax
			
		});//cartBtn
		
		$("#buyBtn").on('click', function(){
			
		});//buyBtn
		
	});//document

</script>