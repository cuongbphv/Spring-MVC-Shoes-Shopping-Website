<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 id="modalTitle" class="modal-title">Chi tiết nhập hàng</h4>
			</div>
			<div class="modal-body clearfix">
				<div class="col-md-12">
					<div class="form-group col-md-12 ">
						<div class="form-group col-md-12">
							<label class="control-label col-md-3">Mã nhập:</label>
							<label class="control-label col-md-2">${im.importID}</label>
							<label class="control-label col-md-3">Nhân viên nhập:</label>
							<label class="control-label col-md-4">${im.getStaff().tenNV}</label>
							<label class="control-label col-md-3">Thời gian nhập:</label>
							<label class="control-label col-md-3"><fmt:formatDate value="${im.importDate}" pattern="dd-MM-yyyy - HH:mm" /></label>
						</div> 
						<div class="table-responsive col-md-12">
							<table class="table table-bordered col-md-12"
								style="text-align: center;">
								<thead>
									<tr>
										<th>Mã giày</th>
										<th>Tên giày</th>
										<th>Màu sắc</th>
										<th>Kích cỡ</th>
										<th>Số lượng</th>
										<th>Đơn giá</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="item">
										<tr>
											<td>${item.productID}</td>
											<td>${item.getProduct().name}</td>
											<td>
												<c:forEach items="${listColor}" var="colorItem">
														<c:choose>
														    <c:when test="${item.colorID == colorItem.iD}">
														       ${colorItem.name} 
														    </c:when>    
														</c:choose>
												</c:forEach>
											</td>
											<td>
												<c:forEach items="${listSize}" var="sizeItem">
													<c:choose>
														    <c:when test="${item.sizeID == sizeItem.iD}">
														       ${sizeItem.name} 
														    </c:when>    
														</c:choose>
												</c:forEach>
											</td>
											<td>${item.quantity}</td>
											<td><fmt:formatNumber value="${item.price}"
													type="currency" currencySymbol="" minFractionDigits="0" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="form-group col-md-12">
							<label class="control-label col-md-offset-8 col-md-2" style="text-align:right;">Tổng tiền trả:</label>
							<label class="control-label col-md-2"><fmt:formatNumber value="${im.total}" type="currency" currencySymbol="" minFractionDigits="0"/></label>
						</div> 
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class=" col-md-offset-5 col-md-2 btn btn-success" data-dismiss="modal">Đóng</button>
			</div>
		</div>
	</div>

</body>
</html>