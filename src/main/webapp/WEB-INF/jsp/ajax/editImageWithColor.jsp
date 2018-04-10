<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.divider {
	width:500px;
	text-align:center;
}

.divider hr {
	margin-left:auto;
	margin-right:auto;
	width:38%;

}

.left {
	float:left;
}

.right {
	float:right;
}
</style>
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
						<div class="form-group">
							<label id="labelName" class="col-md-3 control-label">Mã
								giày :</label>
							<div class="col-md-7">
								<input id="piProductID" name="piProductID" class="form-control"
									type="text" readonly="true" value="${product.iD}" />
							</div>
						<div class="form-group">
							<label id="labelName" class="col-md-3 control-label" style="margin-top:13px">Tên
								giày :</label>
							<div class="col-md-7">
								<input id="piName" name="piName" class="form-control"
									type="text" style="margin-top: 5px" value="${product.name }" />
							</div>
						</div>
						
						<div class="clearfix" style="padding-top:10px;"></div>
						<div class="divider">
						    <hr class="left"/>Thêm hình ảnh<hr class="right" />
						</div>
						
						<div class="form-group" id="addColor">
								<form class="colorItem" enctype="multipart/form-data"
									method='POST'>
									<input id="prID" type="hidden" name="prID"/> 
									<label class="col-md-3 control-label" style="padding-top:5px;">Màu sắc :</label>
									<div class="col-md-3" style="padding-top:5px;">
										<select id="getColorForInsertImage"
											class="form-control colorItemID" name="colorID">
											<option disabled selected hidden value="-1">Màu</option>
											<c:forEach items="${listColor}" var="itemColor">
												<option value="${itemColor.iD}">${itemColor.name}</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-md-4" style="padding-top:5px;">
										<input class="form-control imageItem" type="file"
											name="fileSelector" multiple="multiple" accept="image/*" />
									</div>
									<div class="col-md-2" style="padding-top:5px;">
										<button class="form-control btn btn-danger removeItem"
											type="button">x</button>
									</div>
									<div class="clearfix"></div>
								</form>
							</div>
							<div class="col-md-offset-3 col-md-7"> 
		                    		<button class="btn btn-primary" id="btnAddColorItem" type = "button">Thêm màu</button>                  		
		                            <button id="submitNewProductImage" class="btn btn-success button-style-update">Lưu thay đổi</button>
		                     </div>
						</div>
						<div class="clearfix"></div>
						<c:forEach items="${listProductImage}" var="itemProductImage">
							<form id="frmEditProductImageDetail" class="form-horizontal"
								method="POST" enctype="multipart/form-data">
								<hr />
								<div class="form-group">
									<input type="hidden" id="piKeyID" name="piKeyID"
										value="${itemProductImage.keyID}" /> <label id="labelName"
										class="col-md-3 control-label">Màu sắc :</label>
									<div id="editShoesType" class="col-md-7">
										<select id="piColorID" name="piColorID" class="form-control">
											<c:forEach items="${listColor}" var="item">
												<option value="${item.iD}"
													${item.iD == itemProductImage.cID ? 'selected' : ''}>
													${item.name}</option>
											</c:forEach>
										</select>
									</div>
									<button id="deleteProductImage" type="button"
										class="col-md-offset-1 col-md-1 btn btn-danger">X</button>
								</div>
								<div class="form-group">
									<label id="labelName" class="col-md-3 control-label">Hình
										ảnh :</label>
									<div class="col-md-7">
										<img id="showProductImage" style="margin-bottom: 5px"
											class="img-responsive"
											src="data:image/png;base64,${itemProductImage.base64}"
											alt="${itemProductImage.pID }"> <input id="piImage"
											type="file" name="piImage" accept="image/*" required />
									</div>
								</div>

								<div class="form-group">
									<button id="editProductImageDetail" type="button"
										class="col-md-offset-5 btn btn-primary">Lưu chỉnh sửa</button>
								</div>
							</form>
						</c:forEach>
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