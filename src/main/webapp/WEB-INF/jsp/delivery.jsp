<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Delivery Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/staff.css" />" type="text/css" />
<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/nav.css" />" type="text/css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>
<script src="<c:url value="/resources/myweb/js/home.js" />"></script>
<script src="<c:url value="/resources/myweb/js/delivery.js" />"></script>
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

	<div class="home deliveryWrap" style="margin-top: 10px; margin-bottom:20px;">

		<div class="modal fade" id="SubmitDeliveryTruckingModalBox" role="dialog">

		</div>
	
		<div class="header">
			<div class="col-md-offset-9 col-md-3" style="margin-top: 5px;">
				Welcome <a href="${url}"><span style="display: inline;">${headerText}</span></a>,
				<a href="home">Home Page</a> | <a href="logout" class="logout">Logout</a>
			</div>
			<div id="clock_a"></div>
		</div>
		<!-- menu-->
		<div class="container-fluid">
			<div class="col-xs-12">
				<div class="col-md-3">
					<ul class="nav nav-pills nav-stacked">
						<li class="active"><a data-toggle="pill"
							href="#deliveryTrucking"><img style="padding: 5px;"
								src="<c:url value="/resources/myweb/img/trucking.png" />"
								alt="no logo">Đơn hàng đang giao</a></li>
						<li><a data-toggle="pill" href="#receiveOrder"><img
								style="padding: 5px;"
								src="<c:url value="/resources/myweb/img/box.png" />"
								alt="no logo">Nhận đơn hàng</a></li>
						<li><a data-toggle="pill" href="#historyDelivery"><img
								style="padding: 5px;"
								src="<c:url value="/resources/myweb/img/package.png" />"
								alt="no logo">Lịch sử giao hàng</a></li>
					</ul>
				</div>
				<!-- panel-->
				<div class="tab-content">
					<div id="deliveryTrucking" class="tab-pane fade in active">
						<h3 style="text-align: center;" class="col-md-9">Danh sách
							đơn hàng đang giao</h3>
						<div class="form-group">
							<div class="form-group col-md-9">
								<div class="col-md-3">
									<select id="slbSearchDeliveryTrucking" class="form-control">
										<option value="DGHDH">Mã đơn hàng</option>
										<option value="DGHKH">Mã khách hàng</option>
										<option value="DGHDC">Địa chỉ</option>
										<option value="DGHSDT">Số điện thoại</option>
									</select>
								</div>
								<div class="col-md-5">
									<input id="searchDeliveryTruckingInput" class="form-control"
										type="text" placeholder="Nhập nội dung tìm kiếm">
								</div>
								<div class="form-group col-md-3 col-md-offset-1">
									<select id="slbDeliveryTruckingState" class="form-control">
										<option value="DGHTC">Tất cả</option>
										<option value="DGHDHMN">Đơn hàng mới nhất</option>
										<option value="DGHDHCN">Đơn hàng cũ nhất</option>
									</select>
								</div>
							</div>
							<div id="lstDeliveryTrucking" class="table-responsive col-md-9 ">
							</div>
						</div>
					</div>
					<div id="receiveOrder" class="tab-pane fade ">
						<h3 style="text-align: center;" class="col-md-9">Danh sách
							đơn hàng chờ giao</h3>
						<div class="form-group">
							<div class="form-group col-md-9">
								<div class="col-md-3">
									<select id="slbSearchDelivery" class="form-control">
										<option value="DH">Mã đơn hàng</option>
										<option value="KH">Mã khách hàng</option>
										<option value="DC">Địa chỉ</option>
										<option value="SDT">Số điện thoại</option>
									</select>
								</div>
								<div class="col-md-5">
									<input id="searchDeliveryInput" class="form-control"
										type="text" placeholder="Nhập nội dung tìm kiếm">
								</div>
								<div class="form-group col-md-3 col-md-offset-1">
									<select id="slbDeliveryState" class="form-control">
										<option value="TC">Tất cả</option>
										<option value="DHMN">Đơn hàng mới nhất</option>
										<option value="DHCN">Đơn hàng cũ nhất</option>
									</select>
								</div>
							</div>
							<div class="table-responsive col-md-9 ">
								<table class="table table-bordered col-md-12 "
									style="text-align: center;">
									<thead>
										<tr>
											<th>Mã đơn hàng</th>
											<th>Tên khách hàng</th>
											<th>Số điện thoại</th>
											<th>Địa chỉ</th>
											<th>Thời gian xuất</th>
											<th>Tổng đơn hàng</th>
											<th>Nhân viên xác nhận</th>
											<th>Nhận giao hàng</th>
										</tr>
									</thead>
									<tbody id="lstOrderDelivery">

									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div id="historyDelivery" class="tab-pane fade">
							<h3 style="text-align: center;" class="col-md-9">Danh sách
							đơn hàng chờ giao</h3>
						<div class="form-group">
							<div class="form-group col-md-9">
								<label class="col-md-1 label-control" style="text-align:right; margin-top:8px;">Từ:</label> 
								<div class="col-md-3">
									<input id="inputFromDateHistory" class="form-control" type="date" value="2013-01-01"> 
								</div>
								<label class="col-md-1 label-control" style="text-align:right; margin-top:8px;">Đến:</label> 
								<div class="col-md-3">
									<input id="inputEndDateHistory" class="form-control" type="date" value="2030-01-01">
								</div>
								<div class="form-group col-md-3 col-md-offset-1">
									<select id="slbDeliveryHistoryState" class="form-control">
										<option value="LSTC">Tất cả</option>
										<option value="LSDGH">Đã giao hàng</option>
										<option value="LSKNH">Không nhận hàng</option>
									</select>
								</div>
							</div>
							<div id="lstDeliveryHistory" class="table-responsive col-md-9 ">
								
							</div>
						</div>
					</div>
				</div>
				<!--            <div class="clearfix visible-lg "></div>-->

			</div>
		</div>
	</div>
</body>
</html>