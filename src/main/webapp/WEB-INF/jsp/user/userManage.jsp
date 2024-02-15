<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="d-flex justify-content-center">
	<div class="col-10">
		<div class="d-flex justify-content-between">
			<h2>회원관리</h2>
			<!--검색-->
			<div class="d-flex  align-items-center">
				<input type="text" class="d-flex justify-content-end search" id="user" name="user">
				<button id="userSearchBtn" class="btn"><img src="https://img.freepik.com/premium-vector/magnifying-glass-icon-vector-illustration_230920-960.jpg" alt="searchIcon" height="35px"></button>
				<a href="/user/user-manage-view" class="btn bg-lemon">전체 조회</a>
			</div>

		</div>
	</div>



</div>
<div class="w-100 mt-3">
	<table class="table text-center">
		<thead class="bg-lemon">
			<th>번호</th>
			<th>회원명</th>
			<th>아이디</th>
			<th>핸드폰번호</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>이메일</th>
			<th>가입일시</th>
		</thead>
		<tbody>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.loginId}</td>
					<td>${user.phoneNumber}</td>
					<td>${user.postCode}</td>
					<td>${user.address}</td>
					<td>${user.email}</td>
					<td>${user.createdAt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
	$(document).ready(function(){
		$("#userSearchBtn").on('click', function() {
			let userName = $("#user").val().trim();
			//alert(user);
			$.ajax({
				type:"GET"
				,url:"/user/searchUser"
				,data:{"userName":userName}		
				,success:function(data){
		         	location.href="/user/searchUser?userName="+userName;
		         }
		        ,error:function(request, status, error){
		            	alert("회원 조회 실패");
		        }
			});//ajax
			
			
		});//searchBtn
	});//document
</script>