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
		<div
			style="text-align: left; border-bottom: 1px solid #c0c0c0; padding-bottom: 5px; padding-top: 5px;"
			class="logHeader col-sm-12">
			<div style="text-align: center;" class="col-sm-3"><fmt:formatDate value="${item.time}" pattern="dd-MM-yyyy - hh:mm" /></div>
			<div style="border-left: 1px solid #c0c0c0;" class="col-sm-9">${item.content }</div>
		</div>
	</c:forEach>

</body>
</html>