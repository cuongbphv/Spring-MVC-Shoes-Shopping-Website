<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
			<option value="0">Tất cả</option>
			<c:forEach items="${list}" var="item">
			    <option value="${item.iD}"> ${item.name}</option>
			</c:forEach>
</body>
</html>