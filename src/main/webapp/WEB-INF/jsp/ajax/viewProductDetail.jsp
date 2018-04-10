<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 id="modalTitle" class="modal-title">Chi tiết sản phẩm</h4>
			</div>
			<div class="modal-body clearfix">
				<div class="col-md-12">
					<div class="form-group col-md-12 ">
						<form id="frmNewMaterial" class="form-horizontal"
							action="/VerOne/addMaterial" method="POST">
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Mã
									giày :</label>
								<div class="col-md-7">
									<input id="pID" class="form-control" type="text" readonly="true"
										value="${product.iD}" />
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Tên
									giày :</label>
								<div class="col-md-7">
									<input id="pName" class="form-control" type="text" readonly="true"
										value="${product.name }" />
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Số
									lượng :</label>
								<div class="col-md-7">
									<input id="pQuantity" class="form-control" type="text" readonly="true"
										value="${product.quantity}" />
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Giá
									:</label>
								<div class="col-md-7">
									<input id="pPrice" class="form-control" type="text" readonly="true"
										value="${product.price}" />
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Giảm
									giá :</label>
								<div class="col-md-7">
									<input id="pDiscount" class="form-control" type="text" readonly="true"
										value="${product.discount}" />
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Chất
									liệu :</label>
								<div class="col-md-7">
									<input id="pMaterialName" class="form-control" type="text" readonly="true"
										value="${product.material.name}" />
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Nhà
									sản xuất :</label>
								<div class="col-md-7">
									<input id="pProducerName" class="form-control" type="text" readonly="true"
										value="${product.producer.name}" />
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Loại
									giày :</label>
								<div class="col-md-7">
									<input id="pProductName" class="form-control" type="text" readonly="true"
										value="${product.productType.name}" />
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Mô
									tả :</label>
								<div class="col-md-7">
									<textarea id="pDescription" class="form-control" type="text" readonly="true"
										>${product.description}</textarea>
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Hình
									ảnh :</label>
								<div class="col-md-7">
									<img class="img-responsive"
										src="data:image/png;base64,${product.base64}"
										alt="${product.name }">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button"
					class=" col-md-offset-5 col-md-3 btn btn-success"
					data-dismiss="modal">Đóng</button>
			</div>
		</div>
	</div>

</body>
</html>