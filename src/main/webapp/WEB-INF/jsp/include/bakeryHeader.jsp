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
		<button id="Allbtn" class="btn mx-1" value="All">전체</button>
		<button id="Bestbtn" class="btn mx-1">베스트</button>
		<button id="Newbtn" class="btn mx-1">NEW</button>
		<button id="Cakebtn" class="btn mx-1">케이크</button>
		<button id="Cookiebtn" class="btn mx-1">쿠키</button>
		<button id="Breadbtn" class="btn mx-1">빵</button>
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

<script>
	$(document).ready(function(){
		$("#Allbtn").on('click', function(){
			let menu=$(this).val();
			//console.log(value);
			
			$.ajax({
				type:"GET"
				,url:"/product/product-list"
				,data:{"menu":menu}		
				,success:function(data){
		               if(data.code == 200){
		                  location.href="/product/product-"+data.menu+"-list";
		               }else{
		            	   alert(data.error_message);
		               }
		            }
		            ,error:function(request, status, error){
		            	alert("목록 조회 실패");
		            }
			});//ajax
			
		});//Allbtn
	});//ready
</script>