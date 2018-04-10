<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>				
						<div class="crop col-xs-12 col-md-12">
							<img style="visibility:hidden" class="img-responsive"
								src="data:image/png;base64,${image[0].base64}"
								alt="${image[0].productID}">
								
							<div class="tiles">

					    		<div class="tile" data-scale="2.0" data-image="data:image/png;base64,${image[0].base64}"></div>
					    	</div>
						</div>
						
						<div  style="text-align:center;" class="otherSide col-xs-12 col-md-12" style="z-index:49">	
							<div  class="justify">
							
							<c:forEach var="imageItem" items="${image}" varStatus="loop">
							
								<div class="crop2 ortherItem">
								<img class="img-responsive" 
									src="data:image/png;base64,${imageItem.base64}">
								</div>
							</c:forEach>
																
							</div>								
						</div>						
</body>
</html>