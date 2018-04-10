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
				<h4 id="modalTitle" class="modal-title">Trả lời yêu cầu hỗ trợ</h4>
			</div>
			<div class="modal-body clearfix">
				<div class="col-md-12">
					<form id="frmReplySupport" class="form-horizontal" method="POST">
						<div class="form-group col-md-12 ">
							<label class="col-md-3 control-label">Mã hỗ trợ:</label>
							<div class="col-md-9">
								<input id="idSP" name="idSP" class="form-control" type="text" minlength="3"
									maxlength="10" readonly="true" value="${sp.iD}" />
							</div>
						</div>
						<div class="form-group col-md-12 ">
							<label class="col-md-3 control-label">Tên khách hàng:</label>
							<div class="col-md-9">
								<input id="nameCusSP" class="form-control" type="text" readonly="true" value="${sp.getCus().name}"/>
								<input id="idCusSP" anme="idCusSP" class="form-control" type="hidden" value="${sp.cusID}"/>
							</div>
						</div>
						<div class="form-group col-md-12 ">
							<label class="col-md-3 control-label">Ngày hỏi:</label>
							<div class="col-md-9">
								<input id="sendDateSP" class="form-control" type="date" readonly="true" value="${sp.sendDate}"/>
							</div>
						</div>
						<div class="form-group col-md-12 ">
							<label class="col-md-3 control-label">Câu hỏi:</label>
							<div class="col-md-9">
								<input id="questionSP" class="form-control" type="text" readonly="true"
									minlength="3" maxlength="100" value="${sp.question}"/>
							</div>
						</div>
						<div class="form-group col-md-12">
							<label class="col-md-3 control-label">Trả lời:</label>
							<div class="col-md-9">
								<textarea type="text" class="form-control"
										style="margin-top: 10px; resize: none;" 
										id="answerSP" name="answerSP" rows="7" wrap="hard">
										<c:choose>        
									         <c:when test = "${sp.answer != null}">${sp.answer}</c:when>									         
									         <c:otherwise>Chưa trả lời</c:otherwise>
      									</c:choose>
								</textarea>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button id="submitAnserSupport" type="button" class="col-md-offset-5 col-md-3 btn btn-success" data-dismiss="modal">Trả lời</button>
			</div>
		</div>
	</div>
</body>
</html>