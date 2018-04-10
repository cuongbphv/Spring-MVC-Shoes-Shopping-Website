<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.mvp.model.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${list }" var="item">
		<tr class="${item.seen ==true?'':'unseen'}">
			<td>${item.iD }</td>
			<td><c:choose>
				<c:when test="${item.staff != null}">
					${item.staff.tenNV }
				</c:when>
				<c:otherwise>
					Chưa có
				</c:otherwise>
			</c:choose></td>
			
			<td><c:choose>
				<c:when test="${item.deliver != null}">
					${item.deliver.tenNV }
				</c:when>
				<c:otherwise>
					Chưa có
				</c:otherwise>
			</c:choose></td>
			
	<!--  		<td>${item.discount.name } <c:if test="${item.discount!=null}"> (-${item.discount.percent }%)
				  </c:if> </td>
		-->
	
			<td><fmt:formatNumber value="${item.totalPrice}"
									type="currency" currencySymbol="" minFractionDigits="0" /></td>
			<td><fmt:formatDate value="${item.tradeTime}" pattern="dd-MM-yyyy - HH:mm" /></td>
			<td>${item.status }</td>
			<td><button class="btnViewOrderDetailCustomer btn btn-info button-style" data-toggle="modal"
					data-target="#myModal">Xem</button></td>
		<!-- 	<td><button class="btnCancelOrder btn btn-danger button-style">Hủy</button></td>  -->
		</tr>
	</c:forEach>
	
</body>
</html>