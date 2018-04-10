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
				<h4 id="modalTitle" class="modal-title">Thêm loại khách hàng
					mới</h4>
			</div>
			<div class="modal-body clearfix">
				<div class="col-md-12">
					<form id="frmEditStaffType" class="form-horizontal"
						method="POST">
						<div class="form-group col-md-12 ">
							<label id="labelName" class="col-md-4 control-label">Mã
								loại:</label>
							<div class="col-md-8">
								<input id="idST" class="form-control" type="text" minlength="3"
									maxlength="10" readonly="true" value="${id}" />
							</div>
						</div>
						<div class="form-group col-md-12 ">
							<label id="labelName" class="col-md-4 control-label">Tên
								loại mới:</label>
							<div class="col-md-8">
								<input id="nameST" class="form-control" type="text"
									minlength="3" maxlength="100" value="${name}"/>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button onclick="getStaffTypeListModal();" type="button"
					class=" col-md-offset-3 col-md-3 btn btn-default" >Quay lại</button>
				<button type="button" id="submitEditStaffType"
					class="col-md-3 btn btn-success"
					data-dismiss="modal">Lưu thay đổi</button>
			</div>
		</div>
	</div>
</body>
</html>