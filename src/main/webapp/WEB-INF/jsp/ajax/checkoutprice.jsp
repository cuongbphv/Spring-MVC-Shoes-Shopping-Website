<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="tempPrice col-xs-12">
		<div class="col-xs-8">Tạm tính:</div>
		<div class="col-xs-4">
			<span><fmt:formatNumber value="${totalPrice}" type="currency"
					currencySymbol="" minFractionDigits="0" /> </span> VND
		</div>
		<div class="col-xs-8">Thuế VAT:</div>
		<div class="col-xs-4">10%</div>
	</div>

	<div class="totalPrice col-xs-12">
		<div class="col-xs-8"><h4><b>Tổng tiền(bao gồm VAT):</b></h4></div>
		<div class="col-xs-4">
			<h4>
				<b><span><fmt:formatNumber value="${lastPrice}" type="currency"
					currencySymbol="" minFractionDigits="0" /> </span> VND</b>
			</h4>
		</div>
	</div>
</body>
</html>