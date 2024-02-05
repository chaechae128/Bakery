<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
            <div id="signIn" class="col-5">
                <h2>회원가입</h2>
                <form id="loginForm" action="/user/sign-up" method="post">
                    <!--아이디-->
                    <div class="my-2">
                        <div class="mb-2">아이디</div>
                        <div class="d-flex">
                            <input class="form-control mb-2 col-5 mr-3" type="text" id="loginId" name="loginId" placeholder="아이디를 입력하세요">
                            <button class="duplicate-btn btn btn-secondary mb-2">중복확인</button>
                        </div>
                    </div>

                    <!--아이디 체크 결과-->
                    <div class="my-1">
                        <div id="idCheckLength" class="text-danger d-none ">ID를 4자 이상 입력해주세요</div>
                        <div id="idCheckDuplicated" class="text-danger d-none">중복된 아이디 입니다</div>
                        <div id="idCheckOk" class="text-success d-none">사용가능한 아이디 입니다</div>
                    </div>

                    <!--PW-->
                    <div class="my-2">
                        <div class="mb-2">비밀번호</div>
                        <input class="form-control mb-2 col-5 " type="password" id="password" name="password" placeholder="(8자이상)">
                    </div>

                    <div class="my-2">
                        <div class="mb-2">비밀번호 확인</div>
                        <input class="form-control mb-2 col-5" type="password" id="confirmPassword" name="confirmPassword">
                    </div>

                    <div class="my-2">
                        <div class="mb-2">이름</div>
                        <input class="form-control mb-2 col-5" type="text" id="name" name="name">
                    </div>

                    <div class="my-2">
                        <div class="mb-2">이메일</div>
                        <input class="form-control mb-2 col-5" type="text" id="email" name="email">
                    </div>

                    <div class="my-2">
                        <div class="mb-2">전화번호</div>
                        <input class="form-control mb-2 col-5" type="text" id="phoneNumber" name="phoneNumber">
                    </div>

                    <div class="my-2">
                        <div class="mb-2">우편번호</div>
                        <input class="form-control mb-2 col-5" type="text" id="postCode" name="postCode">
                    </div>

                    <div class="my-2">
                        <div class="mb-2">상세주소</div>
                        <input class="form-control mb-2 col-5" type="text" id="address" name="address">
                    </div>
                    <div class="d-flex justify-content-center mb-3 col-4">
                        <input type="submit" id="signUpBtn" class="btn bg-lemon mt-4" value="가입하기">
                    </div>

                </form>
            </div>
        </div>
<script>
	$(document).ready(function(){
		$(".duplicate-btn").on('click', function(e){
			e.preventDefault();
			//alert("중복확인");
			
			$("#idCheckLength").addClass("d-none");
			$("#idCheckDuplicated").addClass("d-none");
			$("#idCheckOk").addClass("d-none");
			
			let loginId = $("#loginId").val().trim();
			if(loginId.length < 4) {
				$("#idCheckLength").removeClass("d-none");
				return false;
			}
			
			$.ajax({
				type:"POST"
				,url:"/user/is-duplicated-id"
				,data:{"loginId":loginId}
				,success:function(data){
					if(data.code == 200){
						if(data.is_duplicated_id == true){ //중복된 아이디일 떄 
							$("#idCheckDuplicated").removeClass("d-none");
						}else {
							$("#idCheckDuplicated").addClass("d-none");
							$("#idCheckOk").removeClass("d-none");
						}
					} else{
						alert(data.error_message);
					}
				}
				,error:function(request, status, error){
					alert("아이디 중복확인에 실패했습니다.");
				}
			})
			
		});//duplicate-btn
		
		$("#signUpBtn").on('click', function(e){
			e.preventDefault();
			//alert("클릭");
			if($("#idCheckOk").hasClass("d-none")){
				alert("아이디 중복확인을 해주세요");
				return false;
			}
			
			let loginId = $("#loginId").val().trim();
			let password = $("#password").val().trim();
			let confirmPassword = $("#confirmPassword").val().trim();
			let name = $("#name").val().trim();
			let email = $("#email").val().trim();
			let phoneNumber = $("#phoneNumber").val().trim();
			let postCode = $("#postCode").val().trim();
			let address = $("#address").val().trim();
			
			if(!loginId) {
				alert("아이디를 입력해주세요");
				return false;
			}
			if(!password) {
				alert("비밀번호를 입력해주세요");
				return false;
			}
			if(password.length < 8){
				alert("비밀번호를 8자 이상 입력해주세요");
				return false;
			}
			if(password != confirmPassword) {
				alert("비밀번호 다릅니다 다시 입력해주세요");
				return false;
			}
			if(!name) {
				alert("이름을 입력해주세요");
				return false;
			}
			if(!email) {
				alert("이메일을 입력해주세요");
				return false;
			}
			if(!phoneNumber) {
				alert("전화번호를 입력해주세요");
				return false;
			}
			if(!postCode) {
				alert("우편번호를 입력해주세요");
				return false;
			}
			if(!address) {
				alert("주소를 입력해주세요");
				return false;
			}
			
			$.ajax({
				type:"POST"
				,url:"/user/sign-up"
				,data:{"loginId":loginId, "password":password, "name":name, "email":email, "phoneNumber":phoneNumber, "postCode":postCode, "address":address}
				,success:function(data){
					if(data.code == 200){
						alert("회원가입이 완료되었습니다! 환영합니다~");
						location.href="/user/sign-in-view";
					} else{
						alert(data.error_message);
					}
				}
				,error:function(request, status, error){
					alert("회원가입에 실패했습니다");
				}
				
			})//ajax
			
		});//signUpBtn
		
	});//ready
</script>
