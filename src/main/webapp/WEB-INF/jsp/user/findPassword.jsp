<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
   <div class="d-flex justify-content-center">
      <h1 class="display-4 font-weight-bold">아이디 찾기</h1>
   </div>
   <hr>
   <form action="/user/find-id" method="post">
   	  <div class="d-flex justify-content-center mt-3">
      	<input id="loginId" name="loginId" placeholder="아이디" class="form-control col-2 mr-1">
      </div>
      <div class="d-flex justify-content-center mt-3">
      	<input id="email" name="email" placeholder="이메일" class="form-control col-2 mr-1">
      </div>

      <div class="d-flex justify-content-center mt-3">
         <input id="name" name="name" placeholder="이름" class="form-control col-2">
      </div>
      <div class="d-flex justify-content-center mt-3">
         <input type="submit" value="비밀번호 확인" class="bg-lemon col-2 border-0" id="findPwBtn">
      </div>
   
   </form>
   
</div>

<script>
   $(document).ready(function(){
      
      $("#findPwBtn").on('click', function(e){
         e.preventDefault();
         //alert("클릭");
         let loginId = $("#loginId").val().trim();
         let email = $("#email").val().trim();
         let name = $("#name").val().trim();
         
         if(!loginId) {
             alert("아이디를 입력하세요");
             return false;
          }
    
         if(!email){
            alert("이메일을 입력하세요");
            return false;
         }
    
         if(!name) {
            alert("이름을 입력하세요");
            return false;
         }
       
         
         $.ajax({
            type:"POST"
            ,url:"/user/find-password"
            ,data:{"loginId":loginId, "email":email, "name":name}
            ,success:function(data){
               if(data.code == 200){
                  
               }
            }
         });//ajax
         
      });//findIdBtn
   });//document
</script>