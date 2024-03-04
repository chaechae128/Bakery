<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="d-flex">
	<!-- 메뉴 -->
	<jsp:include page="../include/myPageMenu.jsp" />
	
	<!-- 글쓰기 -->
	<div class="margin-left col-5">
		<input type="text" class="form-control  mb-3" id="subject" name="subject" value="${inquiry.subject}">
		<textarea rows="6" class="form-control  mb-3" id="contents">${inquiry.content}</textarea>
		<div class="my-3 d-flex justify-content-between">
			<c:if test="${not empty inquiry.imagePath}">
				<img src="${inquiry.imagePath}" width="150px">
				<input type="file" id="file" accept=".jpg, .png, .gif, .jpeg">
			</c:if>
			<c:if test="${empty inquiry.imagePath}">
				<input type="file" id="file" accept=".jpg, .png, .gif, .jpeg">
			</c:if>
				<div >
					<button type="submit" id="updateBtn" class="btn btn-secondary" data-inquiry-id="${inquiry.id}">게시글 수정</button>
				</div>
		</div>
		<div>
			<h5>답글</h5>
			<c:if test="${not empty inquiry.reply}">
				<div>${inquiry.reply}</div>
			</c:if>
			<c:if test="${empty inquiry.reply}">
				<div>아직 작성된 답변이 없습니다..</div>
			</c:if>
		
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		$("#updateBtn").on('click', function() {
			//alert("클릭");
			
			//validatin
			let subject = $("#subject").val();
			let content = $("#contents").val();
			let fileName = $("#file").val();
			let inquiryId = $(this).data("inquiry-id");
			//console.log(inquiryId);
			if(!subject) {
				alert("제목을 입력하세요");
				return false;
			}
			
			if(!content) {
				alert("내용을 입력하세요");
				return false;
			}
			
			if(fileName) {
				let extension = fileName.split(".").pop().toLowerCase();
				if($.inArray(extension, ['jpg', 'png', 'gif', 'jpeg']) == -1){
					alert("이미지 파일만 업로드 할 수 있습니다.");
					$("#file").val("");
					return false;
				}
			}
			let formData = new FormData();
			formData.append("subject", subject);
			formData.append("content", content);
			formData.append("inquiryId", inquiryId);
			formData.append("file", $("#file")[0].files[0]);
			
			$.ajax({
				type:"POST"
				,url:"/inquiry/update"
				,data: formData
				,enctype:"multipart/form-data"
				,processData:false
				,contentType:false
				,success:function(data){
					if(data.code == 200){
						alert("문의글이 수정되었습니다");
						location.href="/inquiry/inquiry-list-view";
					} else {
						alert(data.error_message);
					}
				}
				,error:function(request, status, error){
					alert("문의글 수정에 실패하였습니다");
				}
			
			});//ajax
			
		});//inquiryBtn
	});//document

</script>