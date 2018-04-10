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
							<input type="text" class="form-control itemInfo"
								value="${info.name }" name="uname"
								required disabled spellcheck="false"/>
							<input id="cusInfoID" type="hidden" value ="${info.cusID }" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3" for="email"> Ngày
							sinh:</label>
						<div class="col-md-6">
							<input type="date" class="form-control itemInfo"
								data-date="" data-date-format="DD-MM-YYYY" name="dateofbirth"
								value="${info.dateofBirth }" required disabled spellcheck="false" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3" for="email">Số điện
							thoại:</label>
						<div class="col-md-6">
							<input type="text" class="form-control itemInfo"
								name="phone" pattern="[0-9]*" required value="${info.phoneNo }"
								disabled spellcheck="false" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3" for="email">Giới
							tính:</label>
						<div class="col-md-4" style="padding-top: 8px;">
							<input type="radio" name="gender" value="M" class="itemInfo"
								disabled ${info.gender=='Nam'?'checked':''} />Nam<span
								style="padding: 0 30px"></span> <input type="radio"
								name="gender" value="F" class="itemInfo" disabled ${info.gender=='Nữ'?'checked':''}>Nữ</input>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3" for="email">Địa chỉ:</label>
						<div class="col-md-6">
							<textarea id="address" rows="3" class="form-control itemInfo" wrap="physical"
								name="address" required disabled spellcheck="false">${info.address }</textarea>
						</div>
					</div>
				<c:if test="${staffRequest == 0 }">
					
					<div class="form-group">
					 	<div class="col-xs-9 btnControl" style="text-align: right;cursor: pointer;">
							<a id="showAdd">Chọn/thêm địa chỉ <span class="glyphicon glyphicon-menu-down"></span> </a></label>
						</div>
					</div>

					<div class="form-group otherAddress" style="display: none;">
						<div class="col-md-offset-3 col-md-6" id="subAddWrap">
						<c:forEach items="${info.allAddress }" var="subAdd">
						<div class="subAddress">
							<label class="col-xs-10 subAddressItem"><input class="defaultAdd itemInfo" type="radio" 
							name="defaultAdd" ${subAdd.defaultAdd==true?'checked':'' } disabled>${subAdd.address }</label>
							<div  class="col-md-2 btnControl" style="line-height: 40px; cursor: pointer;">
					         	 <a  class="btnDeleteAddress" ${subAdd.defaultAdd==true?'style="visibility:hidden"':'' } >Xóa</a></label>
					        </div>
					     </div>
						</c:forEach>

						</div>
						<div class="col-md-offset-3 col-md-6">
							<div class="col-md-10">
						        <textarea id="newAddress" rows="2" class="form-control itemInfo" wrap="physical" name="otherAddress" disabled></textarea>
						     </div>
							 <div  class="col-md-2 btnControl" style="line-height: 50px; cursor: pointer;">
					         	 <a class="btnAddAddress">Thêm</a></label>
					        </div>
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
				</c:if>
					
				<c:if test="${staffRequest == 1 }">
					<div class="form-group">

						<div class="col-md-3 col-md-offset-6" style="text-align: right;">
							<button id="btnResetPassword" type="button" class="btn btn-primary"
								>Đặt lại mật khẩu</button>
						</div>
					</div>
				</c:if>
				</form>
	
</body>
</html>