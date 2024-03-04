<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="d-flex">
	<!-- 메뉴 -->
	<jsp:include page="../include/myPageMenu.jsp" />
    	
    <!-- 글 목록 -->
   	<div class="margin-left col-8 margin-right">
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
   					<c:forEach items="${inquiryList}" var="inquiry" varStatus="status">
	   					 <tr>
	   						<td>${status.count}</td>
	   						<td><a href="/inquiry/inquiry-detail-view?inquiryId=${inquiry.id}">${inquiry.subject}</a></td>
	   						<td><fmt:formatDate value="${inquiry.createdAt}" pattern="yyyy년 M월 dd일" /></td>
	   					</tr>
   					</c:forEach>
   				</tbody>
   			</table>
   		</div>
   		
   		<div class="d-flex justify-content-end">
   			<a href="/inquiry/inquiry-create-view" class="btn bg-lemon">글 쓰기</a>
   		</div>
   	</div> 
   
</div>