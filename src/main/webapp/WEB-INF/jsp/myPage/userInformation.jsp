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
			<div class="mx-3 col-4">
				<h5 class="ml-2 my-3 font-weight-bold">아이디</h5>
				<h5 class="ml-2 my-3 font-weight-bold">이름</h5>
				<h5 class="ml-2 my-3 font-weight-bold">이메일</h5>
				<h5 class="ml-2 my-3 font-weight-bold">전화번호</h5>
				<h5 class="ml-2 my-3 font-weight-bold">주소</h5>
			</div>
			
			<div class="mx-3 col-5">
				<h5 class="ml-2 my-3">${user.loginId}</h5>
				<h5 class="ml-2 my-3">${user.name}</h5>
				<h5 class="ml-2 my-3" id="email">${user.email}</h5><input type="text" class="d-none ml-2 my-1" id="upEmail">
				<h5 class="ml-2 my-3" id="phoneNumber">${user.phoneNumber}</h5><input type="text" class="d-none ml-2 my-1" id="upNumber">
				<h5 class="ml-2 my-3" id="address">${user.address}</h5><input type="text" class="d-none ml-2 my-1" id="upAddress">
			</div>
		</div>
		
		<div class="d-flex justify-content-center">
			<button id="updateUserBtn" class="bg-lemon m-4 border-0 p-2" >회원 정보 수정</button>
			<button id="signOutBtn" class="bg-lemon m-4 border-0 p-2">회원 탈퇴 </button>
			<button id="updateOkBtn" class="bg-lemon m-4 border-0 p-2 d-none">수정 완료</button>
		</div>
	</div>

</div>


<script>
	$(document).ready(function(){
		$("#updateUserBtn").on('click', function(){
			$("#email").addClass("d-none");
			$("#upEmail").removeClass("d-none");
			
			$("#phoneNumber").addClass("d-none");
			$("#upNumber").removeClass("d-none");
			
			$("#address").addClass("d-none");
			$("#upAddress").removeClass("d-none");
			
			$("#updateUserBtn").addClass("d-none");
			$("#updateOkBtn").removeClass("d-none");
			
		});//updateUserBtn
		
		$("#updateOkBtn").on('click', function() {
			let upEmail = $("#upEmail").val();
			let upNumber = $("#upNumber").val();
			let upAddress = $("#upAddress").val();
			
			//alert(upEmail);
			
			if(!upEmail) {
				alert("수정할 이메일을 입력하세요");
				return false;
			}
			
			if(!upNumber) {
				alert("수정할 이메일을 입력하세요");
				return false;
			}
			
			if(!upNumber) {
				alert("수정할 이메일을 입력하세요");
				return false;
			}
			
			$.ajax({
				type:"POST"
				,url:"/user/update"
				,data:{"upEmail":upEmail, "upNumber":upNumber, "upAddress":upAddress}
				,success:function(data) {
					if(data.code == 200) {
						alert("회원정보가 수정되었습니다");
						location.reload();
					} else {
						alert(data.error_message);
					}
				}
				,error:function(request, status, error) {
					alert("회원 정보 수정에 실패했습니다");
				}
			});
			
		});//updateOkBtn
		
	});
</script>