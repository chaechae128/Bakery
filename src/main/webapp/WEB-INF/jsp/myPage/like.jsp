<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="d-flex">
	<!-- 메뉴 -->
	<div class="mx-3">
		<div class="m-3">
			<h3>나의 쇼핑 정보</h3>
			<div class="m-3"><a href="/order/my-order-list-view" class="font-gray">주문/배송내역</a></div>
			<div class="m-3"><a href="/like/like-list-view" class="font-gray">찜</a></div>
			<div class="m-3"><a href="/cart/cart-list-view" class="font-gray">장바구니</a></div>
		</div>
		
		<div class="m-3">
			<h3>나의 문의 글</h3>
			<div class="m-3"><a href="/inquiry/inquiry-list-view" class="font-gray">Q & A</a></div>
		</div>
		
		<div class="m-3">
			<h3>개인 정보</h3>
			<div class="m-3"><a href="/user/user-update-view" class="font-gray">회원 정보 수정</a></div>
		</div>
	</div>
	
	<div class="mx-3">
		<div class="margin-left"><h1>찜 목록</h1></div>
		<hr>
		<div class="d-flex justify-content-center">
			<c:set var="i" value="0" />
			<c:set var="j" value="5" />
			<table>
			  <c:forEach items="${productList}" var="product">
			    <c:if test="${i%j == 0 }">
			    <tr>
			    </c:if>
					<td class="p-3">
				    	<a href="/product/product-detail-view?productId=${product.id}">
				       		<div><img src="${product.imagePath}" alt="상품 사진" width="200px"></div>
							<div>${product.productName}</div>
							<div>${product.sellingPrice}</div>
						</a>
				     </td>
			    <c:if test="${i%j == j-1 }">
			    </tr>
			    </c:if>
			    <c:set var="i" value="${i+1 }" />
			  </c:forEach>
			</table>
		</div>
	</div>


</div>

