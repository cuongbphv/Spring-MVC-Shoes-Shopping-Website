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
	document.getElementsByClassName('orderWrap')[0].setAttribute("style","margin-top:" + height + "px");
}

function showOrderInfo(){
	
	document.getElementById("allOrder").innerHTML = '<div style="display:block; background-color:white;" class="loader"></div>';
	
	var numDays = $("#comboboxFilter").val();
	
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("allOrder").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/showOrderInfo/"+numDays, true);
	  xhttp.send();
}

$(document).ready(function() {
	showOrderInfo();
	
	$("#comboboxFilter").change(function(){
		
		showOrderInfo();
	});
	
});
