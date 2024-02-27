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
				<input type="text" class="d-flex justify-content-end search" id="order" name="order">
				<button id="orderSearchBtn" class="btn"><img src="https://img.freepik.com/premium-vector/magnifying-glass-icon-vector-illustration_230920-960.jpg" alt="searchIcon" height="35px"></button>
				<a href="/order/order-manage-view" class="btn bg-lemon">전체 조회</a>
			</div>

		</div>
	</div>



</div>
<div class="w-100 mt-3">
	<table class="table text-center" data-list-size="${listSize}">
		<thead class="bg-lemon">
			<th>번호</th>
			<th>회원 아이디</th>
			<th>상품 가격</th>
			<th>배달비</th>
			<th>주소</th>
			<th>휴대폰번호</th>
			<th>배송상태</th>
			<th>주문일시</th>
		</thead>
		<tbody>
			<c:forEach items="${orderList}" var="order">
					<tr>
						<td><a href="/order/order-detail-view?orderId=${order.id}">${order.id}</a></td>
						<td>${order.userId}</td>
						<td>${order.productSellingPrice}</td>
						<td>${order.deliveryPrice}</td>
						<td>${order.address}</td>
						<td>${order.phoneNumber}</td>
						<td> 
							<select id="status${order.id}">
					            <option>${order.status}</option>
					            <option>상품 준비</option>
					            <option>배송 중</option>
					            <option>배송 완료</option>
					        </select>
					        <button class="btn updateOrderBtn bg-lemon" id="${order.id}">수정</button>
					        <input type="hidden" value="${order.id}" name="orderId" id="orderId">
					     </td>
						<td>${order.createdAt}</td>
					</tr>
				
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
	$(document).ready(function(){
		/* let listSize = $("#table").data("list-size");
		for(let i = 1; i<=listSize; i++) {
			$("#updateOrderBtn"+i).on('click', function(){
				let orderStatus =  $("#status"+i).val();
				alert(orderStatus);
				});//searchBtn	
			
		} */
		
		$(".updateOrderBtn").on('click', function(){
			var orderId = parseInt($(this).next().val());
			console.log(orderId);
			var status = $("#status"+orderId).val();
			console.log(status);
			
			$.ajax({
				type:"POST"
				,url:"/order/order-update-status"
				,data:{"orderId":orderId, "status":status}
				,success:function(data) {
					if(data.code == 200) {
						alert("주문 상태 수정이 완료되었습니다");
						href.reload();
					} else {
						alert(data.error_message);
					}
				}
				,error:function(request, status, error) {
					alert("수정에 실패했습니다");
				}
			});//ajax
		})
			
		
	});//document
</script> 