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
	<c:forEach items="${list}" var="item">
		<div class="row orderProduct">
			<div class="col-md-12 col-xs-12">
				<div class="orderProductHeader col-md-12">
					<div class="col-md-4">
						Đơn hàng #${item.iD} </br>Đặt ngày
						<fmt:formatDate value="${item.tradeTime}" pattern="dd-MM-yyyy" />
					</div>
					<div class="col-md-4">Trạng thái: ${item.status}</div>
					<div class="col-md-4">
						<a style="float: right;" href="/VerOne/orderdetail/${item.iD}">Quản
							lý đơn hàng>></a>
					</div>
				</div>

				<c:forEach items="${item.listDetail}" var="detail">
					<div class="orderProductItem col-md-6 col-xs-12">
						<div class="crop col-md-4 col-xs-4">
							<a href="/VerOne/product/${detail.product.iD }"><img class="img-responsive"
								src="data:image/png;base64,${detail.product.base64}" alt=""></a>
						</div>
						<div class="col-md-8 col-xs-8">
							${detail.product.name}<br />${detail.color.name} ${detail.size.name}
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</c:forEach>
</body>
</html>