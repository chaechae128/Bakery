<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>상품 등록</h3>
<div class="d-flex">
		<div class="m-4">
			<div class="my-2">
				<input class="form-control col-7" type="text" id="productName" name="productName" placeholder="상품 명" value="${product.productName}">
			</div>
			<div class="my-2">
				<input class="form-control col-7" type="text" id="stock" name="stock" placeholder="재고" value="${product.stock}">
			</div>
			<div class="my-2">
				<input class="form-control col-7" type="text" id="costPrice" name="costPrice" placeholder="원가" value="${product.costPrice}">
			</div>
			<div class="my-2">
				<input class="form-control col-7" type="text" id="sellingPrice" name="sellingPrice" placeholder="판매가" value="${product.sellingPrice}">
			</div>
			<div class="my-2">
				<select class="form-control col-7" id="category" name="category">
		            <option>--카테고리--</option>
		            <option>케이크</option>
		            <option>디저트</option>
		            <option>빵</option>
        		</select>
			</div>
			<div class="my-3">
				<div>변경할 사진을 다시 첨부해주세요</div>
				<input type="file" id="file" accept=".jpg, .png, .gif, .jpeg" value="${product.imagePath}">
			</div>
			<button type="submit" id="productAddBtn" class="btn btn-secondary" data-product-id="${product.id}">상품 수정</button>
			<button type="submit" id="productDeleteBtn" class="btn btn-secondary" data-product-id="${product.id}">삭제</button>
		</div>
		<img src="${product.imagePath}" width="500px">
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
			let productId = $(this).data("product-id");
			//console.log(productId);
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
			if(!fileName) {
				alert("파일을 첨부해주세요");
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
			
			
			let formData = new FormData();
			formData.append("productId", productId);
			formData.append("productName", productName);
			formData.append("stock", stock);
			formData.append("costPrice", costPrice);
			formData.append("sellingPrice", sellingPrice);
			formData.append("category", category);
			formData.append("file", $("#file")[0].files[0]);
			$.ajax({
				type:"POST"
				,url:"/product/update"
				,data: formData
				,enctype:"multipart/form-data"
				,processData:false
				,contentType:false
				,success:function(data){
					if(data.code == 200){
						alert("상품 수정 완료되었습니다");
						location.href="/product/product-manage-view";
					} else {
						alert(data.error_message);
					}
				}
				,error:function(request, status, error){
					alert("상품 수정에 실패하였습니다");
				}
			});//ajax
		});//productAddBtn
		
		//상품 삭제
		$("#productDeleteBtn").on('click', function(){
			let productId = $(this).data("product-id");
			$.ajax({
				type:"DELETE"
				,url:"/product/delete"
				,data: {"productId":productId}
				,success:function(data){
					if(data.code == 200){
						alert("상품 삭제가 완료되었습니다");
						location.href="/product/product-manage-view";
					} else {
						alert(data.error_message);
					}
				}
				,error:function(request, status, error){
					alert("상품 삭제에 실패하였습니다");
				}
			});
		});//productDeleteBtn
	});//document
</script>