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
						<div class="subAddress">
							<label class="col-xs-10 subAddressItem"><input class="defaultAdd itemInfo" type="radio" 
							name="defaultAdd" ${subAdd.defaultAdd==true?'checked':'' }>${subAdd.address }</label>
							<div  class="col-md-2 btnControl" style="line-height: 40px; cursor: pointer;display:block;">
					         	 <a class="btnDeleteAddress" ${subAdd.defaultAdd==true?'style="visibility:hidden"':'' } >Xóa</a></label>
					        </div>
					     </div>
						</c:forEach>
	
</body>
</html>