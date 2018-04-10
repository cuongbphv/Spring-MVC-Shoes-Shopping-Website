<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<%@page import="com.mvp.model.Account" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="<c:url value="/resources/myweb/css/nav.css" />">
  <link rel="stylesheet" href="<c:url value="/resources/myweb/css/about.css" />">
  <link rel="stylesheet" href="<c:url value="/resources/myweb/css/footer.css" />">
  <link href="https://fonts.googleapis.com/css?family=Lora" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="<c:url value="/resources/myweb/js/nav.js" />" type="text/javascript" charset="utf-8"></script>
  <script src="<c:url value="/resources/myweb/js/about.js" />" type="text/javascript" charset="utf-8"></script>

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
  <title>GREATS - Về chúng tôi</title>
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
                        <div><a href="/VerOne/home"><img class="img-responsive" id="imgLogo" src="<c:url value="/resources/myweb/img/logo.png" />" alt=""></a></div>
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

        <div class="aboutWrap container">
            
            <div class="row">
                <h1 style="text-align:center;font-weight: 100">VỀ CHÚNG TÔI</h1>
                     <div class="slogan">
                        <p id="sloganContent"><b>GREATS</b> - <i>"Luôn luôn dẫn đầu xu thế"</i></p>
                    </div>
            </div>


            <div class="line col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2"></div>

            <div class="row">
                <h2 class="col-xs-12" style="text-align:center;">KINH NGHIỆM</h2>
            </div>
                
            <div class="info row">
                
                

                <div style="clear: both;" class="col-md-6 col-xs-12 director">
                    <div class="col-xs-5">
                        <img class="img-responsive" id="directorAvatar" src="http://www.clker.com/cliparts/7/4/c/4/1446118397610284725jobs.png" alt="">
                    </div>
                    <div class="col-xs-7">
                        <p class="directorInfo">- Steve Jobs</p>
                        <p class="directorInfo">- 21 năm trong lĩnh vực kinh doanh</p>
                        <p class="directorInfo">- Từng là giám đốc 5 công ty</p>
                        <p class="directorInfo">- Thành viên của hội kinh doanh quốc gia</p>
                        <p class="directorInfo">- Đạt giải vàng kinh doanh</p>
                    </div>
                </div>
                
                <div class="col-xs-12 col-md-6 company">
                        <p class="companyInfo">
                            Qua hơn 33 năm hoạt động sản xuất kinh doanh với bao thăng trầm và thách thức, giờ đây, GREATS đã lớn mạnh và phát triển đi lên cùng đất nước, trở thành một thương hiệu uy tín, tin cậy và quen thuộc với người tiêu dùng và là niềm tự hào của người Việt Nam về một “Thương hiệu Quốc gia” trong lĩnh vực Giày dép uy tín và chất lượng.
                        </p>
                </div>
                
                <div class="row clearfix">
                    <h2 style="text-align:center;">CHUYÊN NGHIỆP</h2>
                </div>

                <div class="col-xs-12 banner clearfix">
                    <img src="http://bitis.com.vn/35nam/resources/images/banner.jpg" alt="">
                </div>
                

                <div style="padding-top: 35px;" class="col-xs-12 company">
                        <p class="companyInfo">
                            Với đội ngũ nhân viên kỹ thuật có trình độ cao, có kiến thức chuyên môn và dày dặn kinh nghiệm làm việc dưới sự hướng dẫn của các chuyên gia nước ngoài rất giỏi trong lĩnh thời trang giày dép đã cùng nhau tạo nên một công ty lớn mạnh và mở rộng hoạt động trên phạm vi toàn quốc. Công ty chúng tôi luôn chú trọng đến sự phát triển của công nghệ và xu hướng mới nhất của thị trường để từ đó tìm ra giải pháp tốt nhất cung cấp cho khách hàng những sản phất tốt nhất, đẹp nhất, chất lượng nhất và giá cả cạnh tranh nhất.
                        </p>
                </div>

                <div class="row clearfix">
                    <h2 style="text-align:center;">QUY MÔ</h2>
                </div>

                <div class="row info">
                    
                    <div class="widelyWrap col-xs-10 col-xs-offset-1">
                        
                        <div class="widelyItem">
                            <p class="head">63</p>
                            <p class="sub">TỈNH THÀNH</p>
                        </div>
                        
                        <div class="widelyItem">
                            <p class="head">84</p>
                            <p class="sub">CHI NHÁNH</p>
                        </div>

                        <div class="widelyItem">
                            <p class="head">50+</p>
                            <p class="sub">THƯƠNG HIỆU</p>
                        </div>

                    </div>

                </div>


                <div style="padding-top: 20px" class="row clearfix">
                    <h2 style="text-align:center;">THÔNG TIN LIÊN HỆ</h2>
                </div>
                
                <div class="row info">
                    
                    <div class="contactInfo col-xs-10 col-xs-offset-1">
                        
                        <div class="address col-xs-12 col-md-6">
                            <p class="contactItem">Địa chỉ: 1 Võ Văn Ngân, P.Linh Chiểu, Q.Thủ Đức</p>
                            <p class="contactItem">Facebook: facebook.com/MVPShop</p>
                            <p class="contactItem">Hot-line: 0163989922 - 0821925232</p>
                        </div>

                        <div class="col-xs-12 col-md-6">
                            <p class="contactItem">Ngày bình thường: 7:00 am - 16h30 pm</p>
                            <p class="contactItem">Chủ nhật: Nghỉ làm</p>
                            <p class="contactItem">Ngày lễ: 7:00 am - 11:00 am</p>
                        </div>

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