<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>전체메뉴</h1>
<c:forEach items="${productList}" var="product">
	<div>${product.productName}</div>
</c:forEach>