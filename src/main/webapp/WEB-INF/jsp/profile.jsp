<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page import="com.mvp.model.Account" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="<c:url value="/resources/myweb/css/nav.css" />">
  <link rel="stylesheet" href="<c:url value="/resources/myweb/css/profile.css" />">
  <link rel="stylesheet" href="<c:url value="/resources/myweb/css/footer.css" />">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Lora" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
  <script src="<c:url value="/resources/myweb/js/nav.js" />" type="text/javascript" charset="utf-8"></script>
  <script src="<c:url value="/resources/myweb/js/profile.js" />" type="text/javascript" charset="utf-8"></script>

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
  <title>GREATS - Thông tin tài khoản</title>
</head>
	<body onload="LoadPage()" onresize="Resize()" style="background-image: url('<c:url value="/resources/myweb/img/background.jpg" />')">
		<div class="headerWrap container-fluid">
			<div class="row">
				<div class="col-xs-3 col-md-4">
			        <div id="expands" onclick="showNav()"><span class="glyphicon glyphicon-menu-hamburger"></span>                    
			        </div>
				</div>
				<div class="col-xs-6 col-md-4" style="text-align: center;">
					<div class="logo">
						<div><a href="home"><img class="img-responsive" id="imgLogo" src="<c:url value="/resources/myweb/img/logo.png" />" alt=""></a></div>
					</div>
					
				</div>
				<div class="col-xs-3 col-md-4">
					<a href="/VerOne/cart" style="float:right"><img id="cart" src="<c:url value="/resources/myweb/img/cart.png" />" style="width: 32px;" alt="">
					 <span id="numItems" style="padding-right: 20px"></span></a>
					 <div class="dropdown" >
						 <a href="${url}" class="dropbtn"><span style="display:inline;">${headerText}</span></a>
						  <div class="dropdown-content">
							<a href="profile">Quản lý tài khoản</a>
							<a href="orderinfo">Xem giỏ hàng</a>
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
					<%} }%>
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
			<div style="text-align: center;" class="col-xs-12"><h3>THÔNG TIN TÀI KHOẢN</h3></div>
			<ul  class="nav nav-tabs col-md-8 col-md-offset-2 ">
				<li class="active"><a  href="#1a" data-toggle="tab">Thông tin cá nhân</a>
				</li>
				<li><a href="#2a" data-toggle="tab">Thay đổi mật khẩu</a>
				</li>
			</ul>

			<div class="tab-content col-md-8 col-md-offset-2 clearfix">
			  	<div class="tab-pane col-xs-12 active" id="1a">
			
				</div>
				<div class="tab-pane col-xs-12" id="2a">
          			<form id="frmChangePass" class="form-horizontal">
          				<div class="form-group">
					      <label class="control-label col-md-3" for="pwd">Mật khẩu:</label>
					      <div class="col-md-6">
					        <input type="password" class="form-control" id="pwd" placeholder="Nhập mật khẩu cũ" 
					        		name="password" pattern="[A-Za-z0-9]*" minlength="3" maxlength="16" required>
					     </div>
				    	</div>
          				<div class="form-group">
					      <label class="control-label col-md-3" for="pwd">Mật khẩu mới:</label>
					      <div class="col-md-6">
					        <input type="password" class="form-control" id="newpwd" placeholder="Nhập mật khẩu mới" 
					        		name="newpassword" pattern="[A-Za-z0-9]*" minlength="3" maxlength="16" required>
					     </div>
				    	</div>
				    <div class="form-group">
				      <label class="control-label col-md-3" for="repwd">Nhập lại:</label>
				      <div class="col-md-6">
				        <input type="password" class="form-control" id="repwd" placeholder="Nhập lại mật khẩu mới" 
				        			name="retype" pattern="[A-Za-z0-9]*" minlength="3" maxlength="16" required>
				      </div>
				    </div>
				        <h5 class="col-md-9" id="passErr" style="color:red; text-align:right;display:none;"></h5>
				     <div class="form-group">
				      <!-- <div class="col-md-offset-2 col-md-6"> -->
				        <div  class="col-md-offset-6 col-md-3 col-xs-12" style="text-align: right;">
				          <button id="btnSubmitChange" type="button" class="btn btn-default" style="background-color: #ea8b07;">Cập nhật</button>
				        </div>
				     </div>
          			</form>
				</div>
			</div>
		</div>


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