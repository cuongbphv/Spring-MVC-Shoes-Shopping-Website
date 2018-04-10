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

	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Chi tiết đơn hàng</h4>
			</div>
			<div class="modal-body clearfix">
				<div class="form-group col-md-12">
					<div class="form-group col-md-4">
						<label>Mã đơn hàng:</label> <label>${order.iD }</label>
					</div>
					<div class="form-group col-md-4">
						<label>Khách hàng:</label> <label>${order.customer.name }</label>
					</div>
					
					<div class="form-group col-md-4">
						<label>SĐT:</label> <label>${order.customer.phoneNo }</label>
					</div>
					
					<div class="form-group col-md-4">
						<label>Nhân viên:</label> <label><c:choose>
								<c:when test="${order.staff != null}">
					${order.staff.tenNV }
				</c:when>
								<c:otherwise>
					(Chưa có)
				</c:otherwise>
							</c:choose></label>
					</div>
					<div class="form-group col-md-4">
						<label>Giao hàng:</label> <label><c:choose>
								<c:when test="${order.deliver != null}">
					${order.deliver.tenNV }
				</c:when>
								<c:otherwise>
					(Chưa có)
				</c:otherwise>
							</c:choose></label>
					</div>
					<div class="form-group col-md-4">
						<label>Thời gian:</label> <label><fmt:formatDate
								value="${order.tradeTime}" pattern="dd-MM-yyyy - HH:mm" /></label>
					</div>

<!-- 					<div class="form-group col-md-4">
						<label>Khuyến mãi:</label> <label>${order.discount.name }
							<c:if test="${order.discount!=null}"> (-${order.discount.percent }%)
				  </c:if>
						</label>
					</div>  -->

					<div class="form-group col-md-12">
						<label>Địa chỉ giao hàng: </label> <label>${order.address }</label>
					</div>

				</div>
				<div class="table-responsive col-md-12">
					<table class="table table-bordered col-md-12"
						style="text-align: center;">
						<thead>
							<tr>
								<th>Giày</th>
								<th>Màu</th>
								<th>Kích cỡ</th>
								<th>Số lượng</th>
								<th>Đơn giá</th>
								<th>Thành tiền</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${orderDetail}" var="item">
								<tr>
									<td>${item.product.name}(${item.product.iD}) <input
										class="orderDetailPID" type="hidden"
										value="${item.product.iD}"> <input
										class="orderDetailOID" type="hidden" value="${order.iD}">
									</td>

									<td><select class="comboboxColor form-control">
											<c:forEach var="color" items="${item.product.colorList}">
												<option ${color.iD == item.color.iD?'selected':''}
													value="${ color.iD }">${color.name}</option>
											</c:forEach>
									</select> <input class="orderDetailCID" type="hidden"
										value="${item.color.iD}"></td>

									<td><select class="comboboxSize form-control">
											<c:forEach var="size" items="${item.product.sizeList}">
												<option ${size.iD == item.size.iD?'selected':''}
													value="${ size.iD }">${size.name}</option>
											</c:forEach>
									</select> <input class="orderDetailSID" type="hidden"
										value="${item.size.iD }"></td>

									<td><input class="orderDetailNewStock form-control"
										type="number" value="${item.quantity }" /> <input
										class="orderDetailStock" type="hidden"
										value="${item.quantity }"></td>
									<td><fmt:formatNumber value="${item.price}"
											type="currency" currencySymbol="" minFractionDigits="0" /></td>
									<td><fmt:formatNumber value="${item.totalPrice}"
											type="currency" currencySymbol="" minFractionDigits="0" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div class="form-group col-md-8 col-md-offset-4"
					style="text-align: right;">
					
					<label style="text-align:right;" class= "col-xs-8 clearfix">Tiền hàng:</label> 
					<label class= "col-xs-4"><fmt:formatNumber
							value="${totalPrice}" type="currency" currencySymbol=""
							minFractionDigits="0" /> VND</label>
				<c:if test="${ck>0}">
					<label style="text-align:right;" class= "col-xs-8">Chiết khấu (${ck }%):</label> 
					<label class= "col-xs-4">- <fmt:formatNumber
							value="${totalPrice*ck/100}" type="currency" currencySymbol=""
							minFractionDigits="0" /> VND</label>
				</c:if>
				
				<c:if test="${order.discount!=null}">
					<label style="text-align:right;" class= "col-xs-8">${order.discount.name} (${order.discount.percent}%):</label> 
					<label class= "col-xs-4">- <fmt:formatNumber
							value="${totalPrice*order.discount.percent/100}" type="currency" currencySymbol=""
							minFractionDigits="0" /> VND</label>
					
				</c:if>		
					
					<label style="text-align:right;" class= "col-xs-8">Tạm tính:</label> 
					<label class= "col-xs-4"><fmt:formatNumber
							value="${totalPrice*(100 - order.discount.percent - ck)/100}" type="currency" currencySymbol=""
							minFractionDigits="0" /> VND</label>
					
					<label class="col-md-offset-4 col-md-8 clearfix">========================================</label>
					
					<label style="text-align:right;" class= "col-xs-8">VAT (10%):</label> 
					<label class= "col-xs-4">+ <fmt:formatNumber
							value="${0.1 * totalPrice*(100 - order.discount.percent - ck)/100}" type="currency" currencySymbol=""
							minFractionDigits="0" /> VND</label>
					
					<label style="text-align:right;" class= "col-xs-8">Tổng (Bao gồm VAT):</label> 
					<label class= "col-xs-4"><fmt:formatNumber
							value="${order.totalPrice}" type="currency" currencySymbol=""
							minFractionDigits="0" /> VND</label>
				</div>

				<div class="col-md-offset-5 col-md-7">
					<button  ${blockConfirm==1?'disabled':'' }
						class="btnSubmitChangeOrderDetail btn btn-primary button-style-update">Cập
						nhật thay đổi</button>
				</div>
			</div>
			<div class="modal-footer">
				<div class="col-md-offset-3 col-md-2">
					<button id="btnCancelOrder" ${blockCancel==1?'disabled':'' }
						class="btn btn-danger button-style-update" data-dismiss="modal">Hủy
						đơn hàng</button>
				</div>
				<div class="col-md-offset-1 col-md-3">
					<button id="btnConfirmOrder" ${blockConfirm==1?'disabled':'' }
						class="btn btn-success button-style-update" data-dismiss="modal">Xác
						nhận</button>
				</div>

			</div>
		</div>
	</div>




</body>
</html>