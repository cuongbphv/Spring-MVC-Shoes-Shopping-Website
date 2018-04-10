<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script>
$(document).ready(function() {
	$(".deleteProduct").click(function(){
		
		debugger;
	    var id = $(this).parent().siblings("td:first-child").text();
	    
	    debugger;
		var xhttp; 
		
		xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		  if (this.readyState == 4 && this.status == 200) {
		   alert(this.responseText);
		  }
		};
		xhttp.open("GET", "deleteProduct/"+id, true);
		xhttp.send();
	});
});
</script>
</head>
<body>

	<table class="table table-bordered col-md-12 "
		style="text-align: center;">
		<thead>
			<tr>
				<th>Mã</th>
				<th>Tên</th>
				<th>Số lượng</th>
				<th>NSX</th>
				<th>Chất liệu</th>
				<th>Giá</th>
				<th>Giảm giá</th>
				<th>Mã loại</th>
				<th>Chi tiết</th>
				<th>Chỉnh sửa</th>
				<th>Hình ảnh</th>
				<th>Xóa</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.iD }</td>
					<td>${item.name}</td>
					<td>${item.quantity }</td>
					<td>${item.getProducer().name }<input type="hidden"
						value="${item.producerID}" /></td>
					<td>${item.getMaterial().name }<input type="hidden"
						value="${item.materialID}" /></td>
					<td><fmt:formatNumber value="${item.price}" type="currency"
							currencySymbol="" minFractionDigits="0" /></td>
					<td>${item.discount }%</td>
					<td>${item.getProductType().name }<input type="hidden"
						value="${item.typeID}" /></td>
					<td><button class="btn btn-info button-style detailProduct"
							data-toggle="modal" data-target="#detailShoeModalBox">
							<img src="<c:url value="/resources/myweb/img/info.png" />"
								alt="no-icon" />
						</button></td>
					<td><button class="btn btn-primary button-style editProduct"
							data-toggle="modal" data-target="#editShoeModalBox">
							<img src="<c:url value="/resources/myweb/img/pencil.png" />"
								alt="no-icon" />
						</button></td>
					<td><button
							class="btn btn-primary button-style editProductImage"
							data-toggle="modal" data-target="#editProductImageModalBox">
							<img src="<c:url value="/resources/myweb/img/picture.png" />"
								alt="no-icon" />
						</button></td>
					<td><button class="btn btn-danger button-style deleteProduct">
							<img src="<c:url value="/resources/myweb/img/delete.png" />"
								alt="no-icon" />
						</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
		<div class="col-sm-12" style="text-align: center">
		<input id="pageProductNums" type="hidden" value="${pageNums }" />
		<c:if test="${pageNums > 1 }">
			<ul class="pagination pagination">
				<li class="prevProduct"><a>&#10096;&#10096;</a></li>
				<c:forEach begin="0" end="${pageNums - 1}" varStatus="loop">
					<li class="pageProductItem ${loop.index+1 == page?'active':'' } "><a
						>${loop.index + 1}</a></li>
				</c:forEach>
				<li class="nextProduct"><a>&#10097;&#10097;</a></li>
			</ul>
		</c:if>
	</div>
</body>
</html>