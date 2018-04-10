<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<h3 style="text-align: center;">Quản lý loại sản phẩm</h3>
	<div class="table-responsive col-md-9">
		<table class="table table-bordered col-md-12"
			style="text-align: center;">
			<thead align="center">
				<tr>
					<th>Mã loại</th>
					<th>Loại sản phẩm</th>
					<th>Chỉnh sửa</th>
					<th>Xóa</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
						<td>${item.iD}</td>
						<td>${item.name}</td>
						<td><button data-toggle="modal"
								data-target="#editProductTypeModal"
								class="btn btn-primary button-style openEditProductType">Chỉnh
								sửa</button></td>
						<td><button
								class="btn btn-danger button-style deleteProductType">Xóa</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="form-group col-md-9">
		<div class="col-md-12" style="margin-top: 5px;">
			<button data-toggle="modal" data-target="#addProductTypeModal"
				class="btn btn-success col-md-offset-5 col-md-2">Thêm</button>
		</div>
	</div>
</body>
</html>