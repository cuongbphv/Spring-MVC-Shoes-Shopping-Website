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
				<h4 class="modal-title">Chi tiết hóa đơn</h4>
			</div>
			<div id="print" class="modal-body clearfix">
				<div class="form-group col-md-12">
					<div class="form-group col-md-4">
						<label>Mã hóa đơn:</label> <label>${bill.iD }</label>
					</div>
					<div class="form-group col-md-4">
						<label>Khách hàng:</label> <label>${bill.customer.name }</label>
					</div>
					
					<div class="form-group col-md-4">
						<label>SĐT:</label> <label>${bill.customer.phoneNo }</label>
					</div>
					
					<div class="form-group col-md-6">
						<label>Thời gian đặt hàng:</label> <label><fmt:formatDate
								value="${bill.order.tradeTime}" pattern="dd-MM-yyyy - HH:mm" /></label>
					</div>
					
					<div class="form-group col-md-6">
						<label>Thời gian xác nhận:</label> <label><fmt:formatDate
								value="${bill.tradeTime}" pattern="dd-MM-yyyy - HH:mm" /></label>
					</div>
					
					<div class="form-group col-md-12">
						<label>Địa chỉ:</label> <label>${bill.customer.address }</label>
					</div>
					
<!--					<div class="form-group col-md-4">
						<label>Nhân viên:</label> <label><c:choose>
								<c:when test="${bill.staff != null}">
					${bill.staff.tenNV }
				</c:when>
								<c:otherwise>
					(Chưa có)
				</c:otherwise>
							</c:choose></label>
					</div> -->



			<!-- 		<div class="form-group col-md-4">
						<label>Khuyến mãi:</label> <label>${bill.discount.name }
							<c:if test="${bill.discount!=null}"> (-${bill.discount.percent }%)
				  </c:if> 
						</label>
					</div>  -->


				</div>
				<div class="table-responsive col-md-12">
					<table class="table table-bordered col-md-12"
						style="text-align: center;">
						<thead>
							<tr>
								<th>Giày</th>
								<th>Màu sắc</th>
								<th>Kích cỡ</th>
								<th>Số lượng</th>
								<th>Đơn giá</th>
								<th>Thành tiền</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${billDetail}" var="item">
								<tr>
									<td>${item.product.name}(${item.product.iD})

									</td>

									<td>${item.color.name}</td>
									
									<td>${item.size.name}</td>
									
									<td>${item.quantity}</td>
									
									<td><fmt:formatNumber value="${item.price}"
											type="currency" currencySymbol="" minFractionDigits="0" /></td>
									<td><fmt:formatNumber value="${item.totalPrice}"
											type="currency" currencySymbol="" minFractionDigits="0" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div class="form-group col-md-8 col-md-offset-4 clearfix"
					style="text-align: right;">
					<label style="text-align:right;" class= "col-xs-8 clearfix">Tiền hàng:</label> 
					<label class= "col-xs-4"><fmt:formatNumber
							value="${totalPrice}" type="currency" currencySymbol=""
							minFractionDigits="0" /> VND</label>
				<c:if test="${ck>0}">
					<label style="text-align:right;" class= "col-xs-8">Chiết khấu (${ck}%):</label> 
					<label class= "col-xs-4">- <fmt:formatNumber
							value="${totalPrice*bill.customer.type.discount/100}" type="currency" currencySymbol=""
							minFractionDigits="0" /> VND</label>
				</c:if>
				
				<c:if test="${bill.discount!=null}">
					<label style="text-align:right;" class= "col-xs-8">${bill.discount.name} (${bill.discount.percent}%):</label> 
					<label class= "col-xs-4">- <fmt:formatNumber
							value="${totalPrice*bill.discount.percent/100}" type="currency" currencySymbol=""
							minFractionDigits="0" /> VND</label>
					
				</c:if>		
					
					<label style="text-align:right;" class= "col-xs-8">Tạm tính:</label> 
					<label class= "col-xs-4"><fmt:formatNumber
							value="${totalPrice*(100 - bill.discount.percent - ck)/100}" type="currency" currencySymbol=""
							minFractionDigits="0" /> VND</label>
					
					<label class="col-md-offset-4 col-md-8 clearfix">=============================================</label>
					
					<label style="text-align:right;" class= "col-xs-8">VAT (10%):</label> 
					<label class= "col-xs-4">+ <fmt:formatNumber
							value="${0.1 * totalPrice*(100 - bill.discount.percent - ck)/100}" type="currency" currencySymbol=""
							minFractionDigits="0" /> VND</label>
					
					<label style="text-align:right;" class= "col-xs-8">Tổng (Bao gồm VAT):</label> 
					<label class= "col-xs-4"><fmt:formatNumber
							value="${bill.totalPrice}" type="currency" currencySymbol=""
							minFractionDigits="0" /> VND</label>
				</div>

			</div>
			<div class="modal-footer">
				<div class="col-md-7">
					<button style="padding:10px 30px;" type="button" class="btnPrintDetail btn btn-success button-style-update">In hóa đơn</button>
				</div>

			</div>
		</div>
	</div>




</body>
</html>