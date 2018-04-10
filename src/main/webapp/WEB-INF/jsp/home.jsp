<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.mvp.model.Account" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="<c:url value="/resources/myweb/css/nav.css" />">
   <link rel="stylesheet" href="<c:url value="/resources/myweb/css/footer.css" />">
  <link href="https://fonts.googleapis.com/css?family=Lora" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
     <link rel="stylesheet" href="<c:url value="/resources/myweb/css/home.css" />">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="<c:url value="/resources/myweb/js/nav.js" />" type="text/javascript" charset="utf-8"></script>
  <script src="<c:url value="/resources/myweb/js/home.js" />" type="text/javascript" charset="utf-8"></script>
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
  <title>GREATS</title>
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
					  <div class="dropdown-content" style="display:none;">
						<a href="profile">Quản lý tài khoản</a>
						<a href="orderinfo">Xem đơn hàng</a>
						<a class="manage" href="#" value="${data}">Quản lý cửa hàng</a>
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
					<%}
						}%>
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


	<div class="home container-fluid">
		<div class="row">
			<div class="bannerWrap col-xs-12">
				<div class="banner">
					<a href="home"><img class="imgBanner img-responsive" src="data:image/png;base64,${banner.base64}" alt=""></a>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
				<div class="col-xs-0 col-md-2"></div>
				<div class="col-xs-6 col-md-4">
					<a href="/VerOne/shopping/hotsaleproduct"><div id="menShopping" class="col-xs-12 col-md-12">
						<p class="head1">NỔI BẬT</p>
						<p class="sub1">XEM NGAY</p>
					</div></a>
				</div>
				<div class="col-xs-6 col-md-4">
					<a href="/VerOne/shopping/discountproduct"><div id="womenShopping" class="col-xs-12 col-md-12">
						<p class="head1">GIẢM GIÁ</p>
						<p class="sub1">XEM NGAY</p>
					</div></a>
				</div>
				<div class="col-xs-0 col-md-2"></div>
		</div>

		<div class="row">
			<h2 style="text-align: center; letter-spacing: 3px;">ĐANG HOT</h2>
		</div>

		<div class="row">
			<c:forEach var ="item" items = "${listHot }">
			<div class="col-md-3 col-xs-6">
				<div class="productWrap" style="position: relative;">
						<a href="product/${item.iD}">
						<div class= "crop col-xs-12 col-md-12">
							<img class="img-responsive col-xs-12 col-md-12" src="data:image/png;base64,${item.base64}" alt="${item.name }">
						</div>
						<p class="startingPrice">Giá chỉ<br/>
								<c:choose>
								    <c:when test="${item.discount > 0}">
									    <span style="text-decoration: line-through;"><fmt:formatNumber value="${item.price}" type="currency" currencySymbol="" minFractionDigits="0"/></span><br/> 
										   <span style="color:red;"><fmt:formatNumber value="${item.price - item.price*item.discount/100 }" type="currency" currencySymbol="" minFractionDigits="0"/></span>
								    </c:when>    
								    <c:otherwise>
								        <fmt:formatNumber value="${item.price}" type="currency" currencySymbol="" minFractionDigits="0"/>
								    </c:otherwise>
								</c:choose> </p>
						<h5 class="productName">${item.name }</h5></a>
				</div>
			</div>
			</c:forEach>
		</div>
		
		<div class="line col-md-6 col-md-offset-3 col-xs-8 col-xs-offset-2"></div>
		
		<div class="row">
			<h2 style="text-align: center; letter-spacing: 3px;">ĐANG GIẢM GIÁ</h2>
		</div>

		<div class="row">
			<c:forEach var ="item" items = "${listDiscount }">
			<div class="col-md-3 col-xs-6">
				<div class="productWrap" style="position: relative;">
						<a href="product/${item.iD}">
						<div class= "crop col-xs-12 col-md-12">
							<img class="img-responsive col-xs-12 col-md-12" src="data:image/png;base64,${item.base64}" alt="${item.name }">
						</div>
						<p class="startingPrice">Giá chỉ<br/>
								<c:choose>
								    <c:when test="${item.discount > 0}">
									    <span style="text-decoration: line-through;"><fmt:formatNumber value="${item.price}" type="currency" currencySymbol="" minFractionDigits="0"/></span><br/> 
										   <span style="color:red;"><fmt:formatNumber value="${item.price - item.price*item.discount/100 }" type="currency" currencySymbol="" minFractionDigits="0"/></span>
								    </c:when>    
								    <c:otherwise>
								        <fmt:formatNumber value="${item.price}" type="currency" currencySymbol="" minFractionDigits="0"/>
								    </c:otherwise>
								</c:choose></p>
						<h5 class="productName">${item.name }</h5></a>
						
				</div>
			</div>
			</c:forEach>
		</div>
		
		<div class="line col-md-6 col-md-offset-3 col-xs-8 col-xs-offset-2"></div>
		
		<div class="row">
			<h2 style="text-align: center; letter-spacing: 3px;">ĐƯỢC ƯA CHUỘNG</h2>
		</div>

		<div class="row">
			<c:forEach var ="item" items = "${listHotSale }">
			<div class="col-md-3 col-xs-6">
				<div class="productWrap" style="position: relative;">
						<a href="product/${item.iD}">
						<div class= "crop col-xs-12 col-md-12">
							<img class="img-responsive col-xs-12 col-md-12" src="data:image/png;base64,${item.base64}" alt="${item.name }">
						</div>
						<p class="startingPrice">Giá chỉ<br/>
							<c:choose>
								    <c:when test="${item.discount > 0}">
									    <span style="text-decoration: line-through;"><fmt:formatNumber value="${item.price}" type="currency" currencySymbol="" minFractionDigits="0"/></span><br/> 
										   <span style="color:red;"><fmt:formatNumber value="${item.price - item.price*item.discount/100 }" type="currency" currencySymbol="" minFractionDigits="0"/></span>
								    </c:when>    
								    <c:otherwise>
								        <fmt:formatNumber value="${item.price}" type="currency" currencySymbol="" minFractionDigits="0"/>
								    </c:otherwise>
								</c:choose></p>
						<h5 class="productName">${item.name }</h5></a>
				</div>
			</div>
			</c:forEach>
		</div>
		
		<div class="line col-md-6 col-md-offset-3 col-xs-8 col-xs-offset-2"></div>

		<!-- PRODUCER -->
		<!-- <div class="row">
			<h2 style="text-align: center; letter-spacing: 3px;">TOP PRODUCER</h2>
		</div>

		<div class="row">
			<div class="col-md-3 col-xs-6">
				<div class="producerWrap col-md-12 col-xs-12">
					<a href="#producer">
					<img src="<c:url value="/resources/myweb/img/Vogue.png" />" alt="" class="img-responsive">
					<p>"It's just the thing to put a spring in your step"</p></a>
				</div>
			</div>
			<div class="col-md-3 col-xs-6">
				<div class="producerWrap col-md-12 col-xs-12">
					<img src="<c:url value="/resources/myweb/img/Esquire.png" />" alt="" class="img-responsive">
					<p>"The footwear label is decidedly cool and has a decidely modern business approach"</p>
				</div>
			</div>

			<div class="col-md-3 col-xs-6">
				<div class="producerWrap col-md-12 col-xs-12">
					<img src="<c:url value="/resources/myweb/img/Vogue.png" />" alt="" class="img-responsive">
					<p>"It's just the thing to put a spring in your step"</p>
				</div>
			</div>
			<div class="col-md-3 col-xs-6">
				<div class="producerWrap col-md-12 col-xs-12">
					<img src="<c:url value="/resources/myweb/img/Esquire.png" />" alt="" class="img-responsive">
					<p>"The footwear label is decidedly cool and has a decidely modern business approach"</p>
				</div>
			</div>
		</div> -->

	</div>

	<footer class="container-fluid">
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