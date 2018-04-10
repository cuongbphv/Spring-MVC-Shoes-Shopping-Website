<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script>
function convertDate(dateOfBirth){
	var temp = dateOfBirth.split("-");
	
	var now = new Date();
	
	return now.getFullYear(temp[0]+"-"+temp[1]+"-"+temp[2]);
}
</script>
</head>
<body>
	<div class="table-responsive col-md-12">
		<table class="table table-bordered col-md-12"
			style="text-align: center;">
			<thead>
				<tr>
					<th>Mã</th>
					<th>Họ tên</th>
					<th>Địa chỉ</th>
					<th>SĐT</th>
					<th>Ngày sinh</th>
					<th>Giới tính</th>
					<th>Chức vụ</th>
					<th>Chi tiết</th>
					<th>Khôi phục</th>
					<th>Xóa</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
						<td>${item.maNV}</td>
						<td>${item.tenNV}</td>
						<td>${item.diaChi}</td>
						<td>${item.soDienThoai}</td>
						<td>${item.ngaySinh}</td>
						<td>${item.gioiTinh}</td>
						<td>${item.tenLoaiNV}</td>
						<td><button data-toggle="modal" data-target="#editStaffInfo"
								class="btn btn-info button-style openEditStaffModal">
								<img src="<c:url value="/resources/myweb/img/info.png" />"
									alt="no-icon" />
							</button></td>
						<td><button id="resetStaffPassword"
								class="btn btn-primary button-style">
								<img src="<c:url value="/resources/myweb/img/restore.png" />"
									alt="no-icon" />
							</button></td>
						<td><button id="deleteStaff"
								class="btn btn-danger button-style">
								<img src="<c:url value="/resources/myweb/img/delete.png" />"
									alt="no-icon" />
							</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="col-md-offset-3 col-md-7">
		<button class="btn btn-success button-style" data-toggle="modal"
			data-target="#addNewStaff">Tạo tài khoản</button>
		<button class="btn btn-success button-style" data-toggle="modal"
			data-target="#addNewStaffType">Tạo loại nhân viên</button>
		<button onclick="getStaffTypeListModal();"
			class="btn btn-primary button-style" data-toggle="modal"
			data-target="#editStaffTypeModal">Sửa loại nhân viên</button>
	</div>
</body>
</html>