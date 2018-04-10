<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<h3 style="text-align:center;">Quản lý khách hàng</h3>
	<div class="form-group">
		<div class="table-responsive col-md-9">
			<table class="table table-bordered col-md-12"
				style="text-align: center;">
				<thead>
					<tr>
						<th>Mã loại</th>
						<th>Tên loại</th>
						<th>Chiết khấu</th>
						<th>Hạn mức tiền</th>
						<th>Chỉnh sửa</th>
						<th>Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="item">
						<tr>
							<td>${item.iD}</td>
							<td>${item.name}</td>
							<td>${item.discount}</td>
							<td><fmt:formatNumber value="${item.levelMoney}" type="currency"
					currencySymbol="" minFractionDigits="0" /></td>
							<td><button id="editCustomerType" type="button" class="btn btn-primary button-style" data-toggle="modal"
							data-target="#EditCustomerTypeModalBox">Chỉnh sửa</button></td>
							<td><button id="deleteCustomerType" type="button" class="btn btn-danger button-style">Xóa</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="col-md-9">
				<button type="button" class="col-md-offset-6 col-md-2 btn btn-success button-style" data-toggle="modal"
							data-target="#AddCustomerTypeModalBox">Thêm loại</button>
			</div>
		</div>
		
	</div>
</body>
</html>