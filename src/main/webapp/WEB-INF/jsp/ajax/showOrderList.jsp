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


	<table class="table table-bordered col-md-12"
		style="text-align: center;">
		<thead>
			<tr>
				<th>Mã</th>
				<th>Khách hàng</th>
				<th>Nhân viên</th>
				<th>Giao hàng</th>
				<th>Thành tiền</th>
				<th>Thời gian</th>
				<th>Trạng thái</th>
				<th>Chi tiết</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="item">
				<tr class="${item.seen ==true?'':'unseen'}">
					<td>${item.iD }</td>
					<td>${item.customer.name }</td>
					<td><c:choose>
							<c:when test="${item.staff != null}">
					${item.staff.tenNV }
				</c:when>
							<c:otherwise>
					Chưa có
				</c:otherwise>
						</c:choose></td>

					<td><c:choose>
							<c:when test="${item.deliver != null}">
					${item.deliver.tenNV }
				</c:when>
							<c:otherwise>
					Chưa có
				</c:otherwise>
						</c:choose></td>

					<!--  		<td>${item.discount.name } <c:if test="${item.discount!=null}"> (-${item.discount.percent }%)
				  </c:if> </td>
		-->

					<td><fmt:formatNumber value="${item.totalPrice}"
							type="currency" currencySymbol="" minFractionDigits="0" /></td>
					<td><fmt:formatDate value="${item.tradeTime}"
							pattern="dd-MM-yyyy - HH:mm" /></td>
					<td>${item.status }</td>
					<td><button
							class="btnViewOrderDetail btn btn-info button-style"
							data-toggle="modal" data-target="#myModal">Xem</button></td>
					<!-- 	<td><button class="btnCancelOrder btn btn-danger button-style">Hủy</button></td>  -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="col-sm-12" style="text-align:center">
	<input id="pageOrderNums" type="hidden" value="${pageNums }"/>
	  <c:if test="${pageNums > 1 }">	
			<ul class="pagination pagination">
				<li class="prevOrder"><a>&#10096;&#10096;</a></li>
			<c:forEach begin="0" end="${pageNums - 1}" varStatus="loop">
			    <li class="pageOrderItem ${loop.index+1 == page?'active':'' } "><a>${loop.index + 1}</a></li>
			</c:forEach>
				<li class="nextOrder"><a>&#10097;&#10097;</a></li>
			</ul>
		</c:if>

	</div>
</body>
</html>