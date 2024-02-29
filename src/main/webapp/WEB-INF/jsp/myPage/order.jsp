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
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>