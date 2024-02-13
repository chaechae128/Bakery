<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="w-100">
	<div class="d-flex justify-content-center">
		<h2 class="font-weight-bold display-4">로그인</h2>
	</div>
	<div class="d-flex justify-content-center">
		<form id="loginForm" action="/user/sign-in" method="post" class="mt-3">
			<div>아이디</div> 
			<input type="text" id="loginId" name="loginId" class="form-control"> 
			<div>비밀번호</div> 
			<input type="password" id="password" name="password" class="form-control">
			<div class="d-flex justify-content-center">
				<button class="btn bg-lemon my-4 w-100" id="loginBtn">로그인</button>
			</div>
			<div class="d-flex">
				<a href="/user/sign-up-view" class="ml-2">회원가입</a> 
				<a href="/user/find-id-view" class="ml-2">아이디 찾기</a> 
				<a href="/user/find-password-view" class="ml-2">비밀번호 찾기</a> 
			</div>
		</form>
	</div>
</div>

<script>
	$(document).ready(function(){
		$("#loginBtn").on('click', function(e){
			e.preventDefault();
			//alert("로그인");
			
			//validation
			let loginId = $("#loginId").val();
			let password = $("#password").val();
			
			if(!loginId){
				alert("아이디를 입력하세요");
				return false;
			}
			if(!password){
				alert("비밀번호를 입력하세요");
				return false;
			}
			
			$.ajax({
				type:"POST"
				,url:"/user/sign-in"
				,data:{"loginId":loginId, "password":password}
				,success:function(data){
					if(data.code == 200) {
						location.href="/bakery/home-view";
					}else{
						alert(data.error_message);
					}
				}
				,error:function(request, status, error){
					alert("로그인에 실패했습니다");
				}
			});//ajax
			
			
		});//loginBtn
	});//document
</script>





