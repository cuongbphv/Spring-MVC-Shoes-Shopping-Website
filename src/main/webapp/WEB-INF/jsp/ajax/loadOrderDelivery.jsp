<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<c:forEach items="${list}" var="item">
		<tr>
			<td>${item.iD }</td>
			<td>${item.getCustomer().name }</td>
			<td>${item.getCustomer().phoneNo }</td>
			<td>${item.address }</td>
			<td><fmt:formatDate value="${item.tradeTime}"
					pattern="dd-MM-yyyy - HH:mm" /></td>
			<td>${item.totalPrice }</td>
			<td>${item.getStaff().tenNV }<input type="hidden"
				value="${item.staffID}" /></td>
			<td><c:choose>
					<c:when test="${item.deliver == null}">
						<button id="submitOrderDelivery"
					class="btn btn-primary button-style">Nhận</button></td>
					</c:when>
					<c:otherwise>
						<b>Đã nhận giao hàng</b>
					</c:otherwise>
				</c:choose>			
		</tr>
	</c:forEach>
</body>
</html>