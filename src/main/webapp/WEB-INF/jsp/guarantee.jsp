<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.mvp.model.Account" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/nav.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/footer.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/profile.css" />">
<link href="https://fonts.googleapis.com/css?family=Lora"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans"
	rel="stylesheet">
<script src="<c:url value="/resources/myweb/js/nav.js" />"
	type="text/javascript" charset="utf-8"></script>
<script src="<c:url value="/resources/myweb/js/home.js" />"
	type="text/javascript" charset="utf-8"></script>
<script src="<c:url value="/resources/myweb/js/guarantee.js" />"
	type="text/javascript" charset="utf-8"></script>
<script>
	$(document)
			.ready(
					function() {
						var linktext = $('.dropbtn').text();
						if (linktext == "Đăng nhập/Đăng ký") {
							$('.dropdown')
									.hover(
											function() {
												document
														.getElementsByClassName("dropdown-content").style.display = "none";
											},
											function() {
												document
														.getElementsByClassName("dropdown-content")[0].style.display = "none";
											});
						} else {
							$('.dropdown')
									.hover(
											function() {
												document
														.getElementsByClassName("dropdown-content")[0].style.display = "block";
											},
											function() {
												document
														.getElementsByClassName("dropdown-content")[0].style.display = "none";
											});
						}
					});
</script>
<style>
/* Dropdown Button */
.dropbtn {
	background-color: white;
	color: black;
	padding: 16px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
	position: relative;
	display: inline-block;
	float: right;
	margin-top: 5px;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
	display: none;
	position: fixed;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {
	background-color: #fff;
	color: blue;
}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
	display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {
	background-color: #fff;
}

.dropdown-content .manage {
	display: none;
}
</style>
<title>Bảo hành</title>
</head>

<body onload="LoadPage()" onresize="Resize()"
	style="background-image: url('<c:url value="/resources/myweb/img/background.jpg" />');">

	<div class="headerWrap container-fluid">
		<div class="row">
			<div class="col-xs-3 col-md-4">
				<div id="expands" onclick="showNav()">
					<span class="glyphicon glyphicon-menu-hamburger"></span>
				</div>
			</div>
			<div class="col-xs-6 col-md-4" style="text-align: center;">
				<div class="logo">
					<div>
						<a href="/VerOne/home"><img class="img-responsive"
							id="imgLogo"
							src="<c:url value="/resources/myweb/img/logo.png" />" alt=""></a>
					</div>
				</div>

			</div>
			<div class="col-xs-3 col-md-4">
				<a href="/VerOne/cart" style="float: right"><img id="cart"
					src="<c:url value="/resources/myweb/img/cart.png" />"
					style="width: 32px;" alt=""> <span id="numItems"
					style="padding-right: 20px"></span></a>
				<div class="dropdown" >
						 <a href="${url}" class="dropbtn"><span style="display:inline;">${headerText}</span></a>
						  <div class="dropdown-content" style="display:none;">
							<a href="/VerOne/profile">Quản lý tài khoản</a>
							<a href="/VerOne/orderinfo">Xem đơn hàng</a>
							<a href="/VerOne/logout">Đăng xuất</a>
						  </div>
					 </div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="row navi" style="padding: 10px 0 0 0;">
			<div class="col-md-12">
				<nav class="navWrapper">
					<ul class="navList">
					<%Account pq = (Account)session.getAttribute("user");
					if(pq!=null){
						if(pq.getPhanQuyen() == 1){	%>
						<li class="item"><a href="/VerOne/admin">QUẢN LÝ</a></li>
					<%}
						else if(pq.getPhanQuyen() == 2){
					%>
						<li class="item"><a href="/VerOne/staff">BÁN HÀNG</a></li>
					<%}
						else if(pq.getPhanQuyen() == 3){
					%>
						<li class="item"><a href="/VerOne/delivery">GIAO HÀNG</a></li>
					<%}} %>
							<li class="item"><a href="/VerOne/shopping">DANH MỤC</a></li>
							<li class="item"><a href="/VerOne/shopping/hotproduct">NỔI BẬT</a></li>
							<li class="item"><a href="/VerOne/shopping/hotsaleproduct">BÁN CHẠY</a></li>
							<li class="item"><a href="/VerOne/shopping/discountproduct">GIẢM GIÁ</a></li>
							<li class="item"><a href="/VerOne/about">VỀ CHÚNG TÔI</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>

	<div class="profileWrap container col-xs-12 col-md-12">
		<div style="text-align: center;" class="col-xs-12">
			<h3>HỖ TRỢ KHÁCH HÀNG</h3>
		</div>
		<ul class="nav nav-tabs col-md-8 col-md-offset-2">
			<li class="active"><a href="#1a" data-toggle="tab">Gửi thông
					tin bảo hành</a></li>
			<li><a href="#2a" data-toggle="tab">Gửi yêu cầu hỗ trơ</a></li>
			<li><a href="#3a" data-toggle="tab">Lịch sử bảo hành</a></li>
			<li><a href="#4a" data-toggle="tab">Lịch sử hỗ trợ</a></li>
		</ul>

		<div class="tab-content col-md-8 col-md-offset-2 clearfix">
			<div class="tab-pane col-xs-12 active" id="1a">
				<div class="form-group">
					<form id="frmSendGuarantee" class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-md-4" style="margin-top: 10px">Mã
								giày:</label>
							<div class="col-xs-12 col-md-8">
								<input type="text" class="form-control" id="productID"
									style="margin-top: 10px"
									placeholder="Nhập mã giày theo đơn hàng" name="productID"
									required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" style="margin-top: 10px">Mã
								đơn hàng:</label>
							<div class="col-xs-12 col-md-8">
								<input type="text" class="form-control" id="orderID"
									style="margin-top: 10px" placeholder="Nhập mã đơn hàng đã mua"
									name="orderID" required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" style="margin-top: 10px">Thông
								tin từ khách hàng:</label>
							<div class="col-xs-12 col-md-8">
								<textarea type="text" class="form-control"
									style="margin-top: 10px; resize: none;"
									placeholder="Nhập thông tin thêm về lỗi sản phẩm yêu cầu bảo hành"
									id="reasonGuarantee" name="reasonGuarantee" rows="5" required></textarea>
							</div>
						</div>
					</form>
					<div class="form-group">
						<div class="col-md-offset-4 col-md-8" style="margin-bottom: 20px">
							<div class="col-md-offset-8 col-md-4 col-xs-12"
								style="text-align: right; margin-top: 10px">
								<button id="submitGuarantee" type="submit"
									class="btn btn-primary">Gửi yêu cầu</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="tab-pane col-xs-12" id="2a">
				<div class="form-group">
					<form id="frmRequireSupporting" class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-md-4" style="margin-top: 10px">Câu
								hỏi thường gặp:</label>
							<div class="col-xs-12 col-md-8">
								<select class="form-control" id="availableQuestion"
									style="margin-top: 10px">
									<option value="0">Một số câu hỏi thường gặp?</option>
									<option value="1">Tôi đã mua hàng thì có thể đổi trả
										được không?</option>
									<option value="2">Làm sao tôi biết khi nào cửa hàng
										giao hàng đến nơi?</option>
									<option value="3">Tôi muốn xem các mặt hàng đang
										khuyến mãi ở đâu?</option>
									<option value="4">Tôi có thể đến trực tiếp cửa hàng để
										mua hàng không?</option>
									<option value="5">Tôi muốn thay đổi thông tin liên lạc
										của hình như thế nào?</option>
									<option value="6">Nếu sản phẩm hết hàng tôi có nhận đủ
										hàng khi cửa hàng có hàng lại?</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" style="margin-top: 10px">Đặt
								câu hỏi khác:</label>
							<div class="col-xs-12 col-md-8">
								<textarea type="text" class="form-control"
									style="margin-top: 10px; resize: none;"
									placeholder="Nếu không tìm thấy câu hỏi thỏa mãn yêu cầu khách hàng có thể đặt câu hỏi trực tiếp để được nhân viên cửa hàng tư vấn"
									id="questionSupport" name="questionSupport" rows="5" required></textarea>
							</div>
						</div>
					</form>
					<div class="form-group">
						<div class="col-md-offset-4 col-md-8" style="margin-bottom: 20px">
							<div class="col-md-offset-8 col-md-4 col-xs-12"
								style="text-align: right; margin-top: 10px">
								<button id="submitSendRequire" type="submit"
									class="btn btn-primary">Gửi câu hỏi</button>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="tab-pane col-xs-12" id="3a"> 
				<div class="form-group">
					<c:choose>
						<c:when test="${listGuarantee == null }">
							<h3 style="text-align: center;">
								Vui lòng nhấn <a href="/VerOne/login">Đăng nhập</a> để xem lịch sử
								bảo hành!
							</h3>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${empty listGuarantee}">
									<h3 style="text-align: center;">Bạn chưa gửi yêu cầu bảo
										hành nào!</h3>
								</c:when>
								<c:otherwise>
									<div class="col-xs-12"
										style="margin-top: 10px; text-align: center;">
										<label class="control-label col-xs-2">Mã bảo hành</label> <label
											class="control-label col-xs-6">Lý do bảo hành</label> <label
											class="control-label col-xs-2">Mã sản phẩm</label> <label
											class="control-label col-xs-2">Mã đơn hàng</label>

									</div>
									<c:forEach items="${listGuarantee}" var="itemGuarantee">
										<div class="col-xs-12"
											style="margin-top: 10px; text-align: center;">
											<span class="col-xs-2">${itemGuarantee.iD}</span> <span
												class="col-xs-6">${itemGuarantee.reason}</span> <span
												class="col-xs-2">${itemGuarantee.productID}</span> <span
												class="col-xs-2">${itemGuarantee.orderID}</span>
										</div>
										<div class="col-offset-2 col-xs-10">
											<c:choose>
												<c:when test="${itemGuarantee.staff != null}">
													<span style="margin-left: 50px; padding-top: 10px;" class="control-label"><span>-
													Nhân viên nhận bảo hành : <b>${itemGuarantee.getStaff().tenNV}</b>
													</span></span>
													<br/>
													<span style="margin-left: 50px;" class="control-label"><span>-
															Ngày nhận bảo hành : <b><fmt:formatDate value="${itemGuarantee.receiveGuarantee}" pattern="dd-MM-yyyy" /></b>
													</span></span>
													<br/>
													<span style="margin-left: 50px;" class="control-label"><span>-
															Ngày trả bảo hành : <b><fmt:formatDate value="${itemGuarantee.returnGuarantee}" pattern="dd-MM-yyyy" /></b>
													</span>
												</c:when>
												<c:otherwise>
													<span style="margin-left: 50px; padding-top: 10px;" class="control-label"><b>Chưa nhận bảo hành</b></span>
												</c:otherwise>				
											</c:choose>													
											<hr class="col-md-12" style="margin-left:50px; width:100%;"/>
										</div>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</div>
			</div>

			<div class="tab-pane col-xs-12" id="4a">
				<div class="form-group">
					<c:choose>
						<c:when test="${listSupport == null }">
							<h3 style="text-align: center;">
								Vui lòng <a href="/VerOne/login">Đăng nhập</a> để xem lịch sử yêu cầu hỗ trợ!
							</h3>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${empty listSupport}">
									<h3 style="text-align: center;">Bạn chưa gửi yêu cầu hỗ trợ nào!</h3>
								</c:when>
								<c:otherwise>
									<div class="col-xs-12"
										style="margin-top: 10px; text-align: center;">
										<label class="control-label col-xs-2">Mã hỗ trợ</label> <label
											class="control-label col-xs-7">Câu hỏi</label> <label
											class="control-label col-xs-3">Thời gian hỏi</label> 
									</div>
									<c:forEach items="${listSupport}" var="itemSupport">
										<div class="col-xs-12"
											style="margin-top: 10px; text-align: center;">
											<span class="col-xs-2">${itemSupport.iD}</span> <span
												class="col-xs-7">${itemSupport.question}</span> <span
												class="col-xs-3"><fmt:formatDate value="${itemSupport.sendDate}" pattern="dd-MM-yyyy - HH:mm" /></span>
										</div>
										<div class="col-offset-2 col-xs-10">
											<c:choose>
												<c:when test="${itemSupport.staff != null}">
													<span style="margin-left: 50px; padding-top: 10px;" class="control-label"><span>
														- Nhân viên hỗ trợ : <b>${itemSupport.getStaff().tenNV}</b>
														</span></span>
														<br/>
														<span style="margin-left: 50px;" class="control-label"><span>
														- Câu trả lời : <b>${itemSupport.answer}</b>
														</span></span>
														<br/>
														<span style="margin-left: 50px;" class="control-label">
														- Ngày trả lời : <b><fmt:formatDate value="${itemSupport.receiveDate}" pattern="dd-MM-yyyy - HH:mm" /></b>
													</span>
												</c:when>
												<c:otherwise>
													<span style="margin-left: 50px; padding-top: 10px;" class="control-label"><b>Chưa trả lời</b></span>
												</c:otherwise>				
											</c:choose>					
											<hr class="col-md-12" style="margin-left:50px; width:100%;"/>
										</div>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</div>
			</div>

		</div>
	</div>

	<div class="container-fluid"
		style="margin-top: 150px; padding-bottom: 30px;"></div>

	<footer class="container-fluid clearfix">
        <div class="row footerWrap">
            <div class="col-xs-6 col-md-6">
            <h5 style="text-align: center" ><i>Hỗ trợ khách hàng</i></h5>
                <div class="contact">
                   <ul class="ul-contact">
                        <div class="center-all-1">                         
                                <li><a href="guarantee"><img src="<c:url value="/resources/myweb/img/faq.png" />" alt="no logo"><p class="mobilehidden">FAQ</p></a></li>
                                <li><a href="guarantee"><img src="<c:url value="/resources/myweb/img/support.png" />" alt="no logo"><p class="mobilehidden">Hỗ trợ</p></a></li>
                                <li><a href="guarantee"><img src="<c:url value="/resources/myweb/img/ship.png" />" alt="no logo"><p class="mobilehidden">Bảo hành</p></a></li>
                        </div>
                    </ul>
                </div>
            </div>
            <div class="col-xs-6 col-md-6">
            <h5 style="text-align: center" ><i>Mạng xã hội</i></h5>
                <div class="social">
                    <ul class="ul-social">
                        <div class="center-all">
                            
                            <li><a href="https://www.facebook.com"><img src="<c:url value="/resources/myweb/img/facebook-logo-outline.png" />" alt="no logo"><p class="mobilehidden">Facebook</p></a></li>
                            <li><a href="https://www.instagram.com"><img src="<c:url value="/resources/myweb/img/instagram-social-outlined-logo.png" />" alt="no logo"><p class="mobilehidden">Instagram</p></a></li>
                            <li><a href="https://twitter.com"><img src="<c:url value="/resources/myweb/img/twitter-social-outlined-logo.png" />" alt="no logo"><p class="mobilehidden">Twitter</p></a></li>
                            <li><img src="<c:url value="/resources/myweb/img/mail.png" />" alt="no logo"><p class="mobilehidden">Email</p></li>
                        </div>
                    </ul>
                </div>
            </div>
        </div>
        <div class="bottom-footer">
            <h6>© 2017 Nhóm 5, All Rights Reserved</h6>
        </div>
    </footer>

</body>
</html>
