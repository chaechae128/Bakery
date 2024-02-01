<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="d-flex justify-content-center align-items-end logo">
	<h1 class="font-weight-bold" id="logo">Bakery</h1>
</div>
<div class="p-2 d-flex justify-content-end">
	<div class="ml-2">김채연님 환영합니다~</div>
	<a href="/user/sign-up-view" class="ml-2">회원가입</a> <a
		href="/user/sign-in-view" class="ml-2">로그인</a>
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