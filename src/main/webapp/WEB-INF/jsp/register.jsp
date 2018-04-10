<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="<c:url value="/resources/myweb/css/main.css" />">
  <link rel="stylesheet" href="<c:url value="/resources/myweb/css/nav.css" />">
  <link rel="stylesheet" href="<c:url value="/resources/myweb/css/footer.css" />">
    <link href="https://fonts.googleapis.com/css?family=Lora" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
  <script src="<c:url value="/resources/myweb/js/register.js" />" type="text/javascript" charset="utf-8"></script>
  <script src="<c:url value="/resources/myweb/js/nav.js" />" type="text/javascript" charset="utf-8"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <title>Đăng ký tài khoản</title>
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

	<script>
	$(document).ready(function(){
		$("#username").keyup(function(){
			var username = $("#username").val();
			
			$.post('checkExist', { username : username }, function(data){
				document.getElementById("existErr").style.display= "block";
				document.getElementById("existErr").innerHTML = data;
				if(data="")
					document.getElementById("existErr").style.display= "none";
			});
		});
	});
	</script>
	<div class="wrapper container-fluid">
		<div class="row">
			<div class="banner col-md-6">
				<img src="data:image/png;base64,${banner.base64}"  style="width: 90%; height: auto; padding-top:20px;" />
			</div>
			<div class="col-xs-12 col-md-5">	
				<form:form method="POST" modelAttribute="register" class="form-horizontal"  action="/VerOne/addcustomeracc">
					<div class="form-group">
						<h2 style="text-align: center;">Đăng ký tài khoản</h2>
					</div>
				    <div class="form-group">
				      <label class="control-label col-md-4" for="username">Tên tài khoản:</label>
				      <div class="col-md-8">
				        <form:input class="form-control" placeholder="Nhập tài khoản" path="username" id="username" autocomplete="off" />
				         <form:errors path="username" cssclass="error"></form:errors>
				         <p style="display:none;" class= "col-md-12" id="existErr"></p>
				      </div>
				    </div>
				    <div class="form-group">
				      <label class="control-label col-md-4" for="password">Mật khẩu:</label>
				      <div class="col-md-8">
				        <form:password id="password" onchange="checkpass();" class="form-control" placeholder="Nhập mật khẩu" path="password"/>
						 <form:errors path="password" cssclass="error"></form:errors>				      
				      </div>
				    </div>

				    <div class="form-group">
				      <label class="control-label col-md-4" for="retype">Nhập lại:</label>
				      <div class="col-md-8">
				        <form:password id="confirm_password" onchange="checkpass();" class="form-control"  placeholder="Nhập lại mật khẩu" path="retype" />
						<form:errors path="retype" cssclass="error"></form:errors>				      
				      </div>
				    </div>
				    <div class="form-group">
				      <label class="control-label col-md-4" for="name">Tên người dùng:</label>
				      <div class="col-md-8">
				        <form:input class="form-control" id="name" placeholder="Nhập tên người dùng" path="name"/>
				      <form:errors path="name" cssclass="error"></form:errors>
				      </div>
				    </div>
				    <div class="form-group">
				      <label class="control-label col-md-4" for="phoneNo">Số điện thoại</label>
				      <div class="col-md-8">
				        <form:input type="text" class="form-control" id="phoneNo" placeholder="Nhập số điện thoại" path="phoneNo" />
				      <form:errors path="phoneNo" cssclass="error"></form:errors>
				      </div>
				    </div>
				    <div class="form-group">
				      <label class="control-label col-md-4" for="dateOfBirth">Ngày sinh:</label>
				      <div class="col-md-4">
				        <form:input type="date"  class="form-control" id="dateofbirth" path="dateOfBirth"/>
				        <form:errors path="dateOfBirth" cssclass="error"></form:errors>
				      </div>
				      <div class="col-md-4" style="padding-top: 8px;">
				      	<form:radiobutton path="gender" value="M" label="Nam" />
				      	<span style="padding: 0 10px"></span>
				      	<form:radiobutton path="gender" value="F" label="Nữ" />
				      	<form:errors path="gender" cssclass="error"></form:errors>
				      </div>
				      <p class= "col-md-offset-4 col-md-8" id="dateErr">${dateErr}</p>
				    </div>					    
				    <div class="form-group">        
				      <div class="col-md-offset-4 col-md-8">
				        <div  class="col-md-12 col-xs-12" style="text-align: center;">
				          <button type="submit" id="submit" class="btn btn-default" style="background-color: #C0c0c0;width: 100%;" disabled>Đăng ký</button>
				       </div>
				      </div>
				    </div>
				</form:form>
				<div class="col-md-offset-4 col-md-8 col-xs-12" style="text-align: center; font-style: italic; padding-top: 20px;" >
				          <span>Bạn đã có tài khoản? </span><a href="login" style="color: blue; text-decoration:none; font-weight: bold;"> Đăng nhập</a>
				      </div>
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