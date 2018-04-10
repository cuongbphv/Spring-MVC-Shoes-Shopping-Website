<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Lora" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
  <link rel="stylesheet" href="<c:url value="/resources/myweb/css/nav.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/myweb/css/main.css" />">
  <link rel="stylesheet" href="<c:url value="/resources/myweb/css/footer.css" />">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>
  <script src="<c:url value="/resources/myweb/js/login.js" />" type="text/javascript" charset="utf-8"></script>
  <script src="<c:url value="/resources/myweb/js/nav.js" />" type="text/javascript" charset="utf-8"></script>

  <title>Đăng nhập</title>
</head>
<body onload="LoadPage();" onresize="Resize();" style="background-image: url('<c:url value="/resources/myweb/img/background.jpg" />');">
	
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
					<!-- <a href="cart" style="float:right"><img id="cart" src="<c:url value="/resources/myweb/img/cart.png" />" style="width: 32px;" alt="">
					 <span style="padding-right: 20px">(0)</span></a>
					 <a href="login" id="loginlink">LOGIN / SIGN UP</a> -->
					 <div class="clearfix"></div> 
				</div>
			</div>
			<div class="row navi" style="padding: 10px 0 0 0;">
				<div class="col-md-12">
					<nav class="navWrapper">
						<ul class="navList">
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

	<div style="padding-top: 100px;" class="loginWrap container-fluid">
		<div class="row">
		<h3 style="text-align:center;" class="col-xs-12"> ${message} </h3>
			<div class="col-xs-12 col-md-6">
				<img style="margin-left: 80px; width: 80%; height: auto;" src="data:image/png;base64,${banner.base64}" alt=""/>
			</div>
			<div class="col-xs-12 col-md-5 ">
				<form:form class="form-horizontal"  method="POST" modelAttribute="tk"  action="checkLogin">
					<div class="form-group">
						<h2 style="text-align: center;">Đăng nhập</h2>
					</div>
					
				    <div class="form-group">
				      <form:label class="control-label col-md-4" path="tenDangNhap">Tên tài khoản:</form:label>
				      <div class="col-md-8">
				        <form:input type="text" class="form-control" placeholder="Nhập tài khoản" path="tenDangNhap" value="${username}" />
				      </div>
				    </div>
				    <div class="form-group">
				      <form:label class="control-label col-md-4" path="matKhau">Mật khẩu:</form:label>
				      <div class="col-md-8">
				        <form:input type="password" class="form-control"  placeholder="Nhập mật khẩu" path="matKhau" value="${blank }"/>
				      </div>
				    </div>
				    <div class="form-group">        
				      <div class="col-md-offset-4 col-md-8">
				        <div class="col-md-6 col-xs-12 checkbox">
				          <form:checkbox name="remember" path="ghiNho" label="Ghi nhớ"/>
				        </div>
				        <div class="col-md-6 col-xs-12" style="text-align: right;">
				          <button type="submit" class="btn btn-default" style="background-color: #c0c0c0;">Đăng nhập</button>
				       </div>
				       <div class="col-md-12 col-xs-12" style="text-align: center; font-style: italic; padding-top: 20px;" >
				          <span>Bạn chưa có tài khoản? </span><a href="register" style="color: blue; text-decoration:none; font-weight: bold;"> Đăng ký</a>
				       </div>
				      </div>
				    </div>
				</form:form>
			</div>
		</div>
	</div>
	<hr/>
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