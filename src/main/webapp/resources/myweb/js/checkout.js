function LoadPage(){
	fixedNav();
}

function Resize(){
	fixedNav();
}

function fixedNav()
{
	var height = document.getElementsByClassName('headerWrap')[0].offsetHeight;

	height += 10;
	document.getElementsByClassName('checkoutWrap')[0].setAttribute("style","margin-top:" + height + "px");
}


function checkOutPrice() {
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("loadPrice").innerHTML =  this.responseText ;
	    }
	  };
	  xhttp.open("GET", "/VerOne/checkoutprice", true);
	  xhttp.send();
}

function loadSubAddress(){

	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("subAddWrap").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/loadSubAddExMain", true);
	  xhttp.send();
}

$(document).ready(function() {
	
	$("#discountLabel").click(function(){
		$("#discountInput").css("display","block");
		$(this).css("display","none");
	});


	$(".btnApplydiscount").click(function(){
		
		var discountCode = $("#textBox").val();
		
		 var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	if(this.responseText.split("/")[0] == "Áp dụng mã thành công!"){
		    		$("#textBox").css("display","none");
		    		$("#discountCode").text(discountCode + this.responseText.split("/")[1]);
		    		$("#discountCode").css("display","inline-block");
		    		$(".btnApplydiscount").css("display","none");
		    		checkOutPrice();
		    	}
		    	else{
		    		var msg = this.responseText;
		        	$.alert({
			    	    title: 'Thông báo!',
			    	    content: msg
			    	});
		    	}
		    		
		    }
		  };
		  xhttp.open("GET", "/VerOne/setDiscountCode/"+discountCode, true);
		  xhttp.send();
		
//		$("#discountCode").text($("#textBox").val());
//
//
//		$("#discountCode").css("display","inline-block");
//		$(this).css("display","none");

	});
	
	$("#btnOrder").click(function(){
	
		var address  = $("#address").text();
  
		    $.ajax({
		        url: "/VerOne/setOrder",
		        type: "POST",
		        dataType: 'text',
		        data: {address:address},
		        success: function(response) {
		        	var msg = response;
		        	$.alert({
			    	    title: 'Thông báo!',
			    	    content: msg
			    	});
			    	if(response == "Đặt hàng thành công"){
			    		window.location.replace("/VerOne/orderinfo");
			    	}
		        },
		        error: function() {
		        	$.alert({
			    	    title: 'Thông báo!',
			    	    content: 'Đã xảy ra lỗi khi thêm, vui lòng kiểm tra lại thông tin nhập!'
			    	});
		        }
		    });
		  
		
	});
	
	checkOutPrice();
	
	$('#changeAddress').click(function(){
		loadSubAddress();
		 $(".address").slideToggle(500);
	});
	
	$("#subAddWrap").on("click", ".defaultAdd", function(){
		var txt = $(this).parent().text();
		$("#address").text(txt);
	});
	
	
	$(".address").on("click", ".btnAddAddress", function(){
	    
		
		var address = $("#newAddress").val();
		
		if(address.length < 20){
			$.alert({
	    	    title: 'Thông báo!',
	    	    content: 'Địa phải dài hơn 20 ký tự!'
	    	});
		}
		else{
		    $.ajax({
		        url: "/VerOne/addNewAdd",
		        type: "POST",
		        dataType: 'text',
		        data: {address:address},
		        success: function(response) {
		            if(response != " "){
		            	$.alert({
		    	    	    title: 'Thông báo!',
		    	    	    content: response
		    	    	});
		            }
		            else{
		            	loadSubAddress();
		            	$("#newAddress").val("");
		            }
		        },
		        error: function() {
		            $.alert({
	    	    	    title: 'Thông báo!',
	    	    	    content: 'Đã xảy ra lỗi khi thêm, vui lòng kiểm tra lại thông tin nhập!'
	    	    	});
		        }
		    });
		}
	});

});