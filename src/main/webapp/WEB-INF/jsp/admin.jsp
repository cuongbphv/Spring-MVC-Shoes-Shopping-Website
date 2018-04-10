<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Admin Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/admin.css" />" type="text/css" />
<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/nav.css" />" type="text/css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.js"></script>



<script src="<c:url value="/resources/myweb/js/import.js" />"
	type="text/javascript" charset="utf-8"></script>
<script src="<c:url value="/resources/myweb/js/admin.js" />"
	type="text/javascript" charset="utf-8"></script>
<script src="<c:url value="/resources/myweb/js/statistic.js" />"
	type="text/javascript" charset="utf-8"></script>
<script>
	function showMenu(i) {
		var x = document.getElementsByClassName('sub-menu')[i];
		x.style.display = 'block';
	}

	function resetMenu() {
		for (var i = 0; i < document.getElementsByClassName('sub-menu').length; i++) {
			var x = document.getElementsByClassName('sub-menu')[i];
			x.style.display = 'none';
		}
		$(this).scrollTop(0);
	}
</script>
</head>

<body onload="LoadPage();" onresize="Resize();"
	style="background-image: url('<c:url value="/resources/myweb/img/background.jpg" />')">
	<hr />
	<div class="headerWrap container-fluid">
		<div class="row">
			<div class="col-xs-3 col-md-4"></div>
			<div class="col-xs-6 col-md-4" style="text-align: center;">
				<div class="logo">
					<div>
						<a href="/VerOne/home"><img class="img-responsive"
							id="imgLogo"
							src="<c:url value="/resources/myweb/img/logo.png" />" alt=""></a>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- modal box -->
	<div class="adminWrap">
		<div class="modal fade" id="addNewStaff" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" style="text-align: center;">Thêm và
							tạo tài khoản nhân viên</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="col-md-12">
							<form id="frmNewStaff" class="form-horizontal"
								action="/VerOne/addStaff" method="POST">
								<div class="form-group col-md-12 ">
									<label class="control-label col-md-4">Mã nhân viên :</label>
									<div class="col-md-8">
										<input name="staffID" class="form-control" type="text"
											required pattern="[A-Za-z0-9]*" max="10">
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label class="control-label col-md-4">Họ tên :</label>
									<div class="col-md-8">
										<input name="staffName" class="form-control" type="text"
											required pattern="[A-Za-z0-9]*" max="50">
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label class="control-label col-md-4">Địa chỉ :</label>
									<div class="col-md-8">
										<input name="staffAddress" class="form-control" type="text"
											required pattern="[A-Za-z0-9]*" max="50">
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label class="control-label col-md-4">Số điện thoại :</label>
									<div class="col-md-8">
										<input name="staffPhoneNumber" class="form-control"
											type="text" required pattern="[0-9]*" max="11">
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label class="control-label col-md-4">Ngày sinh :</label>
									<div class="col-md-8">
										<input name="staffDateofBirth" class="form-control"
											type="date">
									</div>
								</div>
								<div class="form group col-md-12 " style="padding-bottom: 10px;">
									<label class="control-label col-md-4">Giới tính :</label>
									<div class="col-md-8">
										<label class="col-md-offset-1 col-md-3"><input
											type="radio" name="staffGender" value="Nam" checked="checked">Nam</label>
										<label class="col-md-offset-1 col-md-3"><input
											type="radio" name="staffGender" value="Nữ">Nữ</label>
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label class="control-label col-md-4">Tên tài khoản :</label>
									<div class="col-md-8">
										<input name="staffUsername" class="form-control" type="text"
											required pattern="[A-Za-z0-9]*" max="16">
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label class="control-label col-md-4">Mật khẩu :</label>
									<div class="col-md-8">
										<input name="staffPassword" class="form-control"
											type="password" required pattern="[A-Za-z0-9]*" max="16">
									</div>
								</div>
								<div id="selectBoxStaffType" class="form-group col-md-12 ">

								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<div class="col-md-offset-4 col-md-4">
							<button id="submitNewStaff"
								class="btn btn-success button-style-update">Thêm tài
								khoản</button>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="editStaffInfo" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" style="text-align: center;">Chỉnh sửa
							thông tin nhân viên</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="col-md-12">
							<form id="frmStaffInfo" class="form-horizontal"
								action="/VerOne/editStaff" method="POST">
								<div class="form-group col-md-12 ">
									<label class="control-label col-md-4">Mã nhân viên :</label>
									<div class="col-md-8">
										<input name="staffID" id="staffID" class="form-control"
											type="text" required pattern="[A-Za-z0-9]*" max="10"
											readonly="true">
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label class="control-label col-md-4">Họ tên :</label>
									<div class="col-md-8">
										<input name="staffName" id="staffName" class="form-control"
											type="text" required pattern="[A-Za-z0-9]*" max="50">
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label class="control-label col-md-4">Địa chỉ :</label>
									<div class="col-md-8">
										<input name="staffAddress" id="staffAddress"
											class="form-control" type="text" required
											pattern="[A-Za-z0-9]*" max="50">
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label class="control-label col-md-4">Số điện thoại :</label>
									<div class="col-md-8">
										<input name="staffPhoneNumber" id="staffPhoneNumber"
											class="form-control" type="text" required pattern="[0-9]*"
											max="11">
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label class="control-label col-md-4">Ngày sinh :</label>
									<div class="col-md-8">
										<input name="staffDateofBirth" id="staffDateofBirth"
											class="form-control" type="date">
									</div>
								</div>
								<div class="form group col-md-12 " style="padding-bottom: 10px;">
									<label class="control-label col-md-4">Giới tính :</label>
									<div class="col-md-8">
										<label class="col-md-offset-1 col-md-3"><input
											type="radio" name="staffGender" id="staffMale" value="Nam"
											checked="checked">Nam</label> <label
											class="col-md-offset-1 col-md-3"><input type="radio"
											name="staffGender" id="staffFemale" value="Nữ">Nữ</label>
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label class="control-label col-md-4">Tên tài khoản :</label>
									<div class="col-md-8">
										<input name="staffUsername" id="staffUsername"
											class="form-control" type="text" required
											pattern="[A-Za-z0-9]*" max="16" readonly="true"
											value="${username}">
									</div>
								</div>
								<div id="selectBoxStaffTypeEdit" class="form-group col-md-12 ">

								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<div class="col-md-offset-4 col-md-4">
							<button id="submitStaffInfo"
								class="btn btn-primary button-style-update">Chỉnh sửa</button>
						</div>
					</div>
				</div>
			</div>
		</div>



		<div class="modal fade" id="addNewStaffType" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title">Thêm loại nhân viên
							mới</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="col-md-12">
							<div class="form-group col-md-12 ">
								<form id="frmNewMaterial" class="form-horizontal"
									action="/VerOne/addMaterial" method="POST">
									<label id="labelName" class="col-md-5 control-label">Tên
										loại nhân viên mới :</label>
									<div class="col-md-7">
										<input name="name" id="name" class="form-control" type="text"
											minlength="3" maxlength="50" />
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="submitNewStaffType"
							class=" col-md-offset-5 col-md-2 btn btn-success"
							data-dismiss="modal">Thêm</button>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="editStaffTypeModal" role="dialog"></div>

		<!-- modal box material -->

		<div class="modal fade" id="editMaterialModal" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title">Chỉnh sửa thông tin
							chất liệu</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="col-md-12">
							<div class="form-group col-md-12 ">
								<label id="labelID" class="col-md-4 control-label"></label>
								<div class="col-md-8">
									<input id="ID" class="form-control" type="text" readonly="true">
								</div>
							</div>
							<div class="form-group col-md-12 ">
								<label id="labelName" class="col-md-4 control-label"></label>
								<div class="col-md-8">
									<input id="Name" class="form-control" type="text">
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button"
							class=" col-md-offset-5 col-md-2 btn btn-success editMaterial"
							data-dismiss="modal">Lưu</button>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="addMaterialModal" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title">Thêm chất liệu mới</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="col-md-12">
							<div class="form-group col-md-12 ">
								<form id="frmNewMaterial" class="form-horizontal"
									action="/VerOne/addMaterial" method="POST">
									<label id="labelName" class="col-md-4 control-label">Tên
										chất liệu mới :</label>
									<div class="col-md-8">
										<input name="name" id="name" class="form-control" type="text"
											minlength="3" maxlength="50" />
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="submitNewMaterial"
							class=" col-md-offset-5 col-md-2 btn btn-success"
							data-dismiss="modal">Thêm</button>
					</div>
				</div>
			</div>
		</div>

		<!-- end modal box material -->

		<!-- modal box color -->
		<div class="modal fade" id="editColorModal" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title">Chỉnh sửa thông tin
							màu sắc</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="col-md-12">
							<form id="formEditColor" class="form-horizontal" method="POST"
								enctype="multipart/form-data">
								<div class="form-group col-md-12 ">
									<label id="labelID" class="col-md-4 control-label"></label>
									<div class="col-md-8">
										<input name="editColorID" id="editColorID"
											class="form-control" type="text" readonly="true">
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label id="labelName" class="col-md-4 control-label"></label>
									<div class="col-md-8">
										<input name="editColorName" id="editColorName"
											class="form-control" type="text">
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label id="labelName" class="col-md-4 control-label"></label>
									<div id="loadingImageByColor" class="col-md-8"></div>
								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button"
							class=" col-md-offset-5 col-md-2 btn btn-success editColor"
							data-dismiss="modal">Lưu</button>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="addColorModal" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title">Thêm màu sắc mới</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="col-md-12">
							<div class="form-group col-md-12 ">
								<form id="frmAddNewColor" class="form-horizontal" method="POST"
									enctype="multipart/form-data">
									<label id="labelName" class="col-md-4 control-label">Tên
										màu sắc mới :</label>
									<div class="col-md-8">
										<input name="newNameColor" id="newNameColor"
											class="form-control" type="text" minlength="3" maxlength="50" />
									</div>
									<label style="margin-top: 10px;" id="labelName"
										class="col-md-4 control-label">Hình ảnh theo màu :</label>
									<div style="margin-top: 10px;" class="col-md-8">
										<input name="imageByColor" id="imageByColor"
											class="form-control" type="file" accept="image/*" />
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="submitNewColor"
							class=" col-md-offset-5 col-md-2 btn btn-success"
							data-dismiss="modal">Thêm</button>
					</div>
				</div>
			</div>
		</div>
		<!-- end modal box color -->


		<!-- modal box size -->
		<div class="modal fade" id="editSizeModal" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title">Chỉnh sửa thông tin
							kích cỡ</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="col-md-12">
							<div class="form-group col-md-12 ">
								<label id="labelID" class="col-md-4 control-label"></label>
								<div class="col-md-8">
									<input id="ID" class="form-control" type="text" readonly="true">
								</div>
							</div>
							<div class="form-group col-md-12 ">
								<label id="labelName" class="col-md-4 control-label"></label>
								<div class="col-md-8">
									<input id="Name" class="form-control" type="text">
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button"
							class=" col-md-offset-5 col-md-2 btn btn-success editSize"
							data-dismiss="modal">Lưu</button>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="addSizeModal" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title">Thêm kích cỡ mới</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="col-md-12">
							<div class="form-group col-md-12 ">
								<form id="frmNewSize" class="form-horizontal"
									action="/VerOne/addSize" method="POST">
									<label id="labelName" class="col-md-4 control-label">Kích
										cỡ mới :</label>
									<div class="col-md-8">
										<input name="name" id="name" class="form-control" type="text"
											minlength="3" maxlength="50" />
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="submitNewSize"
							class=" col-md-offset-5 col-md-2 btn btn-success"
							data-dismiss="modal">Thêm</button>
					</div>
				</div>
			</div>
		</div>
		<!-- end modal box size -->

		<!-- modal box producer -->
		<div class="modal fade" id="editProducerModal" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title">Chỉnh sửa thông tin
							nhà sản xuất</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="col-md-12">
							<div class="form-group col-md-12 ">
								<label id="labelID" class="col-md-4 control-label"></label>
								<div class="col-md-8">
									<input id="ID" class="form-control" type="text" readonly="true">
								</div>
							</div>
							<div class="form-group col-md-12 ">
								<label id="labelName" class="col-md-4 control-label"></label>
								<div class="col-md-8">
									<input id="Name" class="form-control" type="text" minlength="3"
										maxlength="50">
								</div>
							</div>
							<div class="form-group col-md-12 ">
								<label id="labelAddress" class="col-md-4 control-label"></label>
								<div class="col-md-8">
									<input id="Address" class="form-control" type="text"
										minlength="3" maxlength="150">
								</div>
							</div>
							<div class="form-group col-md-12 ">
								<label id="labelPhoneNumber" class="col-md-4 control-label"></label>
								<div class="col-md-8">
									<input id="PhoneNumber" class="form-control" type="number"
										minlength="3" maxlength="11">
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button"
							class=" col-md-offset-5 col-md-2 btn btn-success editProducer"
							data-dismiss="modal">Lưu</button>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="addProducerModal" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title">Thêm kích cỡ mới</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="col-md-12">
							<form id="frmNewProducer" class="form-horizontal"
								action="/VerOne/addProducer" method="POST">
								<div class="form-group col-md-12 ">
									<label id="labelName" class="col-md-4 control-label">Tên
										NSX mới:</label>
									<div class="col-md-8">
										<input name="name" id="name" class="form-control" type="text"
											minlength="3" maxlength="50" />
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label id="labelAddress" class="col-md-4 control-label">Địa
										chỉ:</label>
									<div class="col-md-8">
										<input id="address" class="form-control" type="text"
											minlength="3" maxlength="150">
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label id="labelPhoneNumber" class="col-md-4 control-label">Số
										điện thoại:</label>
									<div class="col-md-8">
										<input id="phoneNumber" class="form-control" type="number"
											minlength="3" maxlength="11">
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="submitNewProducer"
							class=" col-md-offset-5 col-md-2 btn btn-success"
							data-dismiss="modal">Thêm</button>
					</div>
				</div>
			</div>
		</div>

		<!-- end modal box producer -->

		<!-- modal box product type -->
		<div class="modal fade" id="editProductTypeModal" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title">Chỉnh sửa thông tin
							loại sản phẩm</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="col-md-12">
							<div class="form-group col-md-12 ">
								<label id="labelID" class="col-md-4 control-label"></label>
								<div class="col-md-8">
									<input id="ID" class="form-control" type="text" readonly="true">
								</div>
							</div>
							<div class="form-group col-md-12 ">
								<label id="labelName" class="col-md-4 control-label"></label>
								<div class="col-md-8">
									<input id="Name" class="form-control" type="text">
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button"
							class=" col-md-offset-5 col-md-2 btn btn-success editProductType"
							data-dismiss="modal">Lưu</button>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="addProductTypeModal" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title">Thêm loại sản phẩm
							mới</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="col-md-12">
							<div class="form-group col-md-12 ">
								<form id="frmNewProductType" class="form-horizontal"
									action="/VerOne/addProductType" method="POST">
									<label id="labelName" class="col-md-4 control-label">Loại
										sản phẩm mới :</label>
									<div class="col-md-8">
										<input name="name" id="name" class="form-control" type="text"
											minlength="3" maxlength="50" />
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="submitNewProductType"
							class=" col-md-offset-5 col-md-2 btn btn-success"
							data-dismiss="modal">Thêm</button>
					</div>
				</div>
			</div>
		</div>

		<!-- end modal box product type -->

		<div class="modal fade" id="updatePriceModalBox" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title">Chỉnh sửa giá</h4>
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
											<input name="ID" id="ID" class="form-control" type="text"
												minlength="3" maxlength="50" readonly="true" />
										</div>
									</div>
									<div class="form-group">
										<label id="labelName" class="col-md-3 control-label">Tên
											giày :</label>
										<div class="col-md-7">
											<input name="Name" id="Name" class="form-control" type="text"
												minlength="3" maxlength="50" readonly="true" />
										</div>
									</div>
									<div class="form-group">
										<label id="labelName" class="col-md-3 control-label">Giá
											:</label>
										<div class="col-md-7">
											<input name="newPrice" id="newPrice" class="form-control"
												type="text" minlength="3" maxlength="50" />
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="submitNewPrice"
							class=" col-md-offset-5 col-md-3 btn btn-success"
							data-dismiss="modal">Lưu thay đổi</button>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="updateDiscountModalBox" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title">Chỉnh sửa giá</h4>
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
											<input name="ID" id="ID" class="form-control" type="text"
												minlength="3" maxlength="50" readonly="true" />
										</div>
									</div>
									<div class="form-group">
										<label id="labelName" class="col-md-3 control-label">Tên
											giày :</label>
										<div class="col-md-7">
											<input name="Name" id="Name" class="form-control" type="text"
												minlength="3" maxlength="50" readonly="true" />
										</div>
									</div>
									<div class="form-group">
										<label id="labelName" class="col-md-3 control-label">Giảm
											giá :</label>
										<div class="col-md-7">
											<input name="newDiscount" id="newDiscount"
												class="form-control" type="text" minlength="3"
												maxlength="50" />
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="submitNewDiscount"
							class=" col-md-offset-5 col-md-3 btn btn-success"
							data-dismiss="modal">Lưu thay đổi</button>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="detailShoeModalBox" role="dialog"></div>

		<div class="modal fade" id="editShoeModalBox" role="dialog"></div>

		<div class="modal fade" id="editProductImageModalBox" role="dialog">

		</div>
		<div class="modal fade" id="ImportDetailModalBox" role="dialog">

		</div>

		<div class="modal fade" id="AddCustomerTypeModalBox" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title">Thêm loại khách hàng
							mới</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="col-md-12">
							<form id="frmNewCustomerType" class="form-horizontal"
								method="POST">
								<div class="form-group col-md-12 ">
									<label id="labelName" class="col-md-4 control-label">Tên
										loại mới:</label>
									<div class="col-md-8">
										<input id="nameCustomerType" class="form-control" type="text"
											minlength="3" maxlength="50" />
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label id="labelPhoneNumber" class="col-md-4 control-label">Chiết
										khấu:</label>
									<div class="col-md-8">
										<input id="discountCustomerType" class="form-control"
											type="number" minlength="3" maxlength="11">
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label id="labelPhoneNumber" class="col-md-4 control-label">Hạn
										mức thăng cấp:</label>
									<div class="col-md-8">
										<input id="levelMoneyCustomerType" class="form-control"
											type="number" minlength="6">
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="submitNewCustomerType"
							class=" col-md-offset-5 col-md-2 btn btn-success"
							data-dismiss="modal">Thêm</button>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="EditCustomerTypeModalBox" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title">Thêm loại khách hàng
							mới</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="col-md-12">
							<form id="frmEditCustomerType" class="form-horizontal"
								method="POST">
								<div class="form-group col-md-12 ">
									<label id="labelName" class="col-md-4 control-label">Mã
										loại:</label>
									<div class="col-md-8">
										<input id="idCT" class="form-control" type="text"
											minlength="3" maxlength="10" readonly="true" />
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label id="labelName" class="col-md-4 control-label">Tên
										loại mới:</label>
									<div class="col-md-8">
										<input id="nameCT" class="form-control" type="text"
											minlength="3" maxlength="100" />
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label id="labelPhoneNumber" class="col-md-4 control-label">Chiết
										khấu:</label>
									<div class="col-md-8">
										<input id="discountCT" class="form-control" type="number"
											minlength="3" maxlength="5">
									</div>
								</div>
								<div class="form-group col-md-12 ">
									<label id="labelPhoneNumber" class="col-md-4 control-label">Hạn
										mức thăng cấp:</label>
									<div class="col-md-8">
										<input id="levelMoneyCT" class="form-control" type="number"
											minlength="6">
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="submitEditCustomerType"
							class=" col-md-offset-5 col-md-3 btn btn-success"
							data-dismiss="modal">Lưu thay đổi</button>
					</div>
				</div>
			</div>
		</div>
		<!-- end modal box -->

	</div>

	<div class="header">
		<div class="col-md-offset-9 col-md-3" style="margin-top: 5px;">
			Welcome <a href="${url}"><span style="display: inline;">${headerText}</span></a>,
			<a href="home">Home Page</a> | <a href="logout" class="logout">Logout</a>
		</div>
		<div id="clock_a"></div>
	</div>
	<!-- menu-->
	<div class="container-fluid" style="margin-bottom: 10px;">
		<div class="col-xs-12">
			<div class="col-md-3">
				<ul class="nav nav-pills nav-stacked">
					<li class="active" onclick="resetMenu()"><a data-toggle="pill"
						href="#home"><img style="padding: 5px;"
							src="<c:url value="/resources/myweb/img/house.png" />"
							alt="no logo">Trang chủ</a></li>
					<li onclick="resetMenu(); getStaffList();"><a
						data-toggle="pill" href="#staff"><img style="padding: 5px;"
							src="<c:url value="/resources/myweb/img/maid.png" />"
							alt="no logo">Quản lý nhân viên</a></li>
					<li onclick="resetMenu(); getCustomerTypeList();"><a
						data-toggle="pill" href="#customers"><img
							style="padding: 5px;"
							src="<c:url value="/resources/myweb/img/customers.png" />"
							alt="no logo">Quản lý khách hàng</a></li>
					<li onclick="resetMenu();getPromotion();"><a
						data-toggle="pill" href="#discount"><img style="padding: 5px;"
							src="<c:url value="/resources/myweb/img/sale.png" />"
							alt="no logo">Quản lý khuyến mãi</a></li>
					<li onclick="resetMenu(); showMenu(0);getProductList();"><a
						data-toggle="pill" href="#product"><img style="padding: 5px;"
							src="<c:url value="/resources/myweb/img/shoe.png" />"
							alt="no logo">Quản lý sản phẩm</a>
						<ul class="nav nav pills nav-stacked sub-menu">
							<li><a data-toggle="pill" onclick="newProduct();"
								href="#newshoes"><img style="padding: 5px;"
									src="<c:url value="/resources/myweb/img/new.png" />"
									alt="no logo">Thêm sản phẩm mới</a></li>
							<!-- add some thing -->
							<li><a data-toggle="pill" onclick="getProductTypeList();"
								href="#productType"><img style="padding: 5px;"
									src="<c:url value="/resources/myweb/img/productType.png" />"
									alt="no logo">Quản lý loại sản phẩm</a></li>
							<li><a data-toggle="pill" onclick="getSizeList();"
								href="#size"><img style="padding: 5px;"
									src="<c:url value="/resources/myweb/img/size.png" />"
									alt="no logo">Quản lý kích cỡ</a></li>
							<li><a data-toggle="pill" onclick="getColorList();"
								href="#color"><img style="padding: 5px;"
									src="<c:url value="/resources/myweb/img/color.png" />"
									alt="no logo">Quản lý màu sắc</a></li>
							<li><a data-toggle="pill" onclick="getMaterialList();"
								href="#material"><img style="padding: 5px;"
									src="<c:url value="/resources/myweb/img/material.png" />"
									alt="no logo">Quản lý chất liệu</a></li>
							<li><a data-toggle="pill" onclick="getProducerList();"
								href="#producer"><img style="padding: 5px;"
									src="<c:url value="/resources/myweb/img/producer.png" />"
									alt="no logo">Quản lý nhà sản xuất</a></li>
							<!-- end add some thing -->
							<li><a data-toggle="pill" onclick="importShoe();"
								href="#importshoes"><img style="padding: 5px;"
									src="<c:url value="/resources/myweb/img/import.png" />"
									alt="no logo">Quản lý nhập</a></li>
							<li><a data-toggle="pill"
								onclick="getLowStockProductList();" href="#lowStock"><img
									style="padding: 5px;"
									src="<c:url value="/resources/myweb/img/checkout.png" />"
									alt="no logo">Kiểm tra hết hàng</a></li>
						</ul></li>
					<li onclick="resetMenu()"><a data-toggle="pill"
						onclick="getProductPriceList();" href="#update"><img
							style="padding: 5px;"
							src="<c:url value="/resources/myweb/img/price-tag.png" />"
							alt="no logo">Cập nhật đơn giá</a></li>
					<li onclick="resetMenu(); showMenu(1)"><a data-toggle="pill"
						href="#statistic"><img style="padding: 5px;"
							src="<c:url value="/resources/myweb/img/budget.png" />"
							alt="no logo">Thống kê cửa hàng</a>
						<ul class="nav nav pills nav-stacked sub-menu">
							<li><a data-toggle="pill"
								onclick="firstLoad();statisticByID(0);" href="#sta-income"><img
									style="padding: 5px;"
									src="<c:url value="/resources/myweb/img/income-chart.png" />"
									alt="no logo">Thống kê doanh thu</a></li>
							<li><a data-toggle="pill" onclick="getImportList();"
								href="#sta-import"><img style="padding: 5px;"
									src="<c:url value="/resources/myweb/img/delivery-truck.png" />"
									alt="no logo">Thống kê nhập hàng</a></li>
						</ul></li>
					<li onclick="resetMenu();"><a data-toggle="pill"
						href="#settings"><img style="padding: 5px;"
							src="<c:url value="/resources/myweb/img/settings.png" />"
							alt="no logo">Cài đặt bổ sung</a></li>
				</ul>
			</div>
			<!-- panel-->
			<div class="tab-content">
				<div id="home" class="tab-pane fade in active">
					<div class="col-md-9" style="margin-top: 5px;">
							<div class="form-group col-md-4 cleafix">
								<label for="date" class="col-md-2" style="padding-top: 6px">Từ:
								</label>
								<div class="col-md-10">
									<input class="form-control" id="startDayLog" type="date" />
								</div>
							</div>
							
							<div class="form-group col-md-4">
								<label for="date" class="col-md-2" style="padding-top: 6px">Đến:
								</label>
								<div class="col-md-10">
									<input class="form-control" id="endDayLog" type="date" />
								</div>
							</div>
							
							<div class="form-group col-md-4">
								<label for="date" class="col-md-2" style="padding-top: 6px">Tìm:
								</label>
								<div class="col-md-10">
									<input class="form-control" id="inputSearchLog" type="text" placeholder="Nội dung tìm kiếm"/>
								</div>
							</div>
							
							
							
							<div style="height:400px; overflow:auto;" class="logsWrapper col-xs-12">
								
								<div style="text-align:center;font-weight:bold;border-bottom:2px solid #c0c0c0; padding-bottom:5px;" 
								class="logHeader col-sm-12">
									<div style="border-right:1px solid #c0c0c0;" class="col-sm-3">Thời gian</div>
									<div class="col-sm-9">Nội dung</div>
								</div>
								
								<div id="logContent">
									
						
								</div>
							</div>
					
					</div>
				</div>
				<div id="staff" class="tab-pane fade">
					<h3 style="text-align: center;">Quản lý nhân viên cửa hàng</h3>
					<div class="form-group col-md-9">
						<div class="col-md-3" style="margin-top: 5px;">
							<select id="slbStaffSearch" class="form-control">
								<option value="NVTNV">Tên nhân viên</option>
								<option value="NVMNV">Mã nhân viên</option>
								<option value="NVDC">Địa chỉ</option>
								<option value="NVSDT">Số điện thoại</option>
							</select>
						</div>
						<div class="col-md-5">
							<input id="inputStaffSearch" type="text" class="form-control"
								placeholder="Nhập thông tin tìm kiếm" required />
						</div>
						<div class="form-group col-md-3 col-md-offset-1">
							<select id="slbStaffTypeSort" class="form-control">
								<option value="0">Tất cả</option>
								<c:forEach items="${listStaffType}" var="itemStaffType">
									<option value="${itemStaffType.maLoaiNV }">${itemStaffType.tenLoaiNV }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div id="loadListStaff" class="col-md-9"></div>
				</div>
				<div id="discount" class="tab-pane fade">
					<h3 style="text-align: center;">Quản lý khuyến mãi cửa hàng</h3>
					<div class="form-group col-md-9">
						<label class="col-md-1 label-control"
							style="text-align: right; margin-top: 8px;">Từ:</label>
						<div class="col-md-3">
							<input id="inputFromDatePromotion" class="form-control"
								type="date" value="2013-01-01">
						</div>
						<label class="col-md-1 label-control"
							style="text-align: right; margin-top: 8px;">Đến:</label>
						<div class="col-md-3">
							<input id="inputEndDatePromotion" class="form-control"
								type="date" value="2030-01-01">
						</div>
						<div class="form-group col-md-3 col-md-offset-1">
							<select id="slbPromotionState" class="form-control">
								<option value="KMTC">Tất cả</option>
								<option value="KMCH">Còn hạn sử dụng</option>
								<option value="KMHH">Hết hạn sử dụng</option>
							</select>
						</div>
					</div>
					<div class="col-md-9 form-group">
						<form id="frmNewPromotion"
							class="form-horizontal form-detail col-md-12" method="POST">
							<div class="col-md-9 form-group">
								<label class="col-md-offset-1 col-md-4">Mã khuyến mãi :</label>
								<div class="col-md-7">
									<input id="discountID" name="ID" class="form-control"
										type="text" pattern="[A-Za-z0-9]*" minlength="3"
										maxlength="10" required>
								</div>
							</div>
							<div class="col-md-9 form-group">
								<label class="col-md-offset-1 col-md-4">Tên khuyến mãi :</label>
								<div class="col-md-7">
									<input id="discountName" name="name" class="form-control"
										type="text" minlength="3" maxlength="50" required>
								</div>
							</div>
							<div class="col-md-9 form-group ">
								<label class="col-md-offset-1 col-md-4">% khuyến mãi :</label>
								<div class="col-md-7">
									<input id="discountPercent" name="percent" class="form-control"
										type="number" required>
								</div>
							</div>
							<div class="col-md-9 form-group ">
								<label class="col-md-offset-1 col-md-4">Thời gian bắt
									đầu :</label>
								<div class="col-md-7">
									<input id="discountStartDate" name="startTime"
										class="form-control" type="date" required>
								</div>
							</div>
							<div class="col-md-9 form-group">
								<label class="col-md-offset-1 col-md-4">Thời gian kết
									thúc :</label>
								<div class="col-md-7">
									<input id="discountEndDate" name="endTime" class="form-control"
										type="date" required>
								</div>
							</div>

							<div class="col-md-offset-5 col-md-4">
								<button type="button" id="submitNewPromotion"
									class="btn btn-success button-style-update">Thêm
									khuyến mãi</button>
							</div>

						</form>




						<div id="showPromotion" style="padding-top: 20px;"
							class="table-responsive col-md-12"></div>
					</div>
				</div>
				<!-- add something-->
				<div id="productType" class="tab-pane fade ">
					<h3 style="">Không thể load dữ liệu</h3>
				</div>
				<div id="size" class="tab-pane fade ">
					<h3 style="">Không thể load dữ liệu</h3>
				</div>

				<div id="color" class="tab-pane fade ">
					<h3 style="text-align: center;">Quản lý màu sắc</h3>
					<div class="form-group col-md-9">
						<div class="col-md-3" style="margin-top: 5px;">
							<select id="slbColorSearch" class="form-control">
								<option value="TMS">Tên màu</option>
								<option value="MMS">Mã màu</option>
							</select>
						</div>
						<div class="col-md-6">
							<input id="inputColorSearch" type="text" class="form-control"
								placeholder="Nhập thông tin tìm kiếm" required />
						</div>
						<button data-toggle="modal" data-target="#addColorModal"
								class="btn btn-success col-md-offset-1 col-md-2">Thêm</button>
					</div>
					<div id="loadListColor" class="form-group col-md-9"></div>
				</div>

				<div id="material" class="tab-pane fade ">
					<h3 style="">Không thể load dữ liệu</h3>
				</div>
				<div id="producer" class="tab-pane fade ">
					<h3 style="">Không thể load dữ liệu</h3>
				</div>
				<!-- end add something -->
				<div id="product" class="tab-pane fade ">
					<h3 style="text-align: center;" class="col-md-9">Quản lý sản
						phẩm cửa hàng</h3>
					<div class="form-group col-md-9">
						<label style="text-align: right;" class="control-label col-md-2">Chất
							Liệu</label>
						<div class="form-group col-md-2">
							<select id="slbMaterialSort" class="form-control">
								<option value="0">Tất cả</option>
								<c:forEach items="${listMaterialP}" var="itemMaterial">
									<option value="${itemMaterial.iD }">${itemMaterial.name }</option>
								</c:forEach>
							</select>
						</div>
						<label style="text-align: right;" class="control-label col-md-2">Nhà
							sản xuất</label>
						<div class="form-group col-md-2">
							<select id="slbProducerSort" class="form-control">
								<option value="0">Tất cả</option>
								<c:forEach items="${listProducerP}" var="itemProducer">
									<option value="${itemProducer.iD }">${itemProducer.name }</option>
								</c:forEach>
							</select>
						</div>
						<label style="text-align: right;" class="control-label col-md-2">Loại
							Giày</label>
						<div class="form-group col-md-2">
							<select id="slbProductTypeSearch" class="form-control">
								<option value="0">Tất cả</option>
								<c:forEach items="${listProductTypeP}" var="itemProductType">
									<option value="${itemProductType.iD }">${itemProductType.name }</option>
								</c:forEach>
							</select>
						</div>
						<label style="text-align: right;" class="control-label col-md-2">Tìm
							kiếm</label>
						<div class="col-md-2">
							<select id="slbProductSearch" class="form-control"
								style="margin-top: 5px;">
								<option value="TKMSP">Mã sản phẩm</option>
								<option value="TKTSP">Tên sản phẩm</option>
								<option value="TKG">Giá</option>
								<option value="TKGG">Giảm giá</option>
							</select>
						</div>
						<div class="col-md-4">
							<input id="inputProductSearch" class="form-control" type="text">
						</div>
					</div>
					<div id="loadProductList" class="table-responsive col-md-9 ">
						
					</div>
				</div>
				<div style="text-align: left;" id="newshoes" class="tab-pane fade">
					<h3 style="text-align: center;" class="col-md-9">Thêm sản phẩm
						mới</h3>
					<form id="frmNewShoe" class="form-horizontal col-md-9"
						action="/VerOne/addProductAD" method="POST"
						enctype="multipart/form-data">
						<div class="col-md-9 form-group">
							<label class="col-md-4 control-label">Mã sản phẩm :</label>
							<div class="col-md-8">
								<input id="addID" type="text" name="iD" class="form-control"
									pattern="[A-Za-z0-9]*" required>
							</div>
						</div>
						<div class="col-md-9 form-group">
							<label class="col-md-4 control-label">Tên sản phẩm :</label>
							<div class="col-md-8">
								<input id="addName" type="text" name="name" class="form-control"
									required>
							</div>
						</div>
						<div id="newShoesProducer" class="col-md-9 form-group"></div>
						<div id="newShoesMaterial" class="col-md-9 form-group"></div>
						<div class="col-md-9 form-group">
							<label class="col-md-4 control-label">Giá :</label>
							<div class="col-md-8">
								<input id="addPrice" type="number" name="price"
									class="form-control" min="0" required>
							</div>
						</div>
						<div class="col-md-9 form-group">
							<label class="col-md-4 control-label">Giảm giá :</label>
							<div class="col-md-8">
								<input id="addDiscount" type="number" name="discount"
									class="form-control" min="0" max="100" required>
							</div>
						</div>
						<div id="newShoesType" class="col-md-9 form-group"></div>
						<div class="col-md-9 form-group">
							<label class="col-md-4 control-label">Hình đại diện :</label>
							<div class="col-md-8">
								<input id="addImg" type="file" name="image" accept="image/*"
									class="form-control" required />
							</div>
						</div>
						<div class="col-md-9 form-group">
							<label class="col-md-4 control-label">Mô tả :</label>
							<div class="col-md-8">
								<textarea id="addDescription" name="description" type="text"
									class="form-control" rows="5" required></textarea>
							</div>
						</div>

					</form>

					<div class="col-md-9 form-group" id="addColor">
						<form class="colorItem" enctype="multipart/form-data"
							method='POST'>
							<input id="prID" type="hidden" name="prID"> <label
								class="col-md-3 control-label"
								style="text-align: right; margin-right: -10px;">Màu sắc
								:</label>
							<div class="col-md-2">
								<select id="getColorForInsertImage"
									class="form-control colorItemID" name="colorID"
									style="margin-top: 5px;">
									<option disabled selected hidden value="-1">Màu</option>
									<c:forEach items="${listColor}" var="itemColor">
										<option value="${itemColor.iD}">${itemColor.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-3">
								<input class="form-control imageItem" type="file"
									name="fileSelector" multiple="multiple" accept="image/*" />
							</div>
							<div class="col-md-1">
								<button class="form-control btn btn-danger removeItem"
									type="button" style="margin-top: 5px;">x</button>
							</div>
							<div class="clearfix"></div>
						</form>
					</div>

					<div class="col-md-offset-3 col-md-4">
						<button class="btn btn-primary" id="btnAddColorItem" type="button">Thêm
							màu</button>
						<button id="submitNewShoe"
							class="btn btn-success button-style-update">Thêm sản
							phẩm</button>
					</div>
				</div>
				<div id="importshoes" class="tab-pane fade">
					<h3 style="text-align: center">Quản Lý Nhập Hàng</h3>
					<div class="form-detail-add col-md-9" style="margin-top: 5px;">
						<div class="col-md-9 ">
							<label class="col-md-3">Giày :</label>
							<div id="selectBoxShoeList" class="col-md-9 form-group"></div>
						</div>
						<div class="col-md-9 ">
							<label class="col-md-3">Màu sắc :</label>
							<div id="selectBoxColorList" class="col-md-9 form-group"></div>
						</div>
						<div class="col-md-9 ">
							<label class="col-md-3">Kích cỡ :</label>
							<div id="selectBoxSizeList" class="col-md-9 form-group"></div>
						</div>
						<div class="col-md-9 ">
							<label class="col-md-3">Số lượng :</label>
							<div class="col-md-9 form-group">
								<input id="importNumber" name="importNumber"
									class="col-md-12 form-control" type="number">
							</div>
						</div>
						<div class="col-md-9 ">
							<label class="col-md-3">Đơn giá :</label>
							<div class="col-md-9 form-group">
								<input id="importPrice" name="importPrice"
									class="col-md-12 form-control" type="number">
							</div>
						</div>
						<div class="col-md-offset-5 col-md-4">
							<button id="submitAddImportDetail"
								class="btn btn-success button-style-update">Thêm chi
								tiết nhập</button>
						</div>
					</div>
					<div class="form-detail-add col-md-9" style="margin-top: 5px;">
						<div class="table-responsive col-md-12 ">
							<table id="importTable" class="table table-bordered col-md-12 "
								style="text-align: center;">
								<thead align="center">
									<tr>
										<th>Mã giày</th>
										<th>Tên giày</th>
										<th>Màu sắc</th>
										<th>Kích cỡ</th>
										<th>Số lượng</th>
										<th>Số tiền trả</th>
										<th>Xóa</th>
									</tr>
								</thead>
								<tbody>

								</tbody>
							</table>
						</div>
					</div>
					<div class="col-md-offset-4 col-md-4" style="margin-top: 5px;">
						<button id="submitAddImportBill"
							class="btn btn-success button-style-update">Xác nhận</button>
					</div>
				</div>
				<div id="lowStock" class="tab-pane fade"></div>
				<div id="update" class="tab-pane fade ">
					<h3 style="text-align: center;">Cập nhật giá cho nhiều sản
						phẩm</h3>
					<div class="form-group col-md-9">
						<div class="col-md-3">
							<select id="slbSearchUpdatePrice" class="form-control"
								style="margin-top: 5px;">
								<option value="CNMSP">Mã sản phẩm</option>
								<option value="CNTSP">Tên sản phẩm</option>
								<option value="CNG">Giá</option>
								<option value="CNGG">Giảm giá</option>
							</select>
						</div>
						<div class="col-md-6">
							<input id="inputSearchUpdatePrice" class="form-control"
								type="text">
						</div>
					</div>
					<div class="table-responsive col-md-9 ">
						<table class="table table-bordered col-md-12 ">
							<thead>
								<tr>
									<th>Mã sản phẩm</th>
									<th>Tên sản phẩm</th>
									<th>Giá hiện tại</th>
									<th>Giảm giá hiện tại</th>
									<th>Giá</th>
									<th>Giảm giá</th>
								</tr>
							</thead>
							<tbody id="listUpdatePrice">

							</tbody>
						</table>

					</div>
				</div>
				<div id="statistic" class="tab-pane fade ">
					<h3>Thống kê cửa hàng</h3>
					<div class="form-group"></div>
				</div>

				<div id="sta-income" class="tab-pane fade ">
					<h3 style="text-align: center;">Chi tiết thống kê cửa hàng</h3>
					<div class="form-group col-md-9">
						<div class="form-group col-md-offset-2 col-md-8">
							<select id="slbStatisticRevenue" class="form-control"
								style="margin-top: 5px;">
								<option value="0">Doanh thu 30 ngày theo tháng năm</option>
								<option value="1">Doanh thu trong 12 tháng gần nhất</option>
								<option value="2">Doanh thu các năm qua</option>
								<option value="3">Sản phẩm bán chạy nhất</option>
							</select>
						</div>
					</div>
					<div id="loadMonthYear" class="form-group col-md-9">
						<label style="padding-top: 8px;"
							class="control-label col-md-offset-3 col-md-1">Tháng</label>
						<div class="form-group col-md-2">
							<input id="statisticMonth" class="form-control" type="number"
								value="1" min="1" max="12" />
						</div>
						<label style="padding-top: 8px;" class="control-label col-md-1">Năm</label>
						<div class="form-group col-md-2">
							<input id="statisticYear" class="form-control" type="number"
								value="2017" min="2016" max="2100" />
						</div>
					</div>
					<div id="reloadCanvas" class="form-group col-md-9">
						<canvas id="myChart" width="600" height="300"></canvas>
					</div>
				</div>
				
				
				<div id="sta-import" class="tab-pane fade ">
					<h3 style="text-align: center;">Thống kê nhập sản phẩm cửa
						hàng</h3>
					<div class="form-group col-md-9">
						<label class="col-md-2 label-control"
							style="text-align: right; margin-top: 10px;">Sắp xếp
							theo:</label>
						<div class="col-md-2">
							<select id="sortImport" class="form-control"
								style="margin-top: 5px;">
								<option value="1">Thời gian</option>
								<option value="2">Số lượng</option>
								<option value="3">Tổng tiền</option>
							</select>
						</div>
						<label class="col-md-1 label-control"
							style="text-align: right; margin-top: 10px;">Từ:</label>
						<div class="col-md-3">
							<input id="inputFromDateImport" class="form-control" type="date"
								value="2013-01-01">
						</div>
						<label class="col-md-1 label-control"
							style="text-align: right; margin-top: 10px;">Đến:</label>
						<div class="col-md-3">
							<input id="inputEndDateImport" class="form-control" type="date"
								value="2030-01-01">
						</div>
					</div>
					<div id="loadListImport" class="form-group col-md-9"></div>
				</div>
				<div id="customers" class="tab-pane fade "></div>

				<div id="settings" class="tab-pane fade"></div>
			</div>
		</div>
	</div>

</body>

</html>
