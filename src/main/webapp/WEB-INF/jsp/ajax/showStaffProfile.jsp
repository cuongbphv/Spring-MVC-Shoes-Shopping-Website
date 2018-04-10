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
	
			<form id="frmInfo" class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-md-3" for="email">Tên
							người dùng:</label>
						<div class="col-md-6">
							<input type="text" class="form-control itemInfo" id="email"
								value="${info.tenNV }" name="uname"
								required disabled spellcheck="false"/>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3" for="email"> Ngày
							sinh:</label>
						<div class="col-md-6">
							<input type="date" class="form-control itemInfo" id="email"
								data-date="" data-date-format="DD-MM-YYYY" name="dateofbirth"
								value="${info.ngaySinh }" required disabled spellcheck="false" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3" for="email">Số điện
							thoại:</label>
						<div class="col-md-6">
							<input type="text" class="form-control itemInfo" id="email"
								name="phone" pattern="[0-9]*" required value="${info.soDienThoai }"
								disabled spellcheck="false" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3" for="email">Giới
							tính:</label>
						<div class="col-md-4" style="padding-top: 8px;">
							<input type="radio" name="gender" value="M" class="itemInfo"
								disabled ${info.gioiTinh=='Nam'?'checked':''} />Nam<span
								style="padding: 0 30px"></span> <input type="radio"
								name="gender" value="F" class="itemInfo" disabled ${info.gioiTinh=='Nữ'?'checked':''}>Nữ</input>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3" for="email">Địa chỉ:</label>
						<div class="col-md-6">
							<textarea rows="3" class="form-control itemInfo" wrap="physical"
								name="address" required disabled spellcheck="false">${info.diaChi }</textarea>
						</div>
					</div>
					<div class="form-group">
						<!-- <div class="col-md-offset-2 col-md-6"> -->
						<div class="col-md-3 col-md-offset-3 col-xs-6"
							style="text-align: right;">
							<button type="button" id="btnEnableEdit" class="btn btn-default"
								style="background-color: #04d145;">Chỉnh sửa</button>
						</div>
						<div class="col-md-3 col-xs-6" style="text-align: right;">
							<button id="btnSubmitEdit" type="button" class="btn btn-default"
								style="background-color: #ea8b07;">Cập nhật</button>
						</div>
					</div>
				</form>
	
</body>
</html>