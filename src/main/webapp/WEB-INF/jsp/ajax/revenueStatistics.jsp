<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<c:forEach items="${list}" var="item">
		<tr>
			<td>${item.iD}</td>
			<td><fmt:formatDate value="${item.tradeTime}"
					pattern="dd-MM-yyyy - HH:mm" /></td>
			<td>${item.quantity}</td>
			<td><fmt:formatNumber value="${item.totalPrice}" type="currency"
					currencySymbol="" minFractionDigits="0" /></td>
			<td>${item.status }</td>
			<td><button id="viewOrderDetailRevenue"
					class="btn btn-info button-style" >Chi tiết</button></td>
		</tr>
	</c:forEach>
</body>
</html>