<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/shopping.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/footer.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/nav.css" />">
<link href="https://fonts.googleapis.com/css?family=Lora"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans"
	rel="stylesheet">
<script src="<c:url value="/resources/myweb/js/nav.js" />"
	type="text/javascript" charset="utf-8"></script>
<script src="<c:url value="/resources/myweb/js/shopping.js" />"
	type="text/javascript" charset="utf-8"></script>
    <script>
      $(document).ready(function(){
	    var linktext = $('.dropbtn').text();
	 
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

		.dropbtn:hover{
			color:blue;
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
<title>GREATS - Giày nam</title>
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
						<a href="/VerOne/home"><img class="img-responsive" id="imgLogo"
							src="<c:url value="/resources/myweb/img/logo.png" />" alt=""></a>
					</div>
				</div>

			</div>
			<div class="col-xs-3 col-md-4">
				<a href="/VerOne/cart" style="float:right"><img id="cart" src="<c:url value="/resources/myweb/img/cart.png" />" style="width: 32px;" alt="">
					 <span id="numItems" style="padding-right: 20px"></span></a>
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
					<%} }%>
						<li class="item"><a href="/VerOne/shopping">DANH MỤC</a></li>
						<li class="item"><a href="/VerOne/shopping/hotproduct">NỔI
								BẬT</a></li>
						<li class="item"><a href="/VerOne/shopping/hotsaleproduct">BÁN
								CHẠY</a></li>
						<li class="item"><a href="/VerOne/shopping/discountproduct">GIẢM
								GIÁ</a></li>
						<li class="item"><a href="/VerOne/about">VỀ CHÚNG TÔI</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>

	<div id="giay" class="row saleWrap container-fluid">
		<div class="filterBar col-md-12 col-xs-12">

			<div class="comboboxFilter col-md-2"></div>

			<div class="col-md-2 comboboxFilter ">
				<select id="colorFilter" class="form-control">
					<option selected value="0">Màu</option>
					<c:forEach var="color" items="${colors }">
						<option value="${color.iD }">${color.name }</option>
					</c:forEach>
				</select>
			</div>

			<div class="col-md-1 comboboxFilter">
				<select id="sizeFilter" class="form-control">
					<option selected value="0">Size</option>
					<c:forEach var="size" items="${sizes }">
						<option value="${size.iD }">${size.name }</option>
					</c:forEach>
				</select>
			</div>


			<div class="col-md-2 comboboxFilter ">
				<select id="materialFilter" class="form-control">
					<option selected value="0">Chất liệu</option>
					<c:forEach var="material" items="${materials }">
						<option value="${material.iD }">${material.name }</option>
					</c:forEach>
				</select>
			</div>

			<div class="col-md-2 comboboxFilter ">
				<select id="producerFilter" class="form-control">
					<option selected value="0">Nhà SX</option>
					<c:forEach var="producer" items="${producers }">
						<option value="${producer.iD }">${producer.name }</option>
					</c:forEach>
				</select>
			</div>

			<div class="col-md-3 col-xs-12">
				<div class="col-xs-12">
					<input id="searchContent" class="form-control txtSearch"
						type="text" placeholder="Nhập tên SP">
				</div>
			</div>
		</div>


		<div class="slidebar col-md-2 container-fluid" style="overflow-y:scroll; height: 500px;">
			<p style="padding-left: 25px; padding-top: 15px; font-size: 14px;">DANH
				MỤC SẢN PHẨM</p>
			<a id="${currentType==0?'activeSlideItem':'' }"
				class="slideItem col-md-12" style="text-transform: uppercase;"
				href="/VerOne/shopping/type/0"> TẤT CẢ <input type="hidden"
				value="0" />
			</a>
			<c:forEach var="type" items="${types }">
				<a id="${currentType == type.iD?'activeSlideItem':'' }"
					class="slideItem col-md-12" style="text-transform: uppercase;"
					href="/VerOne/shopping/type/${type.iD }"> ${type.name } <input
					type="hidden" value="${type.iD }" />
				</a>
			</c:forEach>
		</div>


		<div class="productWrapper col-md-12">

			<div class="product col-md-10 col-md-offset-2">

				<c:if test="${fn:length(list) lt 1}">
					<h3 style="text-align: center">Không có sản phẩm nào</h3>
				</c:if>

				<c:forEach var="product" items="${list }">

					<div class="col-md-3 col-xs-6">
						<div class="productWrap" style="position: relative;">
							<a href="/VerOne/product/${product.iD}">
								<div class="crop col-xs-12 col-md-12">
									<img class="img-responsive col-xs-12 col-md-12"
										src="data:image/png;base64,${product.base64}"
										alt="${product.name }">
								</div>
								<p class="startingPrice">
									Giá chỉ<br />
									<c:choose>
										<c:when test="${product.discount > 0}">
											<span style="text-decoration: line-through;"><fmt:formatNumber
													value="${product.price}" type="currency" currencySymbol=""
													minFractionDigits="0" /></span>
											<br />
											<span style="color: red;"><fmt:formatNumber
													value="${product.price - product.price*product.discount/100 }"
													type="currency" currencySymbol="" minFractionDigits="0" /></span>
										</c:when>
										<c:otherwise>
											<fmt:formatNumber value="${product.price}" type="currency"
												currencySymbol="" minFractionDigits="0" />
										</c:otherwise>
									</c:choose>
								</p>
								<h5 class="productName">${product.name }</h5>
							</a>
						</div>
					</div>
				</c:forEach>
				<div class="col-xs-12" style="text-align: center">
					<c:if test="${pageNums > 1 }">
						<ul class="pagination pagination">
							<c:forEach begin="0" end="${pageNums - 1}" varStatus="loop">
								<li class="pageItem ${loop.index+1 == page?'active':'' } "><a
									href="#"><span class="badge">${loop.index + 1}</span></a></li>
							</c:forEach>
						</ul>
					</c:if>
				</div>
			</div>


		</div>

	</div>
	</div>


	<footer class="col-md-10 col-md-offset-2"
		style="z-index: 99999999999999;">
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