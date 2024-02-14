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
		<button id="Dessertbtn" class="btn mx-1">디저트</button>
		<button id="Breadbtn" class="btn mx-1">빵</button>
	</div>
	<!--검색-->
	<div class="d-flex  align-items-center">
		<input type="text" class="d-flex justify-content-end search" id="search" name="search">
		<button id="searchBtn" width="30px"><img
			src="https://img.freepik.com/premium-vector/magnifying-glass-icon-vector-illustration_230920-960.jpg"
			alt="searchIcon" height="30px"></button>
	</div>
</div>
<hr>

<script>
	$(document).ready(function(){
		$("#Allbtn").on('click', function(){
			
			$.ajax({
				type:"GET"
				,url:"/product/product-list"
				,data:{"menu":"All"}		
				,success:function(data){
		         	location.href="/product/product-list?menu=All";
		         }
		        ,error:function(request, status, error){
		            	alert("목록 조회 실패");
		        }
			});//ajax
		});//Allbtn
		
		$("#Bestbtn").on('click', function(){
			$.ajax({
				type:"GET"
				,url:"/product/product-list"
				,data:{"menu":"Best"}		
				,success:function(data){
		         	location.href="/product/product-list?menu=Best";
		         }
		        ,error:function(request, status, error){
		            	alert("목록 조회 실패");
		        }
			});//ajax
		});//Bestbtn
		
		$("#Newbtn").on('click', function(){
			$.ajax({
				type:"GET"
				,url:"/product/product-list"
				,data:{"menu":"New"}		
				,success:function(data){
		         	location.href="/product/product-list?menu=New";
		         }
		        ,error:function(request, status, error){
		            	alert("목록 조회 실패");
		        }
			});//ajax
		});//Newbtn
		
		$("#Cakebtn").on('click', function(){
			$.ajax({
				type:"GET"
				,url:"/product/product-list"
				,data:{"menu":"Cake"}		
				,success:function(data){
		         	location.href="/product/product-list?menu=Cake";
		         }
		        ,error:function(request, status, error){
		            	alert("목록 조회 실패");
		        }
			});//ajax
		});//Cakebtn
		
		$("#Dessertbtn").on('click', function(){
			$.ajax({
				type:"GET"
				,url:"/product/product-list"
				,data:{"menu":"Dessert"}		
				,success:function(data){
		         	location.href="/product/product-list?menu=Dessert";
		         }
		        ,error:function(request, status, error){
		            	alert("목록 조회 실패");
		        }
			});//ajax
		});//Dessertbtn
		
		$("#Breadbtn").on('click', function(){
			$.ajax({
				type:"GET"
				,url:"/product/product-list"
				,data:{"menu":"Bread"}		
				,success:function(data){
		         	location.href="/product/product-list?menu=Bread";
		         }
		        ,error:function(request, status, error){
		            	alert("목록 조회 실패");
		        }
			});//ajax
		});//Breadbtn
		
		$("#searchBtn").on('click', function() {
			let search = $("#search").val().trim();
			//alert(search);
			$.ajax({
				type:"GET"
				,url:"/product/product-list"
				,data:{"search":search}		
				,success:function(data){
		         	location.href="/product/product-list?menu=search";
		         }
		        ,error:function(request, status, error){
		            	alert("목록 조회 실패");
		        }
			});//ajax
			
			
		});//searchBtn
	});//ready
</script>