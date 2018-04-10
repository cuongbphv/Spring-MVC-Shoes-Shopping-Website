<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<label class="col-md-4 control-label">Chức vụ:</label>
	<div class="col-md-8">
		<select id="${id}" name="staffTypeID" class="form-control">
			<option disabled selected hidden value="7">Loại nhân viên</option>
			
			<c:forEach items="${list}" var="item">
			    <option value="${item.maLoaiNV}"> ${item.tenLoaiNV}</option>
			</c:forEach>
		</select>
	</div>
</body>
</html>