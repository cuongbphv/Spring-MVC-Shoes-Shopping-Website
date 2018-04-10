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

	<c:forEach items="${list }" var="subAdd">
		<div class="col-xs-12 subAddressItem">
			<label class="col-xs-12 "><input class="defaultAdd itemInfo"
				type="radio" name="defaultAdd">${subAdd.address }</label>
		</div>
	</c:forEach>

</body>
</html>