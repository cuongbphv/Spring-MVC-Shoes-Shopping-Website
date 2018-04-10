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
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 id="modalTitle" class="modal-title">Chỉnh sửa thông tin
					loại nhân viên</h4>
			</div>
			<div class="modal-body clearfix">
				<div id="getStaffTypeListModal" class="col-md-12">
					<div class="form-group col-md-12">
						<div class="table-responsive col-md-12">
							<table class="table table-bordered col-md-12"
								style="text-align: center;">
								<thead>
									<tr>
										<th>Mã loại</th>
										<th>Tên loại</th>
										<th>Chỉnh sửa</th>
										<th>Xóa</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="item">
										<tr>
											<td>${item.maLoaiNV}</td>
											<td>${item.tenLoaiNV}</td>
											<td><c:choose>
													<c:when
														test="${item.maLoaiNV == 1 || item.maLoaiNV == 2 || item.maLoaiNV == 3}">
														<button class="editStaffType btn btn-primary button-style"
															disabled>Chỉnh sửa</button>
													</c:when>
													<c:otherwise>
														<button class="editStaffType btn btn-primary button-style"
															>Chỉnh sửa</button>
													</c:otherwise>
												</c:choose></td>
											<td><button
													class="deleteStaffType btn btn-danger button-style">Xóa</button></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button"
					class=" col-md-offset-5 col-md-2 btn btn-success"
					data-dismiss="modal">Đóng</button>
			</div>
		</div>
	</div>

</body>
</html>