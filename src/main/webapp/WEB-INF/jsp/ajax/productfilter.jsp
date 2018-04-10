<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="product col-md-10 col-md-offset-2">
	
	<c:if test="${fn:length(list) lt 1}">
		<h3 style="text-align:center">Không có sản phẩm nào</h3>
	</c:if>
	
	<c:forEach var="product" items="${list }">

		<div class="col-md-3 col-xs-6">
			<div class="productWrap" style="position: relative;">
				<a href="/VerOne/product/${product.iD}">
					<div class="crop col-xs-12 col-md-12">
						<img class="img-responsive col-xs-12 col-md-12"
							src="data:image/png;base64,${product.base64}"
							alt="${product.name }">
					</div>
					<p class="startingPrice">
						Giá chỉ<br />
						<c:choose>
							<c:when test="${product.discount > 0}">
								<span style="text-decoration: line-through;"><fmt:formatNumber
										value="${product.price}" type="currency" currencySymbol=""
										minFractionDigits="0" /></span>
								<br />
								<span style="color: red;"><fmt:formatNumber
										value="${product.price - product.price*product.discount/100 }"
										type="currency" currencySymbol="" minFractionDigits="0" /></span>
							</c:when>
							<c:otherwise>
								<fmt:formatNumber value="${product.price}" type="currency"
									currencySymbol="" minFractionDigits="0" />
							</c:otherwise>
						</c:choose>
					</p>
					<h5 class="productName">${product.name }</h5>
				</a>
			</div>
		</div>
	</c:forEach>
		<div class="col-xs-12" style="text-align:center">
		<c:if test="${pageNums > 1 }">
			<ul class="pagination pagination">
			<c:forEach begin="0" end="${pageNums - 1}" varStatus="loop">
			    <li class="pageItem ${loop.index+1 == page?'active':'' } "><a href="#"><span class="badge">${loop.index + 1}</span></a></li>
			</c:forEach>
			</ul>
		</c:if>
		</div>
	</div>
	

</body>
</html>