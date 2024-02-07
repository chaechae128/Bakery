<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<div class="d-flex justify-content-center align-items-end logo">
	<a href="/bakery/home-view" class="font-weight-bold" id="logo">Bakery</a>
</div>
<div class="p-2 d-flex justify-content-end">
	<!-- 로그인 시 -->
	<c:if test="${!empty userName}">
		<div class="ml-2">${userName}님 환영합니다~</div>
		<a href="/user/sign-out" class="ml-2">로그아웃</a>
		<a href="/cart/cart-list-view" class="ml-2">장바구니</a>
		<a href="/user/user-update-view" class="ml-2">마이페이지</a>
	</c:if>
	<!-- 로그인 아닐 경우  -->
	<c:if test="${empty userName}">
		<a href="/user/sign-up-view" class="ml-2">회원가입</a> 
		<a href="/user/sign-in-view" class="ml-2">로그인</a>
	</c:if>
</div>
<hr>
<!-- 상단 bar-->
<div class="d-flex justify-content-center" id="menu">
	<!--메뉴-->
	<div class="col-9 d-flex justify-content-around ">
		<a href="/product/product-all-list-view" class="btn mx-1">전체</a> <a
			href="/product/product-best-list-view" class="btn mx-1">베스트</a> <a
			href="/product/product-new-list-view" class="btn mx-1">NEW</a> <a
			href="/product/product-cake-list-view" class="btn mx-1">케이크</a> <a
			href="/product/product-cookie-list-view" class="btn mx-1">쿠키</a> <a
			href="/product/product-bread-list-view" class="btn mx-1">빵</a>
	</div>
	<!--검색-->
	<div class="d-flex  align-items-center">
		<input type="text" class="d-flex justify-content-end search">
		<a href=""><img
			src="https://img.freepik.com/premium-vector/magnifying-glass-icon-vector-illustration_230920-960.jpg"
			alt="searchIcon" height="35px"></a>
	</div>
</div>
<hr>