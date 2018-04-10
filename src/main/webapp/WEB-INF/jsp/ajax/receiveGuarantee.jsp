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
				<h4 id="modalTitle" class="modal-title">Thông tin bảo hành</h4>
			</div>
			<div class="modal-body clearfix">
				<div class="col-md-12">
					<form id="frmGuarantee" class="form-horizontal" method="POST">
						<div class="form-group col-md-12 ">
							<label class="col-md-4 control-label">Mã bảo hành:</label>
							<div class="col-md-8">
								<input id="idGT" name="idGT" class="form-control" type="text" minlength="3"
									maxlength="10" readonly="true" value="${guarantee.iD}" />
							</div>
						</div>
						<div class="form-group col-md-12 ">
							<label class="col-md-4 control-label">Tên khách hàng:</label>
							<div class="col-md-8">
								<input id="nameCusSP" class="form-control" type="text" readonly="true" value="${guarantee.getCus().name}"/>
								<input id="idCusSP" anme="idCusSP" class="form-control" type="hidden" value="${guarantee.cusID}"/>
							</div>
						</div>
						<div class="form-group col-md-12 ">
							<label class="col-md-4 control-label">Mã giày:</label>
							<div class="col-md-8">
								<input id="idSP" name="idSP" class="form-control" type="text" minlength="3"
									maxlength="10" readonly="true" value="${guarantee.productID}" />
							</div>
						</div>
						<div class="form-group col-md-12 ">
							<label class="col-md-4 control-label">Mã đơn hàng:</label>
							<div class="col-md-8">
								<input id="idSP" name="idSP" class="form-control" type="text" minlength="3"
									maxlength="10" readonly="true" value="${guarantee.orderID}" />
							</div>
						</div>
						<div class="form-group col-md-12 ">
							<label class="col-md-4 control-label">Lý do bảo hành:</label>
							<div class="col-md-8">
								<textarea class="form-control" readonly="true" rows="5">${guarantee.reason}</textarea>
							</div>
						</div>
						<div class="form-group col-md-12 ">
							<label class="col-md-4 control-label">Ngày nhận BH:</label>
							<div class="col-md-8">
								<input id="sendDateSP" class="form-control" type="date" value="${guarantee.receiveGuarantee }"/>
							</div>
						</div>
						<div class="form-group col-md-12 ">
							<label class="col-md-4 control-label">Ngày trả BH:</label>
							<div class="col-md-8">
								<input id="returnDate" class="form-control" type="date" value="${guarantee.returnGuarantee }"/>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button id="btnSubmitReceiveGuarantee" type="button" class="col-md-offset-3 col-md-3 btn btn-success" 
				data-dismiss="modal">Nhận bảo hành</button>
				<button id="btnSubmitReturnGuarantee" type="button" class="col-md-3 btn btn-primary" 
				data-dismiss="modal">Trả bảo hành</button>
			</div>
		</div>
	</div>
</body>
</html>