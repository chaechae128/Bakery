<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="d-flex justify-content-center">
	<div class="col-10">
		<div class="d-flex justify-content-between">
			<h2>상품관리</h2>
			<div class="d-flex  align-items-center">
				<input type="text" class="d-flex justify-content-end search" id="productName" name="productName">
				<button id="productSearchBtn" class="btn"><img src="https://img.freepik.com/premium-vector/magnifying-glass-icon-vector-illustration_230920-960.jpg" alt="searchIcon" height="35px"></button>
				<a href="/product/product-manage-view" class="btn bg-lemon mr-3">전체 조회</a>
				<a href="/product/product-add-view"
					class="addProductBtn btn btn-secondary">새 상품 등록</a>
			</div>
		</div>
	</div>



</div>
<div class="w-100 mt-3">
	<table class="table text-center"> 
	<thead class="bg-lemon">
		<th >id</th>
		<th>상품명</th>
		<th>이미지</th>
		<th>재고</th>
		<th>원가</th>
		<th>판매가</th>
		<th>카테고리</th>
		<th>관리</th>
	</thead>
	<tbody>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.productName}</td>
				<td><img src="${product.imagePath}" alt="업로드된 이미지" width="100px"></td>
				<td>${product.stock}</td>
				<td>${product.costPrice}</td>
				<td>${product.sellingPrice}</td>
				<td>${product.category}</td>
				<td>
					<div class="d-flex justify-content-center">
					<a href="/product/product-update-view?productId=${product.id}" class="btn btn-secondary ml-2">수정</a>
					</div>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>

<script>
	$(document).ready(function(){
		$("#productSearchBtn").on('click', function() {
			let productName = $("#productName").val().trim();
			//alert(user);
			$.ajax({
				type:"GET"
				,url:"/product/searchProduct"
				,data:{"productName":productName}		
				,success:function(data){
		         	location.href="/product/searchProduct?productName="+productName;
		         }
		        ,error:function(request, status, error){
		            	alert("상품 조회 실패");
		        }
			});//ajax
			
			
		});//productSearchBtn
	});//document
</script>