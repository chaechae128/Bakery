<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
		<div class="m-3">
			<h3>나의 쇼핑 정보</h3>
			<div class="m-3">
				<a href="/order/my-order-list-view" class="font-gray">주문/배송내역</a>
			</div>
			<div class="m-3">
				<a href="/like/like-list-view" class="font-gray">찜</a>
			</div>
			<div class="m-3">
				<a href="/cart/cart-list-view" class="font-gray">장바구니</a>
			</div>
		</div>

		<div class="m-3">
			<h3>나의 문의 글</h3>
			<div class="m-3">
				<a href="/inquiry/inquiry-list-view" class="font-gray">Q & A</a>
			</div>
		</div>

		<div class="m-3">
			<h3>개인 정보</h3>
			<div class="m-3">
				<a href="/user/myPage?userId=${userId}" class="font-gray">회원 정보 수정</a>
			</div>
		</div>
	</div>