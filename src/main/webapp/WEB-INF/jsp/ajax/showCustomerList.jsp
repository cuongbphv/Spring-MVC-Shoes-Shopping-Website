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
	<table class="table table-bordered col-md-12"
		style="text-align: center;">
		<thead>
			<tr>
				<th>Mã</th>
				<th>Tên khách hàng</th>
				<th>Số điện thoại</th>
				<th>Giới tính</th>
				<th>Ngày sinh</th>
				<th>Loại khách hàng</th>
				<th>Xem chi tiết</th>
				<th>Giao dịch</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="item">
				<tr>
					<td>${item.cusID }</td>
					<td>${item.name }</td>
					<td>${item.phoneNo }</td>
					<td>${item.gender }</td>
					<td><fmt:formatDate value="${item.dateofBirth}"
							pattern="dd-MM-yyyy" /></td>
					<td>${item.type.name }</td>
					<td><button
							class="btnViewCustomerDetail btn btn-info button-style"
							data-toggle="modal" data-target="#customerDetail">Chi
							tiết</button></td>
					<td><button
							class="btnViewCustomerOrders btn btn-info button-style"
							data-toggle="modal" data-target="#customerTradeHistory">Xem</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div class="col-sm-12" style="text-align: center">
		<input id="pageCusNums" type="hidden" value="${pageNums }" />
		<c:if test="${pageNums > 1 }">
			<ul class="pagination pagination">
				<li class="prevCustomer"><a>&#10096;&#10096;</a></li>
				<c:forEach begin="0" end="${pageNums - 1}" varStatus="loop">
					<li class="pageCusItem ${loop.index+1 == page?'active':'' } "><a
						>${loop.index + 1}</a></li>
				</c:forEach>
				<li class="nextCustomer"><a>&#10097;&#10097;</a></li>
			</ul>
		</c:if>

	</div>
</body>
</html>