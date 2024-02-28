<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="d-flex">
	<!-- 메뉴 -->
	<div>
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

	<!-- 회원 정보 수정 -->
	<div class="margin-40">
		<h1>마이페이지</h1>
		<h4>회원 정보 수정</h4>
		<div class="bg-gray d-flex" id="updateUser">
			<div class="mx-3">
				<h5 class="ml-2 my-3 font-weight-bold">아이디</h5>
				<h5 class="ml-2 my-3 font-weight-bold">이름</h5>
				<h5 class="ml-2 my-3 font-weight-bold">이메일</h5>
				<h5 class="ml-2 my-3 font-weight-bold">전화번호</h5>
				<h5 class="ml-2 my-3 font-weight-bold">주소</h5>
			</div>
			
			<div class="mx-3">
				<h5 class="ml-2 my-3 ">기존 아이디</h5>
				<h5 class="ml-2 my-3 ">이름</h5>
				<h5 class="ml-2 my-3 ">기존 이메일</h5>
				<h5 class="ml-2 my-3 ">전화버호</h5>
				<h5 class="ml-2 my-3 ">기존주소</h5>
			</div>
		</div>
	</div>


</div>