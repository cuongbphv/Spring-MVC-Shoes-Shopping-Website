<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.mvp.model.Account" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="<c:url value="/resources/myweb/css/nav.css" />">
  <link rel="stylesheet" href="<c:url value="/resources/myweb/css/CheckOut.css" />">
  <link rel="stylesheet" href="<c:url value="/resources/myweb/css/footer.css" />">
  <link href="https://fonts.googleapis.com/css?family=Lora" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>
  <script src="<c:url value="/resources/myweb/js/nav.js" />" type="text/javascript" charset="utf-8"></script>
  <script src="<c:url value="/resources/myweb/js/checkout.js" />" type="text/javascript" charset="utf-8"></script>

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
  <title>Xác nhận đặt hàng</title>
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

		<div class="checkoutWrap container">
			<div style="text-align: center;" class="col-xs-12"><h3>XÁC NHẬN ĐẶT HÀNG</h3></div>
			<div class="row">
				
				<div class="customerInfo col-md-5 col-xs-12">
					<div style="padding: 10px 0; border-bottom: 1px solid #c0c0c0" class="col-xs-12"><b>Thông tin giao hàng:</b></div>
					<div class="info col-xs-12">
						<div class="col-xs-4">Mã khách hàng:</div>
						<div id="cusID" class="col-xs-8">${cus.cusID}</div>
					</div>					
					<div class="info col-xs-12">
						<div class="col-xs-4">Tên khách hàng:</div>
						<div class="col-xs-8">${cus.name}</div>
					</div>
					<div class="info col-xs-12">
						<div class="col-xs-4">Số điện thoại:</div>
						<div class="col-xs-8">${cus.phoneNo }</div>
					</div>
					<div class="info col-xs-12">
						<div class="col-xs-4">Địa chỉ:</div>
						<div id="address" class="col-xs-8">${cus.address }</div>
					</div>
					
					<div class="otherAddress col-xs-12">
						<a id="changeAddress" class="col-xs-offset-4 col-xs-8">Chọn địa chỉ khác</a>
					</div>
					
				<div class="address col-xs-12 col-md-12" style="display:none;">
					<div id="subAddWrap">	

					</div>
						
						<div class="col-xs-12 subAddressItem">
							<div class="col-md-10">
						        <textarea id="newAddress" rows="2" class="form-control itemInfo" wrap="physical" name="otherAddress"></textarea>
						     </div>
							 <div  class="col-md-2 btnControl" style="line-height: 50px; cursor: pointer;">
					         	 <a class="btnAddAddress">Thêm</a></label>
					        </div>
						</div>
						
					</div>
					
					
					
				</div>

				<div class="orderInfo col-md-6 col-xs-12">
					<div style="padding: 10px 0; border-bottom: 1px solid #c0c0c0" class="col-xs-12"><b>Thông tin đơn hàng</b></div>
					<div class="headerProduct col-xs-12">
						<div class="col-xs-5">SẢN PHẨM</div>
						<div class="col-xs-3">SỐ LƯỢNG</div>
						<div class="col-xs-4">GIÁ</div>
					</div>
				
				<c:forEach var="it" items="${list }" varStatus="loop">
					<div class="contentProduct col-xs-12">
						<div class="col-xs-5">${it.item.name} ${it.colorItem.name} ${it.sizeItem.name}</div>
						<div class="col-xs-3">${it.numItems }</div>
						<div class="col-xs-4">
							<span><fmt:formatNumber
								value="${it.item.price - it.item.price*it.item.discount/100 }"
								type="currency" currencySymbol="" minFractionDigits="0" /> </span>
						</div>
					</div>
				</c:forEach>
				
					<div id="discountLabel" class="contentProduct col-xs-12">
						<div class="col-xs-8"><i>Bạn có mã giảm giá?</i> </div>
						<div id="showInput" class="col-xs-2"><a><i>Áp dụng</i></a></div>
					</div>
				
					<div id="discountInput" class="contentProduct col-xs-12">
						<div class="col-xs-4">Mã giảm giá</div>
						<input id="textBox" class="col-xs-3" type="text" placeholder="MGG (nếu có)"/>
						<p id="discountCode" class="col-xs-3"><b>KM02</b></p>
						<button class="btnApplydiscount col-xs-offset-1" type="button">Áp dụng</button>
					</div>
				

					<div id="loadPrice">
						<div class="tempPrice col-xs-12">
							<div class="col-xs-8">Tạm tính:</div>
							<div class="col-xs-4"><span><fmt:formatNumber value="${totalPrice}"
								type="currency" currencySymbol="" minFractionDigits="0" /> </span> VND</div>
							<div class="col-xs-8">Thuế VAT:</div>
							<div class="col-xs-4">10%</div>
						</div>
	
						<div class="totalPrice col-xs-12">
							<div class="col-xs-8"><h4><b>Tổng tiền(bao gồm VAT):</b></h4></div>
							<div class="col-xs-4"><h4 id="checkoutprice"></h4></div>
						</div>
					</div>
				</div>
				
				<div id="btnOrder" class=" button col-xs-12 col-md-offset-6 col-md-6">
					<button class="btn" style="background-color: #ea8b07;">XÁC NHẬN ĐẶT HÀNG</button>
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