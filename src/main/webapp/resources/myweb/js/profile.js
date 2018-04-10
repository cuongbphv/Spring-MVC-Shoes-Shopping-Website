function LoadPage(){
	fixedNav();
}

function Resize(){
	fixedNav();
}

function fixedNav()
{
	var height = document.getElementsByClassName('headerWrap')[0].offsetHeight;

	height+=10;
	document.getElementsByClassName('profileWrap')[0].setAttribute("style","margin-top:" + height + "px");
}



function getInfo() {
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("1a").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/profileInfo", true);
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
	  xhttp.open("GET", "/VerOne/loadSubAdd", true);
	  xhttp.send();
	
}


$(document).ready(function() {
	getInfo();
	
	
	$("#1a").on("click", "#showAdd", function(){
		 $('.otherAddress').slideToggle(500);
	});

	$("#1a").on("click", ".defaultAdd", function(){
		var txt = $(this).parent().text();
		$("#address").text(txt);
	});
	
	
	$("#1a").on("click", "#btnEnableEdit", function(){
		var inputs = document.getElementsByClassName('itemInfo');
		
		for (var i = 0; i < inputs.length; i++) {
			inputs[i].disabled = false;
		}
		
		$(".btnControl").css("display","block");
		
	});
	
	
	$("#1a").on("click", "#btnSubmitEdit", function(){
	    var formData = new FormData($('#frmInfo')[0]);;
		
	    var address = $("#address").val();
		
		if(address.length < 20){
			$.alert({
	    	    title: 'Thông báo!',
	    	    content: 'Địa phải dài hơn 20 ký tự!'
	    	});
		}
		else{
	    $.ajax({
	        url: "/VerOne/editProfile",
	        type: "POST",
	        dataType: 'text',
	        contentType: false,
	        processData: false,
	        cache: false,
	        data: formData,
	        success: function(response) {
	            $.alert({
		    	    title: 'Thông báo!',
		    	    content: response
		    	});
	            if(response == "Cập nhật thành công!"){
	            	var inputs = document.getElementsByClassName('itemInfo');

	        		for (var i = 0; i < inputs.length; i++) {
	        			inputs[i].disabled = true;	        		
	        		}
	        		loadSubAddress();
	        		$(".btnControl").css("display","none");
	        		$('.otherAddress').hide();
	        		
	            }
	        },
	        error: function() {
	            $.alert({
		    	    title: 'Thông báo!',
		    	    content: 'Đã xảy ra lỗi khi cập nhật, vui lòng kiểm tra lại thông tin nhập!'
		    	});
	        }
	    });
		}
	});
	
	
	$("#1a").on("click", ".btnAddAddress", function(){
	    
		
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
	
	$("#1a").on("click", ".btnDeleteAddress", function(){
	    
		var address = $(this).parent().siblings().eq(0).text();

	    $.ajax({
	        url: "/VerOne/deleteSubAdd",
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
	            }
	        },
	        error: function() {
	            $.alert({
    	    	    title: 'Thông báo!',
    	    	    content: 'Đã xảy ra lỗi khi xóa, vui lòng thử lại!'
    	    	});
	        }
	    });
	});
	
	$("#2a").on("click", "#btnSubmitChange", function(){
	    var formData = new FormData($('#frmChangePass')[0]);;
		
	    $.ajax({
	        url: "/VerOne/changePass",
	        type: "POST",
	        dataType: 'text',
	        contentType: false,
	        processData: false,
	        cache: false,
	        data: formData,
	        success: function(response) {
	            if(response == "Cập nhật thành công!"){
	            	$.alert({
	    	    	    title: 'Thông báo!',
	    	    	    content: response
	    	    	});
	            	$("#frmChangePass").trigger('reset');
	            	$("#passErr").css("display","none");
	            }
	            else{
	            	$("#passErr").text(response);
	            	$("#passErr").css("display","block");
	            }
	        },
	        error: function() {
	            $.alert({
    	    	    title: 'Thông báo!',
    	    	    content: 'Đã xảy ra lỗi khi cập nhật, vui lòng kiểm tra lại thông tin nhập!'
    	    	});
	        }
	    });
	});

	
	
	
	
});

