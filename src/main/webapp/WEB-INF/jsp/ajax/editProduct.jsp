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
				<h4 id="modalTitle" class="modal-title">Chỉnh sửa sản phẩm</h4>
			</div>
			<div class="modal-body clearfix">
				<div class="col-md-12">
					<div class="form-group col-md-12 ">
						<form id="frmEditProduct" class="form-horizontal" action="/VerOne/editProductDetail" method="POST" enctype="multipart/form-data">
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Mã
									giày :</label>
								<div class="col-md-7">
									<input id="pProductID" name="pProductID" class="form-control" type="text" readonly="true"
										value="${product.iD}" />
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Tên
									giày :</label>
								<div class="col-md-7">
									<input id="pName" name="pName" class="form-control" type="text"
										value="${product.name }" />
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Số
									lượng :</label>
								<div class="col-md-7">
									<input id="pQuantity" name="pQuantity" class="form-control" type="text" readonly="true"
										value="${product.quantity}" />
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Giá
									:</label>
								<div class="col-md-7">
									<input id="pPrice" name="pPrice" class="form-control" type="text"
										value="${product.price}" />
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Giảm
									giá :</label>
								<div class="col-md-7">
									<input id="pDiscount" name="pDiscount" class="form-control" type="text"
										value="${product.discount}" />
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Chất
									liệu :</label>
								<div id="editShoesMaterial" class="col-md-7">
									<select id="pMaterialID" name="pMaterialID" class="form-control">
										<option disabled selected hidden value="7">Chọn chất liệu</option>
																				
											<c:forEach items="${list}" var="item">
												 <option value="${item.iD}" ${item.iD == mID ? 'selected' : ''}> ${item.name}</option>    		
											</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Nhà
									sản xuất :</label>
								<div id="editShoesProducer" class="col-md-7">
									<select id="pProducerID" name="pProducerID" class="form-control">
											<option disabled selected hidden value="7">Chọn nhà sản xuất</option>
											
											<c:forEach items="${list1}" var="item1">
											    <option value="${item1.iD}" ${item1.iD == pID ? 'selected' : ''}> ${item1.name}</option>
											</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Loại
									giày :</label>
								<div id="editShoesType" class="col-md-7">
									<select id="pProductTypeID" name="pProductTypeID" class="form-control">
											<option disabled selected hidden value="7">Chọn loại giày</option>
											
											<c:forEach items="${list2}" var="item2">
											    <option value="${item2.iD}" ${item2.iD == ptID ? 'selected' : ''}> ${item2.name}</option>
											</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Mô
									tả :</label>
								<div class="col-md-7">
									<textarea id="pDescription" name="pDescription" class="form-control" type="text"
										>${product.description}</textarea>
								</div>
							</div>
							<div class="form-group">
								<label id="labelName" class="col-md-3 control-label">Hình
									ảnh :</label>
								<div class="col-md-7">
									<img style="margin-bottom:5px" class="img-responsive"
										src="data:image/png;base64,${product.base64}"
										alt="${product.name }">
									<input id="pImage" type="file" name="pImage" accept="image/*" required/>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="submitEditProduct" type="button" class=" col-md-offset-5 col-md-3 btn btn-success" 
						data-dismiss="modal">Lưu thay đổi</button>
			</div>
		</div>
	</div>

</body>
</html>