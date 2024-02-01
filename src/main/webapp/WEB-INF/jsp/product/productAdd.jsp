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
				<input type="file" id="file" accept=".jpg, .jpeg, .gif, .png" class="d-none">
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
				<select class="form-control col-4">
		            <option>--카테고리--</option>
		            <option>케이크</option>
		            <option>쿠키</option>
		            <option>빵</option>
        		</select>
			</div>
		</div>
	</form>
</div>