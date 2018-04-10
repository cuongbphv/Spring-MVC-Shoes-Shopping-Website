<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <label class="col-md-4 control-label">Chất liệu :</label>
	 <div class="col-md-8">
		<select id="${id}" name="materialID" style="padding:5px;" class="form-control" required>
			<option disabled selected hidden value="7">Chất liệu</option>
			
			<c:forEach items="${list}" var="item">
			    <option value="${item.iD}"> ${item.name}</option>
			</c:forEach>
			 
		</select>
	</div>
</body>
</html>