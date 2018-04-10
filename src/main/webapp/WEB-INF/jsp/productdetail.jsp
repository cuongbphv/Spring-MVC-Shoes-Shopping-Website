<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.mvp.model.Account" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/nav.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/productdetail.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/myweb/css/footer.css" />">
<link href="https://fonts.googleapis.com/css?family=Lora"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>
<script src="<c:url value="/resources/myweb/js/nav.js" />"
	type="text/javascript" charset="utf-8"></script>
<script src="<c:url value="/resources/myweb/js/productdetail.js" />"
	type="text/javascript" charset="utf-8"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
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
<title>GREATS - Chi tiết sản phẩm</title>
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
							<li class="item"><a href="/VerOne/shopping/hotproduct">NỔI BẬT</a></li>
							<li class="item"><a href="/VerOne/shopping/hotsaleproduct">BÁN CHẠY</a></li>
							<li class="item"><a href="/VerOne/shopping/discountproduct">GIẢM GIÁ</a></li>
							<li class="item"><a href="/VerOne/about">VỀ CHÚNG TÔI</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>

	<div class="productDetailWrap container">
		<div class="row">
			<div class="aboutProduct col-md-12">
				<div class="imageProductWrap col-md-6 clearfix">

				
						<div class="crop col-xs-12 col-md-12">
							<img style="visibility:hidden" class="img-responsive"
								src="data:image/png;base64,${image[0].base64}"
								alt="${image[0].productID}">
								
							<div class="tiles">

					    		<div class="tile" data-scale="2.0" data-image="data:image/png;base64,${image[0].base64}">
					    		${image[0].colorID == null?'Chưa có hình':''}
					    		</div>
					    	</div>
						</div>
						
						<div  style="text-align:center;" class="otherSide col-xs-12 col-md-12" style="z-index:49">	
							<div  class="justify">
							
							<c:forEach var="imageItem" items="${image}" varStatus="loop">
							
								<div class="crop2 ortherItem">
								<img class="img-responsive" 
									src="data:image/png;base64,${imageItem.base64}">
								</div>
							</c:forEach>
																
							</div>								
						</div>
						
					
				</div>
				<div id="pID" style="display: none;">${product.iD}</div>
				<div class="col-md-6">
					<div class="col-xs-12 clearfix">
					<a href="">
						<h2 style="text-align: center; text-transform: uppercase; font-weight:bold;">${product.name }
							<c:if test = "${numsStar!=0 }">
							- ${numsStar } <img
								style="width: 24px; height: 24px; margin-bottom: 8px"
								src="<c:url value="/resources/myweb/img/fullstar.png" />">
							</c:if>
						</h2>
					</a>
						<h4 class="price col-xs-12">
							GIÁ:
							<c:choose>
								<c:when test="${product.discount > 0}">
									<span style="text-decoration: line-through;"><fmt:formatNumber
											value="${product.price}" type="currency" currencySymbol=""
											minFractionDigits="0" /></span>
									<span style="color: red;"><fmt:formatNumber
											value="${product.price - product.price*product.discount/100 }"
											type="currency" currencySymbol="" minFractionDigits="0" /></span>
								</c:when>
								<c:otherwise>
									<fmt:formatNumber value="${product.price}" type="currency"
										currencySymbol="" minFractionDigits="0" />
								</c:otherwise>
							</c:choose>
						</h4>
						
						<!-- 							<select id="comboboxColor" class="form-control">
								<option disabled selected hidden value="0">Màu</option>
								<c:forEach var="item" items="${color}">
									<option value="${ item.iD }">${item.name}</option>
								</c:forEach>  
							</select> -->
						
<!--						<div class="colour col-md-12 clearfix">
	
							<div class="col-xs-2">
								<div class="colorSubItem">
								 	<img style="width:50px;height:50px;" class="colorSubItemImg" src="<c:url value="/resources/myweb/img/xanh-den.png" />" >
								</div>
							</div>
							<div class="col-xs-2">
								<div class="colorSubItem">
								 	<img style="width:50px;height:50px;" class="colorSubItemImg" src="<c:url value="/resources/myweb/img/vang-do.png" />" >
								</div>
							</div>
							<div class="col-xs-2">
								<div class="colorSubItem">
								 	<img style="width:50px;height:50px;" class="colorSubItemImg" src="<c:url value="/resources/myweb/img/tim-xam.png" />" >
								</div>
							</div>
							<div class="col-xs-2">
								<div class="colorSubItem">
								 	<img style="width:50px;height:50px;" class="colorSubItemImg" src="<c:url value="/resources/myweb/img/trang-xam.png" />" >
								</div>
							</div>
							
							<div class="col-xs-2">
								<div class="colorSubItem">
								 	<img style="width:50px;height:50px;" class="colorSubItemImg" src="<c:url value="/resources/myweb/img/trang-xam.png" />" >
								</div>
							</div>
							
						</div> -->
						<div style="text-align:center;" class="colour col-md-12 clearfix">

  							<c:forEach var="colorItem" items="${color}" varStatus="loop">
							
								<div style="display:inline-block;" class="colorSubItem ">
								 	<img style="width:50px;height:50px;" class="colorSubItemImg ${loop.index==0?'activeColor':'' }" 
								 	src="data:image/png;base64,${colorItem.base64}" >
								 	<p class="hide colorValue">${colorItem.iD }</p>
								 	<p class="hide colorName">${colorItem.name }</p>
								</div>
							</c:forEach>

						</div>
						
						<p id="pickedColor" style="text-align:center;" class="col-md-12">${color[0].name }</p>
							
						<h3 class="size  col-md-3 col-xs-3 clearfix"><span id="sizeValue">SIZE</span> 
						<span class="arrow glyphicon glyphicon-menu-down"></span>

<!-- 							<select id="comboboxSize" class="form-control">
								<option disabled selected hidden value="0">Size</option>
								<c:forEach var="item" items="${size}">
									<option value="${item.iD }">${item.name}</option>
								</c:forEach>
							</select> -->
							
						</h3>
						<a><div id="submitAddToCart" class="btnAddtocart col-md-8 col-xs-8">
								THÊM VÀO GIỎ HÀNG</div></a>
						<div style="text-align:center;" class="sizeWrap col-md-offset-1 col-md-10 clearfix">
							
 							<c:forEach var="sizeItem" items="${size}">
							
								<div style="display:inline-block;" class="sizeSubItem">
								 	<a><h3>${sizeItem.name }</h3></a>
								 	<p class="hide">${sizeItem.iD }</p>
								</div>
								
							</c:forEach>

						</div>
					</div>
					<div class="col-md-12 clearfix">
						<h2 class="col-md-12">Chi tiết sản phẩm:</h2>
						<div class="detailItem col-md-6">Loại giày:
							${product.productType.name }</div>
						<div class="detailItem col-md-6">Chất liệu:
							${product.material.name }</div>
						<div class="detailItem col-md-6">Nhà sản xuất:
							${product.producer.name }</div>
						<div class="detailItem col-md-6">Giới tính: Nam</div>
						<h2 class="description col-md-12">Mô tả chi tiết:</h2>
						<h4 class="col-md-12">${product.description }</h4>
					</div>
				</div>
			</div>

			<div class="userComment col-md-12 col-xs-12">
				<div class="col-md-12 col-xs-12">
					<h2 style="">Đánh giá và nhận xét:</h2>
				</div>
				<div class="commentAndRating col-md-8">
					<div class="col-md-12">
						<h4>Xin vui lòng chia sẻ đánh giá của bạn về sản phẩm này:</h4>
					</div>
					<div class="rating col-md-12">
						<div class="">Đánh giá sản phẩm này:</div>
						<div onmouseleave="ratehover(-1);" class="stars">
							<div onmouseenter="ratehover(0);" onclick="rated(0);"
								class="starItem">
								<img src="<c:url value="/resources/myweb/img/star.png" />"
									alt="">
							</div>
							<div onmouseenter="ratehover(1);" onclick="rated(1);"
								class="starItem">
								<img src="<c:url value="/resources/myweb/img/star.png" />"
									alt="">
							</div>
							<div onmouseenter="ratehover(2);" onclick="rated(2);"
								class="starItem">
								<img src="<c:url value="/resources/myweb/img/star.png" />"
									alt="">
							</div>
							<div onmouseenter="ratehover(3);" onclick="rated(3);"
								class="starItem">
								<img src="<c:url value="/resources/myweb/img/star.png" />"
									alt="">
							</div>
							<div onmouseenter="ratehover(4);" onclick="rated(4);"
								class="starItem">
								<img src="<c:url value="/resources/myweb/img/star.png" />"
									alt="">
							</div>
							<div id="starcmt" class="countstar">Click chọn số sao</div>
						</div>
					</div>
					<div class="comment col-md-12">
						<div class="">Tiêu đề nhận xét:</div>
						<div class="titlebox">
							<input class="form-control class= type=" text" id="titlecmt"
								placeholder="Nhập tên tiêu đề">
						</div>
						<div>Nội dung nhận xét:</div>
						<div class="commentcontent">
							<textarea class="form-control" rows="5" id="contentcmt"
								placeholder="Nội dung bình luận"></textarea>
						</div>
						<a><div id="sendCmt"
								class="btnSendcmt btn btn-success col-md-6 col-md-offset-6 col-xs-12">
								Gửi bình luận</div></a>
					</div>


				</div>
				<div class="commentNotice col-md-4"></div>

			</div>

			<div class="commented col-md-12 col-xs-12">
				<div class="col-md-12 col-xs-12">
					<h2 style="">Nhận xét về sản phẩm:</h2>
				</div>
				<div class="commentedContent col-md-8 col-xs-12">
					<div class="media">
						<div id="commentLoader" class="media-body">
							<h3>Hiện chưa có bình luận nào cho sản phẩm này</h3>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-12 alsolike text-center">
				<div class="col-md-12 col-xs-12">
					<h3 style="font-style: italic;">Có thể bạn sẽ thích</h3>
				</div>

				<c:forEach var ="item" items = "${productList }">

					<div class="col-md-3 col-xs-6">
						<div class="productWrap" style="position: relative;">
							<a href="/VerOne/product/${item.iD}">
								<div class="crop1 col-xs-12 col-md-12">
									<img class="img-responsive col-xs-12 col-md-12"
										src="data:image/png;base64,${item.base64}" alt="${item.name }">
								</div>
								<p class="startingPrice">
									Giá chỉ<br />
									<c:choose>
										<c:when test="${item.discount > 0}">
											<span style="text-decoration: line-through;"><fmt:formatNumber
													value="${item.price}" type="currency" currencySymbol=""
													minFractionDigits="0" /></span>
											<br />
											<span style="color: red;"><fmt:formatNumber
													value="${item.price - item.price*item.discount/100 }"
													type="currency" currencySymbol="" minFractionDigits="0" /></span>
										</c:when>
										<c:otherwise>
											<fmt:formatNumber value="${item.price}" type="currency"
												currencySymbol="" minFractionDigits="0" />
										</c:otherwise>
									</c:choose>
								</p>
								<h5 class="productName">${item.name }</h5>
							</a>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
		<!-- <div class="row">
				<div class="col-md-3">
					<div class="productWrap" style="position: relative;">
						<a href="#product">
						<img class="img-responsive" src="img/men.jpg" alt="">
						<p class="startingPrice">Starting at<br/>$50</p>
						<h5 class="productName">MEN ROTALE BRANCO TRIPLE</h5></a>
					</div>
				</div>
			</div> -->
	</div>
	<hr />
		<footer class="container-fluid clearfix">
        <div class="row footerWrap">
            <div class="col-xs-6 col-md-6">
            <h5 style="text-align: center" ><i>Hỗ trợ khách hàng</i></h5>
                <div class="contact">
                   <ul class="ul-contact">
                        <div class="center-all-1">                         
                                <li><a href="/VerOne/guarantee"><img src="<c:url value="/resources/myweb/img/faq.png" />" alt="no logo"><p class="mobilehidden">FAQ</p></a></li>
                                <li><a href="/VerOne/guarantee"><img src="<c:url value="/resources/myweb/img/support.png" />" alt="no logo"><p class="mobilehidden">Hỗ trợ</p></a></li>
                                <li><a href="/VerOne/guarantee"><img src="<c:url value="/resources/myweb/img/ship.png" />" alt="no logo"><p class="mobilehidden">Bảo hành</p></a></li>
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