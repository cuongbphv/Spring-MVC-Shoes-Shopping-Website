<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.mvp.model.Account" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/nav.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/orderinfo.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/footer.css" />">
<link href="https://fonts.googleapis.com/css?family=Lora"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/resources/myweb/js/nav.js" />"
	type="text/javascript" charset="utf-8"></script>
<script src="<c:url value="/resources/myweb/js/orderinfo.js" />"
	type="text/javascript" charset="utf-8"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		    <script>
      $(document).ready(function(){
	    var linktext=$('.dropbtn').text();
	    if(linktext == "Đăng nhập/Đăng ký")
	    {
	        $('.dropdown').hover(function() {
           document.getElementsByClassName("dropdown-content").style.display = "none";
        },function() {
            document.getElementsByClassName("dropdown-content")[0].style.display = "none";
 	   });
	    }else{
			$('.dropdown').hover(function() {
           document.getElementsByClassName("dropdown-content")[0].style.display = "block";
	   },function() {
           document.getElementsByClassName("dropdown-content")[0].style.display = "none";
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
			margin-top:5px;
		}

		/* Dropdown Content (Hidden by Default) */
		.dropdown-content {
			display: none;
			position: fixed;
			background-color: #f9f9f9;
			min-width: 160px;
			box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
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
		.dropdown-content a:hover {background-color: #fff;
      color:blue;}

		/* Show the dropdown menu on hover */
		.dropdown:hover .dropdown-content {
			display: block;
		}

		/* Change the background color of the dropdown button when the dropdown content is shown */
		.dropdown:hover .dropbtn {
			background-color: #fff;
		}
		
		.dropdown-content .manage{
			display: none;
		}
  </style>
<title>Thông tin đơn hàng</title>
</head>
<body onload="LoadPage()" onresize="Resize()"
	style="background-image: url('<c:url value="/resources/myweb/img/background.jpg" />')">
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
						<a href="home"><img class="img-responsive" id="imgLogo"
							src="<c:url value="/resources/myweb/img/logo.png" />" alt=""></a>
					</div>
				</div>

			</div>
			<div class="col-xs-3 col-md-4">
				<a href="/VerOne/cart" style="float:right"><img id="cart" src="<c:url value="/resources/myweb/img/cart.png" />" style="width: 32px;" alt="">
				 <span id="numItems" style="padding-right: 20px"></span></a>
					 <div class="dropdown" >
						 <a href="${url}" class="dropbtn"><span style="display:inline;">${headerText}</span></a>
						  <div class="dropdown-content">
							<a href="profile">Quản lý tài khoản</a>
							<a href="orderinfo">Xem đơn hàng</a>
							<a href="logout">Đăng xuất</a>
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

	<div class="orderWrap container">
		<div class="row orderHeader">
			<div class="col-md-5">
				<div class="col-md-5">
					<p style="padding-top: 7px;">Đơn hàng đặt trong:</p>
				</div>
				<div class="col-md-7">
					<select id="comboboxFilter" class="form-control">
						<option value="7">Trong tuần(7 ngày qua)</option>
						<option value="30">Trong tháng(30 ngày qua)</option>
						<option value="365">Trong năm(365 ngày qua)</option>
					</select>
				</div>
			</div>
		</div>
		<div id="allOrder">
			
		</div>
		
		
	</div>
	<hr />
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