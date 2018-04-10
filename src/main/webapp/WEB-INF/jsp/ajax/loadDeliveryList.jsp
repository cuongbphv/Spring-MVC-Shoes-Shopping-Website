<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<table class="table table-bordered col-md-12 "
		style="text-align: center;">
		<thead>
			<tr>
				<th>Mã đơn hàng</th>
				<th>Tên khách hàng</th>
				<th>Số điện thoại</th>
				<th>Địa chỉ</th>
				<th>Thời gian xuất</th>
				<th>Tổng đơn hàng</th>
				<th>Nhân viên xác nhận</th>
				<th>Xác nhận</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.iD }</td>
					<td>${item.getCustomer().name }</td>
					<td>${item.getCustomer().phoneNo }</td>
					<td>${item.address }</td>
					<td><fmt:formatDate value="${item.tradeTime}"
							pattern="dd-MM-yyyy - HH:mm" /></td>
					<td>${item.totalPrice }</td>
					<td>${item.getStaff().tenNV }<input type="hidden"
						value="${item.staffID}" /></td>
					<td><button id="submitDeliveryTrucking"
							class="btn btn-primary button-style" data-toggle="modal"
							data-target="#SubmitDeliveryTruckingModalBox">Xác nhận</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<div class="col-sm-12" style="text-align: center">
		<input id="pageTrunkingNums" type="hidden" value="${pageNums }" />
		<c:if test="${pageNums > 1 }">
			<ul class="pagination pagination">
				<li class="prevTrunking"><a>&#10096;&#10096;</a></li>
				<c:forEach begin="0" end="${pageNums - 1}" varStatus="loop">
					<li class="pageTrunkingItem ${loop.index+1 == page?'active':'' } "><a
						>${loop.index + 1}</a></li>
				</c:forEach>
				<li class="nextTrunking"><a>&#10097;&#10097;</a></li>
			</ul>
		</c:if>
	</div>
</body>
</html>