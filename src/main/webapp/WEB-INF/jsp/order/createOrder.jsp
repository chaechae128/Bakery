<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="d-flex justify-content-center">주문서 작성</h1>
<div class="d-flex margin-left my-3 col-10">
	<table class="table text-center" data-count="${productCount}" id="table" data-user-name="${user.name}" data-cart-list="${cartList}">
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
<div class="d-flex justify-content-start  margin-left my-3">
	<div class="col-5">
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
	<div class="col-5">
		<div class="d-flex justify-content-center">
			<h3 class="d-flex justify-content-center">받으시는 분</h3>
			<div class="d-flex ml-3">
				 <span class="mr-3">내 주소로</span><input type="checkbox" id="my" class="my" name="my" data-user-name="${user.name}" data-user-phone-number="${user.phoneNumber}" data-user-address="${user.address}">
			</div>
		</div>
		<div>
		<table class="text-center table">
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
		</div>
	</div>
</div>
<hr>

<div class="d-flex justify-content-center margin-left">
	<div class="col-6 "> 
		<h3 class="font-weight-bold">주문 상품 금액 : <input type="number" class="border-0" id=productPrice"></h3>
		<h3 class="font-weight-bold">배달비 :  <input type="number" class="border-0" id="deliveryPrice"></h3>
		<h3 class="font-weight-bold">총 결제 금액 : <input type="number" class="border-0" id="totalPrice"></h3>
		<button class="btn bg-lemon my-4" id="payBtn">결제하기</button>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript"	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
		<!-- <script src="/main.js"></script> -->
	</div>
</div>


<script>
	$(document).ready(function(){
		
		//총 상품 
		let id = "";
		let productPrice = 0;
		//상품 개수
		let count = $("#table").data("count");
		for(let i = 1; i<=count; i++) {
			let price = parseInt($("#"+i).data("product-price"));
			productPrice += price;
			//console.log(totalPrice);
		}
		$("#productPrice").attr("value", productPrice);
		
		if(productPrice >= 100000) {
			$("#deliveryPrice").attr("value", 0);
		} else{
			$("#deliveryPrice").attr("value", 3000);
		}
		
		$("#totalPrice").attr("value",  parseInt(productPrice)+ parseInt($("#deliveryPrice").val()));
		
		//내 주소로
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
		
		
		
		//결제
		var amount = parseInt($("#totalPrice").val());
		var userName = $("#table").data("user-name");

		var IMP = window.IMP;
		IMP.init("imp66851474");
		$('#payBtn').on('click',function() {
			
			//validation
			let taker = $("#taker").val();
			let phoneNumber = $("#phoneNumber").val();
			let address = $("#address").val();
			let cartList = $("#table").data("cart-list");
			let productPrice = $("#productPrice").val();
			let deliveryPrice = $("#deliveryPrice").val();
			
			if(!taker){
				alert("받는사람을 입력하세요");
				return false;
			}
			if(!phoneNumber){
				alert("전화번호를 입력하세요");
				return false;
			}
			if(!address){
				alert("주소를 입력하세요");
				return false;
			}
			
			
			IMP.request_pay({
				pg: 'html5_inicis',
				pay_method: 'card',
				merchant_uid: 'merchant_' + new Date().getTime(),
				name: '베이커리',
				amount: amount,
				buyer_email: "",  /*필수 항목이라 "" 로 남겨둠*/
				buyer_name: userName,
			}, function(rsp) {
				console.log(rsp);
				
				 //결제 성공 시
				if (rsp.success) {
					var msg = '결제가 완료되었습니다.';
					console.log("결제성공 ");

					$.ajax({
						type: "POST",
						url: '/order/create',
						data: {
							"userName": userName,
							"productPrice":productPrice,
							"deliveryPrice":deliveryPrice,
							"address":address,
							"phoneNumber":phoneNumber,
							"cartList":cartList
						}
					});
				} else {
					var msg = '결제에 실패하였습니다.';
					msg += '에러내용 : ' + rsp.error_msg;
				}
				alert(msg);
			});
		}); 
		
		
	});//document
</script>
