<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	href="<c:url value="/resources/myweb/css/about.css" />">
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
<script src="<c:url value="/resources/myweb/js/about.js" />"
	type="text/javascript" charset="utf-8"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
html, body, div, span {
    margin:0;
    padding:0;
    border:0;
    font-size:100%;
    font:inherit;
    vertical-align:baseline;
    font-family:"Helvetica Neue", Helvetica
}
html {
    -webkit-text-size-adjust:none;
}
body {
    background:#ecebe8;
}
{
    .promo-box {
        width:auto
    }
    .player .track {
        max-width:170px
    }
}
.center {
    text-align:center;
}
#main {
    font-family:"Lucida Grande", "Helvetica Neue", Helvetica
}
#error h1 {
    color:#1d1d1d;
    font-size:36px;
    font-weight:bold;
    text-shadow:0 1px 0 #414141;
    margin-top:50px;
    margin-right:30px;
    text-align:right;
}
#error-monster-1 {
    margin-top:40px;
    background:url('https://openclipart.org/image/2400px/svg_to_png/176330/hole.png');
    width:235px;
    height:237px;
}
@-webkit-keyframes swinging {
    from {
        -webkit-transform:rotate(-7deg)
    }
    to {
        -webkit-transform:rotate(7deg)
    }
}
@-moz-keyframes swinging {
    from {
        -moz-transform:rotate(-7deg)
    }
    to {
        -moz-transform:rotate(7deg)
    }
}
@-o-keyframes swinging {
    from {
        -o-transform:rotate(-7deg)
    }
    to {
        -o-transform:rotate(7deg)
    }
}
@keyframes swinging {
    from {
        transform:rotate(-7deg)
    }
    to {
        transform:rotate(7deg)
    }
}
#error-monster-2 {
    -webkit-animation:swinging 1s ease-in-out infinite alternate;
    -moz-animation:swinging 1s ease-in-out infinite alternate;
    -o-animation:swinging 1s ease-in-out infinite alternate;
    animation:swinging 1s ease-in-out infinite alternate;
    margin-left:30px;
    margin-top:196px;
    -webkit-transform-origin:90% 10px;
    -moz-transform-origin:75% -40px;
    -o-transform-origin:75% -40px;
    transform-origin:75% -40px;
}
#error-monster-3 {
    margin-top:170px;
    float:right;
    margin-right:100px;
}
#error h1 {
    margin-right:0;
}
.container {
    position:relative;
    width:960px;
    margin:0 auto;
    padding:20px 0
}
.container .column, .container .columns {
    float:left;
    display:inline;
    margin-left:10px;
    margin-right:10px
}
.row {
    margin-bottom:20px
}
.column.alpha, .columns.alpha {
    margin-left:0
}
.column.omega, .columns.omega {
    margin-right:0
}
.container .one.column, .container .one.columns {
    width:40px
}
.container .two.columns {
    width:100px
}
.container .three.columns {
    width:160px
}
.container .four.columns {
    width:220px
}
.container .five.columns {
    width:280px
}
.container .six.columns {
    width:340px
}
.container .seven.columns {
    width:400px
}
.container .eight.columns {
    width:460px
}
.container .nine.columns {
    width:520px
}
.container .ten.columns {
    width:580px
}
.container .eleven.columns {
    width:640px
}
.container .twelve.columns {
    width:700px
}
.container .thirteen.columns {
    width:760px
}
.container .fourteen.columns {
    width:820px
}
.container .fifteen.columns {
    width:880px
}
.container .sixteen.columns {
    width:940px
}
.container .one-third.column {
    width:300px
}
.container .two-thirds.column {
    width:620px
}
.container .offset-by-one {
    padding-left:60px
}
.container .offset-by-two {
    padding-left:120px
}
.container .offset-by-three {
    padding-left:180px
}
.container .offset-by-four {
    padding-left:240px
}
.container .offset-by-five {
    padding-left:300px
}
.container .offset-by-six {
    padding-left:360px
}
.container .offset-by-seven {
    padding-left:420px
}
.container .offset-by-eight {
    padding-left:480px
}
.container .offset-by-nine {
    padding-left:540px
}
.container .offset-by-ten {
    padding-left:600px
}
.container .offset-by-eleven {
    padding-left:660px
}
.container .offset-by-twelve {
    padding-left:720px
}
.container .offset-by-thirteen {
    padding-left:780px
}
.container .offset-by-fourteen {
    padding-left:840px
}
.container .offset-by-fifteen {
    padding-left:900px
}
@media only screen and (min-width:768px) and (max-width:959px) {
    .container {
        width:768px
    }
    .container .column, .container .columns {
        margin-left:10px;
        margin-right:10px
    }
    .column.alpha, .columns.alpha {
        margin-left:0;
        margin-right:10px
    }
    .column.omega, .columns.omega {
        margin-right:0;
        margin-left:10px
    }
    .alpha.omega {
        margin-left:0;
        margin-right:0
    }
    .container .one.column, .container .one.columns {
        width:28px
    }
    .container .two.columns {
        width:76px
    }
    .container .three.columns {
        width:124px
    }
    .container .four.columns {
        width:172px
    }
    .container .five.columns {
        width:220px
    }
    .container .six.columns {
        width:268px
    }
    .container .seven.columns {
        width:316px
    }
    .container .eight.columns {
        width:364px
    }
    .container .nine.columns {
        width:412px
    }
    .container .ten.columns {
        width:460px
    }
    .container .eleven.columns {
        width:508px
    }
    .container .twelve.columns {
        width:556px
    }
    .container .thirteen.columns {
        width:604px
    }
    .container .fourteen.columns {
        width:652px
    }
    .container .fifteen.columns {
        width:700px
    }
    .container .sixteen.columns {
        width:748px
    }
    .container .one-third.column {
        width:236px
    }
    .container .two-thirds.column {
        width:492px
    }
    .container .offset-by-one {
        padding-left:48px
    }
    .container .offset-by-two {
        padding-left:96px
    }
    .container .offset-by-three {
        padding-left:144px
    }
    .container .offset-by-four {
        padding-left:192px
    }
    .container .offset-by-five {
        padding-left:240px
    }
    .container .offset-by-six {
        padding-left:288px
    }
    .container .offset-by-seven {
        padding-left:336px
    }
    .container .offset-by-eight {
        padding-left:348px
    }
    .container .offset-by-nine {
        padding-left:432px
    }
    .container .offset-by-ten {
        padding-left:480px
    }
    .container .offset-by-eleven {
        padding-left:528px
    }
    .container .offset-by-twelve {
        padding-left:576px
    }
    .container .offset-by-thirteen {
        padding-left:624px
    }
    .container .offset-by-fourteen {
        padding-left:672px
    }
    .container .offset-by-fifteen {
        padding-left:720px
    }
}
@media only screen and (max-width:767px) {
    .container {
        width:300px
    }
    .container .columns, .container .column {
        margin:0
    }
    .container .one.column, .container .one.columns, .container .two.columns, .container .three.columns, .container .four.columns, .container .five.columns, .container .six.columns, .container .seven.columns, .container .eight.columns, .container .nine.columns, .container .ten.columns, .container .eleven.columns, .container .twelve.columns, .container .thirteen.columns, .container .fourteen.columns, .container .fifteen.columns, .container .sixteen.columns, .container .one-third.column, .container .two-thirds.column {
        width:300px
    }
    .container .offset-by-one, .container .offset-by-two, .container .offset-by-three, .container .offset-by-four, .container .offset-by-five, .container .offset-by-six, .container .offset-by-seven, .container .offset-by-eight, .container .offset-by-nine, .container .offset-by-ten, .container .offset-by-eleven, .container .offset-by-twelve, .container .offset-by-thirteen, .container .offset-by-fourteen, .container .offset-by-fifteen {
        padding-left:0
    }
}
@media only screen and (min-width:480px) and (max-width:767px) {
    .container {
        width:420px
    }
    .container .columns, .container .column {
        margin:0
    }
    .container .one.column, .container .one.columns, .container .two.columns, .container .three.columns, .container .four.columns, .container .five.columns, .container .six.columns, .container .seven.columns, .container .eight.columns, .container .nine.columns, .container .ten.columns, .container .eleven.columns, .container .twelve.columns, .container .thirteen.columns, .container .fourteen.columns, .container .fifteen.columns, .container .sixteen.columns, .container .one-third.column, .container .two-thirds.column {
        width:420px
    }
}
.container:after {
    content:"\0020";
    display:block;
    height:0;
    clear:both;
    visibility:hidden
}
.clearfix:before, .clearfix:after, .row:before, .row:after {
    content:'\0020';
    display:block;
    overflow:hidden;
    visibility:hidden;
    width:0;
    height:0
}
.row:after, .clearfix:after {
    clear:both
}
.row, .clearfix {
    zoom:1
}
.clear {
    clear:both;
    display:block;
    overflow:hidden;
    visibility:hidden;
    width:0;
    height:0
}
</style>
<title>GREATS - Lỗi</title>
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
						<a href="/VerOne/home"><img class="img-responsive"
							id="imgLogo"
							src="<c:url value="/resources/myweb/img/logo.png" />" alt=""></a>
					</div>
				</div>

			</div>
			<div class="col-xs-3 col-md-4">

				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<div class="aboutWrap container">
		<div id="main">
			<div class="container">
				<div id="error" class="sixteen columns clearfix">
					<div id="error-monster-1" class="five columns alpha">
						<img id="error-monster-2"
							src="https://images-blogger-opensocial.googleusercontent.com/gadgets/proxy?url=http%3A%2F%2F2.bp.blogspot.com%2F-VE9_o6j0vlU%2FUsyFAHLCiDI%2FAAAAAAAAAWw%2FuXQPIKfgHfE%2Fs1600%2Fhanging.png&container=blogger&gadget=a&rewriteMime=image%2F*">
					</div>
					<div class="eleven columns omega">
						<h1><a style="color:orange" href="/VerOne/login">Đăng nhập</a> để tiếp tục</h1>

						<img id="error-monster-3"
							src="https://images-blogger-opensocial.googleusercontent.com/gadgets/proxy?url=http%3A%2F%2F3.bp.blogspot.com%2F-1OceboVQdW4%2FUsyFAJ5CnjI%2FAAAAAAAAAWs%2FKBd_dNM-Huc%2Fs1600%2FmonstersRight.png&container=blogger&gadget=a&rewriteMime=image%2F*">
					</div>
				</div>
			</div>
		</div>
	</div>

	<hr />
	<footer class="container-fluid clearfix">
		<div class="row footerWrap">
			<div class="col-xs-6 col-md-6">
				<h5 style="text-align: center">
					<i>Hỗ trợ khách hàng</i>
				</h5>
				<div class="contact">
					<ul class="ul-contact">
						<div class="center-all-1">
							<li><a href="/VerOne/guarantee"><img
									src="<c:url value="/resources/myweb/img/faq.png" />"
									alt="no logo">
								<p class="mobilehidden">FAQ</p></a></li>
							<li><a href="/VerOne/guarantee"><img
									src="<c:url value="/resources/myweb/img/support.png" />"
									alt="no logo">
								<p class="mobilehidden">Hỗ trợ</p></a></li>
							<li><a href="/VerOne/guarantee"><img
									src="<c:url value="/resources/myweb/img/ship.png" />"
									alt="no logo">
								<p class="mobilehidden">Bảo hành</p></a></li>
						</div>
					</ul>
				</div>
			</div>
			<div class="col-xs-6 col-md-6">
				<h5 style="text-align: center">
					<i>Mạng xã hội</i>
				</h5>
				<div class="social">
					<ul class="ul-social">
						<div class="center-all">

							<li><a href="https://www.facebook.com"><img
									src="<c:url value="/resources/myweb/img/facebook-logo-outline.png" />"
									alt="no logo">
								<p class="mobilehidden">Facebook</p></a></li>
							<li><a href="https://www.instagram.com"><img
									src="<c:url value="/resources/myweb/img/instagram-social-outlined-logo.png" />"
									alt="no logo">
								<p class="mobilehidden">Instagram</p></a></li>
							<li><a href="https://twitter.com"><img
									src="<c:url value="/resources/myweb/img/twitter-social-outlined-logo.png" />"
									alt="no logo">
								<p class="mobilehidden">Twitter</p></a></li>
							<li><img
								src="<c:url value="/resources/myweb/img/mail.png" />"
								alt="no logo">
							<p class="mobilehidden">Email</p></li>
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