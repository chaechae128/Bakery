<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
   <div class="d-flex justify-content-center">
      <h1 class="display-4 font-weight-bold">아이디 찾기</h1>
   </div>
   <hr>
   <form action="/user/find-id" method="post">
      <div class="d-flex justify-content-center">
      	<input id="email" name="email" placeholder="이메일" class="form-control col-2 mr-1">
      </div>
      <div class="d-flex justify-content-center mt-2">
         <input id="name" name="name" placeholder="이름" class="form-control col-2">
      </div>
      <div class="d-flex justify-content-center mt-3">
         <input type="submit" value="아이디 확인" class="bg-lemon col-2 border-0" id="findIdBtn">
      </div>
   
   </form>
   
</div>

<script>
   $(document).ready(function(){

     /*  
      $("#findIdBtn").on('click', function(e){
         e.preventDefault();
         //alert("클릭");
         let email = $("#email").val().trim();
         let name = $("#name").val().trim();
        
         if(!email){
            alert("이메일을 입력하세요");
            return false;
         }
         
         if(!name) {
            alert("이름을 입력하세요7");
            return false;
         }
      });//findIdBtn */
   });//document
</script>