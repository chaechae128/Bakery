<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center p-3">
	<div>
		<img src="${product.imagePath}" width="300px">
 	</div>
 	<div class="margin-40">
 		<h1 class="font-weight-bold display-3">${product.productName}</h1>
 		<div class="d-flex justify-content-center">
 			<h4 class="text-danger  mx-3">할인율</h4>
 			<h6 class="mx-3"><del>${product.costPrice}</del></h6>
 			<h2 class="font-weight-bold display-6 mx-3">${product.sellingPrice}원</h2>
 		</div>
 		
 		<%--수량 체크 --%>
 		<div class="my-3 d-flex justify-content-center">
	 		<button class="border-0"><img src="/static/image/minus.jpg" width="30px"></button>
	 		<input type="text" id="count" name="count">
	 		<button class="border-0"><img src="/static/image/plus.jpg" width="30px"></button>
 		</div>
 		
 		<div class="d-flex justify-content-center">
	 		<button class="bg-lemon border-0" id="buyBtn">구매하기</button>
 		</div>
 		
 		<div class="d-flex mt-3 justify-content-center"> 
 			<button class="bg-lemon border-0 mr-3" id="likeBtn">찜하기</button>
 			<button class="bg-lemon border-0 mr-3" id="cartBtn">장바구니</button>
 		</div>
 	</div>
</div>