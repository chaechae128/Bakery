<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<h3>상품 등록</h3>
	<form method="post" action="/product/add">
		<div class="m-4">
			<div class="my-2">
				<input class="form-control col-4" type="text" id="productName" name="productName" placeholder="상품 명">
			</div>
			<div class="my-2">
				<input class="form-control col-4" type="text" id="stock" name="stock" placeholder="재고">
			</div>
			<div class="my-2">
				<input class="form-control col-4" type="text" id="costPrice" name="costPrice" placeholder="원가">
			</div>
			<div class="my-2">
				<input class="form-control col-4" type="text" id="sellingPrice" name="sellingPrice" placeholder="판매가">
			</div>
			<div class="my-2">
				<select class="form-control col-4" id="category" name="category">
		            <option>--카테고리--</option>
		            <option>케이크</option>
		            <option>쿠키</option>
		            <option>빵</option>
        		</select>
			</div>
			<div class="my-3">
				<input type="file" id="file" accept=".jpg, .png, .gif, .jpeg">
			</div>
			<button type="submit" id="productAddBtn" class="btn btn-secondary">상품 등록</button>
		</div>
	</form>
</div>

<script>
	$(document).ready(function(){
		$("#productAddBtn").on('click', function(){
			//alert("클릭");
			//validation
			let productName = $("#productName").val();
			let stock = $("#stock").val();
			let costPrice = $("#costPrice").val();
			let sellingPrice = $("#sellingPrice").val();
			let category = $("#category").val();
			let fileName = $("#file").val();
			//console.log(productName + "  " + category);
			
			if(!productName) {
				alert("상품 명을 입력해주세요");
				return false;
			}
			
			if(!stock) {
				alert("재고를 입력해주세요");
				return false;
			}
			
			if(!costPrice) {
				alert("원가를 입력해주세요");
				return false;
			}
			
			if(!sellingPrice) {
				alert("판매가를 입력해주세요");
				return false;
			}
			
			if(!category) {
				alert("카테고리를 입력해주세요");
				return false;
			}
			
			if(fileName){
				let extension = fileName.split(".").pop().toLowerCase();
				if($.inArray(extension, ['jpg', 'png', 'gif', 'jpeg']) == -1){
					alert("이미지 파일만 업로드 할 수 있습니다.");
					$("#file").val("");
					return false;
				}
			}
			
			$.ajax({
				type:"POST"
				,url:"/product/add"
				,data:{"productName":productName, "stock":stock, "costPrice":costPrice, "sellingPrice":sellingPrice, "category":category, "file":$("#file")[0].files[0]}
				,enctype:"multipart/form-data"
				,processData:false
				,contentType:false
				,success:function(data){
					if(data.code == 200){
						alert("상품 등록이 완료되었습니다");
						location.href="/product/product-manage-view";
					} else {
						alert(data.error_message);
					}
				}
				,error:function(request, status, error){
					alert("상품 등록에 실패하였습니다");
				}
			});//ajax
			
			
		});//productAddBtn
	});//document
</script>