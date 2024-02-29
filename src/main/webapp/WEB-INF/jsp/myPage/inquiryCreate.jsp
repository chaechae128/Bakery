<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex">
	<!-- 메뉴 -->
	<jsp:include page="../include/myPageMenu.jsp" />
	
	<!-- 글쓰기 -->
	<div class="margin-left col-5">
		<input type="text" class="form-control  mb-3" id="subject" name="subject" placeholder="제목을 입력하세요">
		<textarea rows="6" class="form-control  mb-3" id="content" name="content" placeholder="내용을 입력하세요"></textarea>
		<div class="my-3 d-flex justify-content-between">
				<input type="file" id="file" accept=".jpg, .png, .gif, .jpeg">
				<button type="submit" id="inquiryBtn" class="btn btn-secondary">게시글 등록</button>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		$("#inquiryBtn").on('click', function() {
			//alert("클릭");
			
			//validatin
			let subject = $("#subject").val();
			let content = $("#content").val();
			let fileName = $("#file").val();
			if(!subject) {
				alert("제목을 입력하세요");
				return false;
			}
			
			if(!content) {
				alert("내용을 입력하세요");
				return false;
			}
			
			if(fileName) {
				let extension = fileName.splice(".").pop().toLowerCase();
				if($.inArray(extension, ['jpg', 'png', 'gif', 'jpeg']) ==  -1) {
					alert("이미지 파일만 업로드 할 수 있습니다.");
					$("#file").val("");
					return false;
				}
			}
			let formData = new FormData();
			formData.append("subject", subject);
			formData.append("content", content);
			formData.append("file", $("#file")[0].files[0]);
			
			
			
		});//inquiryBtn
	});//document

</script>