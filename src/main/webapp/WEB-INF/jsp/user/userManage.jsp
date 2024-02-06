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
				<input type="text" class="d-flex justify-content-end search" id="userSearch" name="userSearch">
				<button id="userSearchBtn" class="btn"><img src="https://img.freepik.com/premium-vector/magnifying-glass-icon-vector-illustration_230920-960.jpg" alt="searchIcon" height="35px"></button>
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
		$("#userSearchBtn").on('click', function(){
			//alert("클릭");
			let name = $("#userSearch").val();
			//console.log(name);
			
			if(!name){
				alert("검색할 회원을 입력해주세요");
				return false;
			}
			
			$.ajax({
				type:"POST"
				,url:"/user/searchUser"
				,data:{"name":name}
				,success:function(data){
					if(data.code == 200){
						location.reload();
					} else{
						alert(data.error_message);
					}
				}
				,error:function(request, status, error){
					alert("회원 검색에 실패하였습니다");
				}
			});//ajax
			
		});//userSearchBtn
	});//document
</script>