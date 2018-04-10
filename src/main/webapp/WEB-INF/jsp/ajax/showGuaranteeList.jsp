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
	<c:forEach items="${list}" var="item">
		<tr class="${item.seen == true?'':'unseen'}">
			<td>${item.iD}</td>
			<td>${item.getCus().name}</td>
			<td>${item.productID}</td>
			<td>${item.orderID}</td>
			<td>${item.reason}</td>
			<td><c:choose>
					<c:when test="${item.staff != null}">
									Đã trả lời
								</c:when>
					<c:otherwise>
									Chưa trả lời
								</c:otherwise>
				</c:choose></td>
			<td><button
					class="btnReceiveGuarantee btn btn-primary button-style"
					data-toggle="modal" data-target="#receiveGuaranteeModalBox">Trả
					lời</button></td>
		</tr>
	</c:forEach>
</body>
</html>