<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="d-flex">
	<!-- 메뉴 -->
	<jsp:include page="../include/myPageMenu.jsp" />

	<div class="margin-left">
		<table class="table text-center">
			<thead>
				<th>No.</th>
				<th>상품명</th>
				<th>주문금액</th>
				<th>주소</th>
				<th>진행현황</th>
				<th>주문일자</th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach items="${orderDetailList}" var="orderDetail" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td><c:forEach items="${orderDetail.productList}" var="product">
								<c:forEach items="${orderDetail.countList}" var="count">
									<div>${product.productName}  ${count}개</div>
								</c:forEach>
							</c:forEach></td>
						<td>${orderDetail.order.productSellingPrice + orderDetail.order.deliveryPrice}</td>
						<td>${orderDetail.order.address}</td>
						<td>${orderDetail.order.status}</td>
						<td><fmt:formatDate value="${orderDetail.order.createdAt}" pattern="yyyy년 M월 dd일" /></td>
						<td><button class="btn bg-lemon cancleBtn" data-order-id="${orderDetail.order.id}">주문취소</button>
							<input type="hidden" value="${orderDetail.order.status}" name="orderStatus" id="orderStatus">
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>

<script>
	$(document).ready(function(){
		$(".cancleBtn").on('click', function(){
			let orderId = $(this).data("order-id");
			//console.log(orderId);
			let status = $(this).next().val();
			//console.log(status);
			
			if(status == "배송 중" || status == "배송 완료") {
				alert("이미 배송이 진행된 상품으로 주문취소가 어렵습니다");
				return false;
			}
			
			if(status == "주문 취소") {
				alert("이미 취소된 주문 입니다.");
				return false;
			}
			
			$.ajax({
				type:"POST"
				,url:"/order/order-update-status"
				,data:{"orderId":orderId, "status":"주문 취소"}
				,success:function(data){
					if(data.code == 200) {
						alert("주문취소가 정상적으로 처리되었습니다");
						location.reload();
					} else {
						alert(data.error_message);
					}
				}
				,error:function(request, status, error) {
					alert("주문 취소에 실패했습니다. 관리자에게 문의하세요");
				}
			});//ajax
			
		});//cancleBtn
	});//document

</script>