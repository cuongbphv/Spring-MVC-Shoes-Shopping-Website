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
	
		<div class="commentDetail">
			<span id="rateStar"> 
				<c:forEach var = "i" begin = "1" end = "${item.star }">
					<img style="width: 24px; height: 24px"
					src="<c:url value="/resources/myweb/img/fullstar.png" />">
				</c:forEach>
			</span>
			<h4 class="media-heading">
				${item.title} <small>
				<i>Đăng vào <fmt:formatDate value="${item.commentDate}" pattern="dd-MM-yyyy" /> bởi ${item.customer.name}</i></small>
			</h4>
			<p>${item.content }</p>
		</div>
	</c:forEach>
	
	
</body>
</html>