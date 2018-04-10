function LoadPage(){
	fixedNav();
	calTotalprice();
}

function Resize(){
	fixedNav();
}

function fixedNav()
{
	var height = document.getElementsByClassName('headerWrap')[0].offsetHeight;

	height += 10;
	document.getElementsByClassName('orderDetailWrap')[0].setAttribute("style","margin-top:" + height + "px");
}

function calTotalprice()
{
	var prices = document.getElementsByClassName('productprice');

	var countItems = document.getElementsByClassName('countItem');
	var totalPrice = 0;
	for (var i = 0; i < prices.length; i++) {
		totalPrice += (prices[i].innerText.replace(",",""))*(countItems[i].value);
	}

	$("#TotalPriceCart").html('TỔNG TIỀN: '+totalPrice + ' VND');
}

$(document).ready(function(){
	
	$("#cancelOrder").click(function(){
		
		var orderID = $("#orderID").val();
		
		$.confirm({
		    title: 'Thông báo!',
		    content: 'Bạn chắc chắn hủy đơn hàng này không?',
		    buttons: {
		        'Tiếp tục': function () {
		        	var xhttp; 
		  		  
		  		  xhttp = new XMLHttpRequest();
		  		  xhttp.onreadystatechange = function() {
		  		    if (this.readyState == 4 && this.status == 200) {
		  		     var msg = this.responseText;
		  	        	$.alert({
		  		    	    title: 'Thông báo!',
		  		    	    content: msg
		  		    	});
		  	        	setTimeout(function(){
		  	        		location.reload();
		                 }, 5000);
		  		     
		  		    }
		  		  };
		  		  xhttp.open("GET", "/VerOne/cancelorder/"+orderID, true);
		  		  xhttp.send();
		  		  
		        },
		        'Hủy bỏ': function () {
		        }
		    }
		});
		 
		
	});
	
});