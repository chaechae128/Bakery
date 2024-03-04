<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="d-flex justify-content-center">
	<div class="col-10">
		<div class="d-flex justify-content-between">
			<h2>문의글 관리</h2>
			<!--검색-->
			<div class="d-flex  align-items-center">
				<input type="text" class="d-flex justify-content-end search" id="order" name="order">
				<button id="orderSearchBtn" class="btn"><img src="https://img.freepik.com/premium-vector/magnifying-glass-icon-vector-illustration_230920-960.jpg" alt="searchIcon" height="35px"></button>
				<a href="/order/order-manage-view" class="btn bg-lemon">전체 조회</a>
			</div>

		</div>
	</div>



</div>
<div class="w-100 mt-3">
	<table class="table text-center">
		<thead class="bg-lemon">
			<th>번호</th>
			<th>회원 번호</th>
			<th>제목</th>
			<th>작성 일시</th>
			<th>작성 여부</th>
			<th></th>
		</thead>
		<tbody>
			<c:forEach items="${inquiryList}" var="inquiry">
					<tr>
						<td>${inquiry.id}</td>
						<td>${inquiry.userId}</td>
						<td>${inquiry.subject}</td>
						<td><fmt:formatDate value="${inquiry.createdAt}" pattern="yyyy년 M월 dd일" /></td>
						<td>
							<c:if test="${empty inquiry.reply}">
								미작성
							</c:if>
							<c:if test="${not empty inquiry.reply}">
								작성 완료
							</c:if>
						</td>
						<td><a href="/inquiry/inquiry-reply-view?inquiryId=${inquiry.id}" class="btn bg-lemon">답글작성</a></td>
					</tr>
				
			</c:forEach>
		</tbody>
	</table>
</div>