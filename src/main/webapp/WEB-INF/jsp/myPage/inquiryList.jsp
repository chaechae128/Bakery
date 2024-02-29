<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex">
	<!-- 메뉴 -->
	<jsp:include page="../include/myPageMenu.jsp" />
    	
    <!-- 글 목록 -->
   	<div class="margin-left">
   		<h3>작성한 문의글</h3>
   		
   		<!-- 글 목록 -->
   		<div>
   			<table class="table text-center">
   				<thead>
   					<th>No.</th>
   					<th>제목</th>
   					<th>작성 날짜</th>
   				</thead>
   					
   				<tbody>
   					<tr>
   						<td>1</td>
   						<td><a href="#">~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</a></td>
   						<td></td>
   					</tr>
   				</tbody>
   			</table>
   		</div>
   		
   		<div class="d-flex justify-content-end">
   			<a href="/inquiry/inquiry-create-view" class="btn bg-lemon">글 쓰기</a>
   		</div>
   	</div> 
   
</div>