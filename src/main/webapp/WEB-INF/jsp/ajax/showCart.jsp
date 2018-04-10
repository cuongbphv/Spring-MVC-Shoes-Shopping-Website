<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${empty list}">
			<h1 style="text-align: center;">Không có sản phẩm nào trong giỏ
				hàng</h1>
		</c:when>
		<c:otherwise>
			<div class="row cartHeader">
				<div class="col-md-2 col-md-offset-1 col-xs-3">Sản phẩm</div>
				<div class="col-md-2 col-xs-0"></div>
				<div class="col-md-1 col-xs-2">Màu</div>
				<div class="col-md-1 col-xs-1">Size</div>
				<div class="col-md-2 col-xs-2">Đơn giá</div>
				<div class="col-md-1 col-xs-2">Số SP</div>

			</div>

			<c:forEach var="it" items="${list }" varStatus="loop">
				<div class="row cartProduct">

					<div
						class="productItem imgCartProduct col-md-2 col-md-offset-1 col-xs-3">
						<a href="/VerOne/product/${it.item.iD }"><img
							class="img-responsive"
							src="data:image/png;base64,${it.item.base64}" alt=""></a>
						<div class="pID" style="display: none">${it.item.iD }</div>
					</div>
					<div class="nameCartProduct productItem col-md-2 col-xs-0">
						${it.item.name }</div>
					<div class="productItem col-md-1 col-xs-2">
						${it.colorItem.name }
						<div class="colorID" style="display: none">${it.colorItem.iD }</div>
					</div>
					<div class="productItem col-md-1 col-xs-1">
						${it.sizeItem.name }
						<div class="sizeID" style="display: none">${it.sizeItem.iD }</div>
					</div>
					<div class="productprice col-md-2 col-xs-2">
						<span><fmt:formatNumber
								value="${it.item.price - it.item.price*it.item.discount/100 }"
								type="currency" currencySymbol="" minFractionDigits="0" /> </span>
					</div>
					<div class="productItem col-md-1 col-xs-3">
						<input class="countItem form-control" onchange="setItems();"
							type="number" min="0" value="${it.numItems}">
					</div>
					<div class="deleteCart col-md-1 col-xs-1">
						<span class="removeOrder">x</span>
					</div>
				</div>
			</c:forEach>


			<div class="row checkout">
				<div class="col-md-5 col-md-offset-1 col-xs-6">
					<p id="TotalPriceCart">
						TỔNG TIỀN: <span><fmt:formatNumber value="${totalPrice}"
								type="currency" currencySymbol="" minFractionDigits="0" /> VND</span>
					</p>
				</div>
				<div class="col-md-5 col-xs-6">
					<button class="btnCheckout"><a style="color:white;" href="/VerOne/checkout">TIẾN HÀNH THANH TOÁN</a></button>
				</div>
			</div>
		</c:otherwise>
	</c:choose>

</body>
</html>