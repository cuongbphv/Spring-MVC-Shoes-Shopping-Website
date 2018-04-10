<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<title>Insert title here</title>
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	 <label class="col-md-4 control-label">Loại sản phẩm:</label>
	 <div class="col-md-8">
		<select id="${id}" name="typeID" style="padding:5px;" class="form-control" required>
			<option disabled selected hidden value="7">Loại giày</option>
			
			<c:forEach items="${list}" var="item">
			    <option value="${item.iD}"> ${item.name}</option>
			</c:forEach>
			 
		</select>
	</div>
</body>
</html>