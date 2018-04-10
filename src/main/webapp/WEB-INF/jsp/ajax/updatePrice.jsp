<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
			<td>${item.name}</td>
			<td><fmt:formatNumber value="${item.price}" type="currency"
					currencySymbol="" minFractionDigits="0" /></td>
			<td>${item.discount}</td>
			<td><button
					class="updatePriceModal btn btn-primary button-style-update"
					data-toggle="modal" data-target="#updatePriceModalBox">Cập
					nhật</button></td>
			<td><button
					class="updateDiscountModal btn btn-primary button-style-update"
					data-toggle="modal" data-target="#updateDiscountModalBox">Cập
					nhật</button></td>
		</tr>
	</c:forEach>
</body>
</html>