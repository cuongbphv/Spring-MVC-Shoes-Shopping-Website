<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="table-responsive col-md-12">
		<table class="table table-bordered col-md-12"
			style="text-align: center;">
			<thead>
				<tr>
					<th>Mã nhập</th>
					<th>Nhân viên nhập</th>
					<th>Số lượng</th>
					<th>Ngày nhập</th>
					<th>Tổng tiền</th>
					<th>Chi tiết</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="total" value="${0}" />
				<c:forEach items="${list}" var="item">
					<tr>
						<td>${item.importID}</td>
						<td>${item.getStaff().tenNV}</td>
						<td>${item.quantity}</td>
						<td><fmt:formatDate value="${item.importDate}"
								pattern="dd-MM-yyyy - HH:mm" /></td>
						<td><fmt:formatNumber value="${item.total}" type="currency"
								currencySymbol="" minFractionDigits="0" /></td>
						<td><button id="viewImportDetailList"
								class="btn btn-info button-style" data-toggle="modal"
								data-target="#ImportDetailModalBox">Chi tiết</button></td>
					</tr>
					<c:set var="total" value="${total + item.total}" />
				</c:forEach>
			</tbody>
		</table>
	</div>
	<label class="col-md-offset-6 col-md-2 label-control"
		style="text-align: right; margin-top: 10px;">Tổng tiền nhập:</label>
	<label class="col-md-3 label-control"
		style="text-align: left; margin-top: 10px;"><fmt:formatNumber
			value="${total}" type="currency" currencySymbol=""
			minFractionDigits="0" /></label>
</body>
</html>