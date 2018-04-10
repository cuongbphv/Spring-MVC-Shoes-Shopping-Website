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
		<div class="table-responsive col-md-12">
			<table class="table table-bordered col-md-12"
				style="text-align: center;">
				<thead align="center">
					<tr>
						<th>Mã màu sắc</th>
						<th>Màu sắc</th>
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
									data-target="#editColorModal"
									class="btn btn-primary button-style openEditColor">Chỉnh
									sửa</button></td>
							<td><button class="btn btn-danger button-style deleteColor">Xóa</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-sm-12" style="text-align:center">
			<input id="pageColorNums" type="hidden" value="${pageNums}"/>
		  	<c:if test="${pageNums > 1 }">	
				<ul class="pagination pagination">
					<li class="prevColor"><a>&#10096;&#10096;</a></li>
				<c:forEach begin="0" end="${pageNums - 1}" varStatus="loop">
				    <li class="pageColorItem ${loop.index+1 == page?'active':'' } "><a>${loop.index + 1}</a></li>
				</c:forEach>
					<li class="nextColor"><a>&#10097;&#10097;</a></li>
				</ul>
			</c:if>	
		</div>
</body>
</html>