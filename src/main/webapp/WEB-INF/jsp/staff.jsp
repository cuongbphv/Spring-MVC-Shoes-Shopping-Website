<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Staff Page</title>
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
<script src="<c:url value="/resources/myweb/js/staff.js" />"></script>
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
						<a href="#home"><img class="img-responsive" id="imgLogo"
							src="<c:url value="/resources/myweb/img/logo.png" />" alt=""></a>
					</div>
				</div>

			</div>
		</div>
	</div>

	<div class="staffWrap">
		<!-- modal box -->
		<div class="modal fade" id="myModal" role="dialog"
			style="z-index: 1111111;">
			<div id="orderDetail">
				<!-- ajax callback -->
			</div>
		</div>

		<div class="modal fade" id="billDetailModal" role="dialog"">
			<div id="billDetail">
				<!-- ajax callback -->
			</div>
		</div>



		<!-- ModelBox customer trade -->
		<div class="modal fade" id="customerTradeHistory" role="dialog"
			style="z-index: 111111;">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Xem chi tiết hóa đơn</h4>
					</div>
					<div class="modal-body clearfix">
						<div class="form-group col-md-12">
							<div class="form-group col-md-4">
								<label>Mã khách hàng: </label> <label id="modelHistoryCusID">1</label>
							</div>
							<div class="form-group col-md-4" style="text-align: center">
								<label>Tên khách hàng: </label> <label id="modelHistoryCusName">Nguyễn
									Mạnh Sún</label>
							</div>
							<div class="form-group col-md-4" style="text-align: right">
								<label>Số điện thoại: </label> <label id="modelHistoryPhoneNo">016363636363</label>
							</div>
						</div>

						<div class="form-group col-md-4 cleafix">
							<label for="date" class="col-md-2" style="padding-top: 6px">Từ:
							</label>
							<div class="col-md-10">
								<input class="form-control" id="startDayCustomer" type="date" />
							</div>
						</div>
						<div class="form-group col-md-4">
							<label for="date" class="col-md-2" style="padding-top: 6px">Đến:
							</label>
							<div class="col-md-10">
								<input class="form-control" id="endDayCustomer" type="date" />
							</div>
						</div>

						<div class="table-responsive col-md-12">
							<table class="table table-bordered col-md-12"
								style="text-align: center;">
								<thead>
									<tr>
										<th>Mã ĐH</th>
										<th>Nhân viên</th>
										<th>Giao hàng</th>
										<th>Thành tiền</th>
										<th>Thời gian</th>
										<th>Trạng thái</th>
										<th>Chi tiết</th>
									</tr>
								</thead>
								<tbody id="customerTradeHistoryList">

								</tbody>
							</table>
						</div>


					</div>
					<!--      <div class="modal-footer">
                <div class="col-md-offset-3 col-md-4">
                                <button class="btn-success button-style-update">Xác nhận</button>
                </div>
                <div class="col-md-offset-3 col-md-4">
                                <button class="btn-success button-style-update" data-toggle="modal"
                                				data-target="#customerTradeDetail">Xác</button>
                </div>  -->
				</div>
			</div>
		</div>
	</div>

	<!-- ModelBox customer detail -->
	<div class="modal fade" id="customerDetail" role="dialog"
		style="z-index: 111111;">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Thông tin khách hàng</h4>
				</div>
				<div class="modal-body clearfix">

					<div id="customerInfo" class="col-md-offset-1"></div>

				</div>
				<!--      <div class="modal-footer">
                <div class="col-md-offset-3 col-md-4">
                                <button class="btn-success button-style-update">Xác nhận</button>
                </div>
                <div class="col-md-offset-3 col-md-4">
                                <button class="btn-success button-style-update" data-toggle="modal"
                                				data-target="#customerTradeDetail">Xác</button>
                </div>  -->
			</div>
		</div>
	</div>
	</div>


	<!-- ModelBox customer trade detail -->
	<!--        <div class="modal fade" id="customerTradeDetail" role="dialog"  data-backdrop="static">
        <div class="modal-dialog modal-lg">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Xem chi tiết hóa đơn</h4>
            </div>
            <div class="modal-body">
                 <div class="form-group col-md-12">
                    <div class="form-group col-md-4">
                         <label>Mã hóa đơn:</label>
                         <label>hd1</label>
                     </div>
                     <div class="form-group col-md-4">
                         <label>Mã khách hàng:</label>
                         <label>kh1</label>
                     </div>
                     <div class="form-group col-md-4">
                         <label>Mã nhân viên:</label>
                         <label>nv1</label>
                     </div>
                 </div>
                 <div class="table-responsive col-md-12">
                        <table class="table table-bordered col-md-12" style="text-align: center;">
                            <thead>
                                <tr>
                                    <th>Mã giày</th>
                                    <th>Mã màu</th>
                                    <th>Mã size</th>
                                    <th>Số lượng</th>
                                    <th>Đơn giá</th>
                                    <th>Thành tiền</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th>bitis1g</th>
                                    <th>m1</th>
                                    <th>s1</th>
                                    <th>1</th>
                                    <th>1,000,000</th>
                                    <th>1,000,000</th>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="form-group col-md-4">
                         <label>Mã khuyến mãi:</label>
                         <label>km1</label>
                     </div>
                     <div class="form-group col-md-4">
                         <label>Tiền khuyến mãi:</label>
                         <label>50,000</label>
                     </div>
                     <div class="form-group col-md-4">
                         <label>Tổng đơn hàng:</label>
                         <label>950,000</label>
                     </div>
                            
             </div>
             <div class="modal-footer">
                <div class="col-md-offset-3 col-md-4">
                                <button class="btn-success button-style-update">Xác nhận</button>
                    </div> 
             </div>
           </div>
        </div>
    </div> -->



	<div class="modal fade" id="answerSupportModalBox" role="dialog">

	</div>
	
	<div class="modal fade" id="receiveGuaranteeModalBox" role="dialog">

	</div>
	<!-- end modal box -->

	<div class="header">
		<div class="col-md-offset-9 col-md-3" style="margin-top: 5px;">
			Welcome <a href="${url}"><span style="display: inline;">${headerText}</span></a>,
			<a href="home">Home Page</a> | <a href="logout" class="logout">Logout</a>
		</div>
		<div id="clock_a"></div>
	</div>
	<!-- menu-->
	<div class="home container-fluid">
		<div class="col-xs-12">
			<div class="col-md-3">
				<ul class="nav nav-pills nav-stacked">				
					<li class="active"><a data-toggle="pill" href="#order"><img
							style="padding: 5px;"
							src="<c:url value="/resources/myweb/img/order.png" />"
							alt="no logo">Quản lý đơn hàng</a></li>
					<li><a data-toggle="pill" href="#customer"><img
							style="padding: 5px;"
							src="<c:url value="/resources/myweb/img/customer.png" />"
							alt="no logo">Quản lý khách hàng</a></li>
					<li><a data-toggle="pill" href="#bill"><img
							style="padding: 5px;"
							src="<c:url value="/resources/myweb/img/bill.png" />"
							alt="no logo">Quản lý hóa đơn</a></li>
					<li><a data-toggle="pill" href="#support"><img
							style="padding: 5px;"
							src="<c:url value="/resources/myweb/img/chat.png" />"
							alt="no logo">Yêu cầu hỗ trợ</a></li>
					<li><a data-toggle="pill" href="#guarantee"><img
							style="padding: 5px;"
							src="<c:url value="/resources/myweb/img/guarantee.png" />"
							alt="no logo">Thông tin bảo hành</a></li>
				</ul>
			</div>
			<!-- panel-->
			<div class="tab-content">				
				<div id="order" class="tab-pane fade in active">
					<h3>Quản lý danh sách đơn hàng</h3>
					<div class="form-group col-md-6">

						<div class="col-md-4">
							<select id="slbSearchOrder" class="form-control">
								<option value="DH">Mã đơn hàng</option>
								<option value="KH">Mã khách hàng</option>
								<option value="NV">Mã nhân viên</option>
							</select>
						</div>

						<div class="col-md-6">
							<input id="searchOrderInput" class="form-control" type="text"
								placeholder="Nhập nội dung tìm kiếm">
						</div>

						<!--                <div class = "col-md-2">
                        <button id="btnSearchOrder" class="btn button-style btn-primary">Tra cứu</button>
                      </div>  -->
					</div>
					<div class="form-group col-md-2 col-md-offset-1">
						<select id="slbOrderState" class="form-control">
							<option value="TC">Tất cả</option>
							<option value="DCXL">Đang chờ xử lý</option>
							<option value="DXN">Đã xác nhận</option>
							<option value="DGH">Đang giao hàng</option>
							<option value="GH">Đã giao hàng</option>
							<option value="DH">Đã hủy</option>

						</select>
					</div>

					<div id="orderList" class="table-responsive col-md-9">
                        
								
                            
                    </div> 
				</div>
				<div id="customer" class="tab-pane fade ">
					<h3>Quản lý danh sách khách hàng</h3>
					<div class="form-group col-md-6">

						<div class="col-md-4">
							<select id="slbSearchCustomer" class="form-control">
								<option value="TKH">Tên khách hàng</option>
								<option value="MKH">Mã khách hàng</option>
								<option value="SDT">Số điện thoại</option>
							</select>
						</div>

						<div class="col-md-6">
							<input id="searchCustomerInput" class="form-control" type="text"
								placeholder="Nhập nội dung tìm kiếm">
						</div>

						<!--                 <div class = "col-md-2">
                        <button id="btnSearchCustomer" class="btn button-style btn-primary">Tra cứu</button>
                      </div> -->
					</div>

					<div class="form-group col-md-2 col-md-offset-1">
						<select id="slbCustomerType" class="form-control">

						</select>
					</div>

					<div id="customerList" class="table-responsive col-md-9">
                        <!-- AJAX CALLBACK -->

                    </div>
				</div>
				<div id="bill" class="tab-pane fade">
					<h3>Quản lý danh sách hóa đơn</h3>

					<div class="form-group col-md-6">

						<div class="col-md-4">
							<select id="slbSearchBill" class="form-control">
								<option value="MHD">Mã hóa đơn</option>
								<option value="MDH">Mã đơn hàng</option>
								<option value="MKH">Mã khách hàng</option>
								<option value="MNV">Mã nhân viên</option>
							</select>
						</div>

						<div class="col-md-6">
							<input id="searchBillInput" class="form-control" type="text"
								placeholder="Nhập nội dung tìm kiếm">
						</div>

						<!--                 <div class = "col-md-2">
                        <button id="btnSearchCustomer" class="btn button-style btn-primary">Tra cứu</button>
                      </div> -->
					</div>

					<div class="form-group col-md-2 col-md-offset-1">
						<select id="slbBillType" class="form-control">
							<option value="TC">Tất cả</option>
							<option value="CI">Chưa in</option>
							<option value="DI">Đã in</option>
						</select>
					</div>

					<div id="billList" class="table-responsive col-md-9">
                        
                            <!-- AJAX CALLBACK -->

                    </div> 
				</div>				
				<div id="support" class="tab-pane fade ">
					<h3 style="text-align:center;">Quản lý Yêu cầu hỗ trợ</h3>
					<div class="form-group">
						<div class="form-group col-md-9">
							<label class="col-md-1 label-control" style="text-align:right; margin-top:10px;">Từ:</label> 
							<div class="col-md-3">
								<input id="inputFromDate" class="form-control" type="date" value="2013-01-01"> 
							</div>
							<label class="col-md-1 label-control" style="text-align:right; margin-top:10px;">Đến:</label> 
							<div class="col-md-3">
								<input id="inputEndDate" class="form-control" type="date" value="2030-01-01">
							</div>
							<div class="form-group col-md-3 col-md-offset-1">
								<select id="slbSupportState" class="form-control">
									<option value="TC">Tất cả</option>
									<option value="CTL">Chưa trả lời</option>
									<option value="DTL">Đã trả lời</option>
								</select>
							</div>
						</div>
						<div class="table-responsive col-md-9">
							<table class="table table-bordered col-md-12"
								style="text-align: center;">
								<thead>
									<tr>
										<th>Mã hỗ trợ</th>
										<th>Tên khách hàng</th>
										<th>Câu hỏi</th>
										<th>Ngày hỏi</th>
										<th>Trạng thái</th>
										<th>Trả lời</th>
									</tr>
								</thead>
								<tbody id="spList">
									
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div id="guarantee" class="tab-pane fade">
					<h3 style="text-align: center;">Quản lý Thông tin bảo hành</h3>
					<div class="form-group">
						<div class="form-group col-md-9">
							<div class="col-md-3">
								<select id="slbSearchGuarantee" class="form-control">
									<option value="DH">Mã đơn hàng</option>
									<option value="KH">Mã khách hàng</option>
									<option value="PRO">Mã giày</option>
								</select>
							</div>
				
							<div class="col-md-5">
								<input id="searchGuaranteeInput" class="form-control" type="text"
									placeholder="Nhập nội dung tìm kiếm">
							</div>
							<div class="form-group col-md-3 col-md-offset-1">
								<select id="slbGuaranteeState" class="form-control">
									<option value="TC">Tất cả</option>
									<option value="CTL">Chưa trả lời</option>
									<option value="DTL">Đã trả lời</option>
								</select>
							</div>
						</div>
						<div class="table-responsive col-md-9">
							<table class="table table-bordered col-md-12"
								style="text-align: center;">
								<thead>
									<tr>
										<th>Mã bảo hành</th>
										<th>Tên khách hàng</th>
										<th>Mã giày</th>
										<th>Mã đơn hàng</th>
										<th>Lý do bảo hành</th>
										<th>Trạng thái</th>
										<th>Trả lời</th>
									</tr>
								</thead>
								<tbody id="gtList">
									
								</tbody>
							</table>
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