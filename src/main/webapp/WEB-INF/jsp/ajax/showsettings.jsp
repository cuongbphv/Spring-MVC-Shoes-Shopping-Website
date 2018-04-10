<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Cài đặt bổ sung</h3>



	<div class="col-md-9" style="margin-top: 5px;">
	
	<c:forEach var="feature" items="${features }">
		<div class="col-sm-12 settingItem" style="vertical-alignment: middle">
			<div class="col-xs-9 form-group">
				<input type="hidden" value="${feature.iD }">
				<label style="line-height: 30px" class="col-xs-6">${feature.name }:</label>
				<div class="col-xs-6">
					<input class="form-control" type="text" value="${feature.value }" readonly>
				</div>
			</div>
			<div style="text-align: right;" class="col-xs-2">
				<a class="btnEditFeature" style="text-align: right; line-height: 40px;">Sửa</a>
			</div>
		</div>
	</c:forEach>

		<div class="col-sm-12 changeBanner settingItem"
			style="vertical-alignment: middle">
			<div class="col-xs-9 form-group">
				<a id="btnChangeBanner"><label style="line-height: 30px"
					class="col-xs-6"> Thay đổi các banner <span
						style="line-height: 30px;"
						class="glyphicon glyphicon-chevron-down"></span>
				</label></a>
			</div>

			<div class="col-sm-12 bannerWrapper">
		<c:forEach var="banner" items="${banners }">
		
				<div class="bannerItem col-xs-12">
					<div class="bannerHeader col-sm-12">
					<form class="frmBanner" enctype="multipart/form-data" method="POST">
						<input name="bannerID" type="hidden" value="${banner.iD }">
						<p style="line-height: 40px" class="col-xs-offset-1 col-xs-3">${banner.name }</p>
						<div class="col-xs-3">
							<input id="files" name="fileSelector" class="form-control" type="file" accept="image/*">
						</div>
						<button style="line-height: 20px; margin-top: 5px;"
							class="btnEditBanner btn btn-primary col-xs-2" type="button">Thay đổi</button>
					</form>
					</div>

					<div class="bannerImg col-sm-12">
							<img class="img-responsive" src="data:image/png;base64,${banner.base64}" alt="${banner.name }">
					</div>
				</div>
		
		</c:forEach>
			</div>

		</div>

		<hr />


	</div>

</body>