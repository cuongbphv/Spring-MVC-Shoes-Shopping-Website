<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 id="modalTitle" class="modal-title">Xác nhận hóa đơn</h4>
			</div>
			<div id="printDel" class="modal-body clearfix">
				<div class="col-md-12">
					<div class="form-group col-md-12 ">
						<div class="form-group col-md-12" style="padding-bottom:10px;">
							<div class="form-group col-md-12">
								<label class="control-label col-md-3">Mã đơn hàng:</label>
								<label id="orderID" class="control-label col-md-3">${ord.iD }</label>
							</div>
							<div class="form-group col-md-12">
								<label class="control-label col-md-3">Ngày xuất đơn:</label>
								<label class="control-label col-md-3"><fmt:formatDate value="${ord.tradeTime}" pattern="dd-MM-yyyy - HH:mm" /></label>
							</div>
							<div class="form-group col-md-12">
								<label class="control-label col-md-3">Tên khách hàng:</label>
								<label class="control-label col-md-4">${ord.getCustomer().name }</label>
							</div>
							<div class="form-group col-md-12">
								<label class="control-label col-md-3">Số điện thoại:</label>
								<label class="control-label col-md-3">${ord.getCustomer().phoneNo }</label>
							</div>
							<div class="form-group col-md-12">
								<label class="control-label col-md-3">Địa chỉ:</label>
								<label class="control-label col-md-9">${ord.address}</label>
							</div>
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
											<td>${item.getColor().name }</td>
											<td>${item.getSize().name }</td>
											<td>${item.quantity}</td>
											<td><fmt:formatNumber value="${item.getProduct().price}"
													type="currency" currencySymbol="" minFractionDigits="0" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="form-group col-md-12">
							<label class="control-label col-md-offset-8 col-md-2" style="text-align:right;">Tổng tiền trả:</label>
							<label class="control-label col-md-2"><fmt:formatNumber value="${ord.totalPrice}" type="currency" currencySymbol="" minFractionDigits="0"/></label>
						</div> 
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="printDelivery" type="button" class="col-md-offset-3 col-md-2 btn btn-primary">In đơn giao hàng</button>
				<button id="submitDelivered" type="button" class="col-md-2 btn btn-success" data-dismiss="modal">Xác nhận</button>
				<button id="submitCanceled" type="button" class="col-md-2 btn btn-danger" data-dismiss="modal">Không nhận hàng</button>
			</div>
		</div>
	</div>

</body>
</html>