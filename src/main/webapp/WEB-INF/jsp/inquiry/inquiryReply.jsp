<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="d-flex margin-left" >
	<div>
		<div class="d-flex">
			<h3 class="mr-3">제목</h3>
			<div>${inquiry.subject}</div>
		</div>
		<div class="mb-3">
			<h3>내용</h3>
			<div>${inquiry.content}</div>
		</div>
		<h6 class="font-weight-bold">답글 작성</h6>
		<textarea rows="10" cols="40" id="reply">${inquiry.reply}</textarea>
		<button class="btn bg-lemon" id="replyBtn" data-inquiry-id="${inquiry.id}">답글 작성</button>
	</div>
</div>

<script>
	$(document).ready(function() {
		$("#replyBtn").on('click', function(){
			//alert("클릭");
			let reply = $("#reply").val();
			let inquiryId = $(this).data("inquiry-id");
			//console.log(inquiryId);
			
			$.ajax({
				type:"POST"
				,url:"/inquiry/reply"
				,data:{"reply":reply, "inquiryId": inquiryId }
				,success: function(data) {
					if(data.code == 200) {
						alert("답글이 성공적으로 달렸습니다");
						location.href="/inquiry/inquiry-manage-view"
					} else {
						alert(data.error_message);
					}
				}
				,error:function(request, status, error) {
					alert("답글 작성에 실패했습니다");
				}
				
			});//ajax
			
			
		});//replyBtn
	});//document
</script>