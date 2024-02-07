<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div>
	<div class="d-flex justify-content-center">
		<h3 class="display-4 font-weight-bold">아이디 찾기</h3>
	</div>
	<hr>
	<c:if test="${!empty user.loginId}">
		<h4 class="d-flex justify-content-center">${user.name}의 아이디는 <span class="font-weight-bold">${user.loginId}</span> 입니다</h4>
	</c:if>
	<c:if test="${empty user.loginId}">
		<h4 class="d-flex justify-content-center">일치하는 아이디가 없습니다.</h4>
	</c:if>
	<div class="d-flex justify-content-center ">
		<a href="/user/sign-in-view" class="btn bg-lemon col-2">로그인 화면으로 이동</a>
	
	</div>
	


</div>