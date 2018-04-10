function LoadPage(){
	fixedNav();
	calTotalprice()
}

function Resize(){
	fixedNav();
}

function fixedNav()
{
	var height = document.getElementsByClassName('headerWrap')[0].offsetHeight;

	height += 10;
	document.getElementsByClassName('cartWrap')[0].setAttribute("style","margin-top:" + height + "px");
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


function deleteCartProduct(x){
	document.getElementsByClassName('cartProduct')[x].style.display='none';
	document.getElementsByClassName('countItem')[x].value = 0;
	calTotalprice();
}


function showCart(){
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("cartWrapper").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/showCart", true);
	  xhttp.send();
}

function setItems(){
	

}


$(document).ready(function() {
	showCart();
	
	$("#cartWrapper").on('change','.countItem',(function(){
	    var count = $(this).val();
	    
	    var pID = $(this).parent().siblings("div:first-child").find(".pID").text();
	    var colorID = $(this).parent().siblings("div:nth-child(3)").children("div:first-child").text();
	    var sizeID =$(this).parent().siblings("div:nth-child(4)").find(".sizeID").text();
	    
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    if(this.responseText != ""){
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		    }
		     showCart();
		    }

		  };
		  xhttp.open("GET", "/VerOne/setNumOrdered/"+pID+"/"+colorID+"/"+sizeID+"/"+count, true);
		  xhttp.send();
	}));
	
	$("#cartWrapper").on('click','.removeOrder',(function(){
	    var count = 0;
	    
	    var pID = $(this).parent().siblings("div:first-child").find(".pID").text();
	    var colorID = $(this).parent().siblings("div:nth-child(3)").children("div:first-child").text();
	    var sizeID =$(this).parent().siblings("div:nth-child(4)").find(".sizeID").text();
	    
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    if(this.responseText != ""){
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		    }
		     showCart();
		     getItemsNumber();
		    }

		  };
		  xhttp.open("GET", "/VerOne/setNumOrdered/"+pID+"/"+colorID+"/"+sizeID+"/"+count, true);
		  xhttp.send();
	}));
	
});

