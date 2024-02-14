<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="d-flex justify-content-center">

	<c:set var="i" value="0" />
	<c:set var="j" value="5" />
	<table>
	  <c:forEach items="${productList}" var="product">
	    <c:if test="${i%j == 0 }">
	    <tr>
	    </c:if>
			<td class="p-3">
		    	<a href="#">
		       		<div><img src="${product.imagePath}" alt="상품 사진" width="200px"></div>
					<div>${product.productName}</div>
					<div>${product.sellingPrice}</div>
				</a>
		     </td>
	    <c:if test="${i%j == j-1 }">
	    </tr>
	    </c:if>
	    <c:set var="i" value="${i+1 }" />
	  </c:forEach>
	</table>


</div>