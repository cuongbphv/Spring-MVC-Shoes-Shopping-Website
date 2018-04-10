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
	document.getElementsByClassName('productDetailWrap')[0].setAttribute("style","margin-top:" + height + "px");
}


var ratedstar = 0;

function ratehover(x)
{
	var stars = document.getElementsByClassName('starItem');
	if(x!=-1){
		for (var i = 0; i < 5; i++) {
			if(i<=x){
				stars[i].style.backgroundColor = '#efe521';
			}
			else
				stars[i].style.backgroundColor = 'transparent';
			document.getElementsByClassName('countstar')[0].innerHTML = x + 1 + ' sao';
		}
	}
	else
	{
		for (var i = 0; i < 5; i++) {
			if(i <= ratedstar - 1){
				stars[i].style.backgroundColor = '#efe521';
			}
			else
				stars[i].style.backgroundColor = 'transparent';
		}
		if(ratedstar != 0)
			document.getElementsByClassName('countstar')[0].innerHTML = ratedstar  + ' sao';
		else
			document.getElementsByClassName('countstar')[0].innerHTML = 'Click chọn số sao';
	}

	
}

function rated(x)
{
	ratedstar = x + 1;
}

function LoadComment(type){
	  var xhttp; 
	  var type;
	  var productID = $("#pID").text();
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("commentLoader").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/showComment/"+type+"/"+productID, true);
	  xhttp.send();
}

function LoadMainImg(){
	  $('.tile').eq(0)
	    // tile mouse actions
	    .on('mouseover', function(){
	      $(this).children('.photo').css({'transform': 'scale('+ $(this).attr('data-scale') +')'});
	    })
	    .on('mouseout', function(){
	      $(this).children('.photo').css({'transform': 'scale(1)'});
	    })
	    .on('mousemove', function(e){
	      $(this).children('.photo').css({'transform-origin': ((e.pageX - $(this).offset().left) / $(this).width()) * 100 + '% ' + ((e.pageY - $(this).offset().top) / $(this).height()) * 100 +'%'});
	    });
}




$(document).ready(function() {
	
	LoadComment("top");
	
	$("#submitAddToCart").click(function(){
		
	    var ColorId = $(".activeColor").eq(0).parent().find("p").eq(0).text();
	    if(ColorId == null || ColorId == "") ColorId = 0;
	    var SizeId = $(".activeSize").eq(0).find("p").eq(0).text();
	    if(SizeId == null || SizeId =="") SizeId = 0;
	    var pID = $("#pID").text();
	    
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		     getItemsNumber();
		     if(this.responseText != "Đã thêm sản phẩm vào giỏ hàng thành công!"){
		    	 imgclone.stop();
		    	 clearTimeout(timer);
		    	 var msg = this.responseText;
	  	        	$.alert({
	  		    	    title: 'Thông báo!',
	  		    	    content: msg
	  		    	});
		     }
		    }

		  };
		  xhttp.open("GET", "addToCart/"+pID+"/"+ColorId+"/"+SizeId, true);
		  xhttp.send();
	});
	
	$("#sendCmt").click(function(){
		
		var productID = $("#pID").text();
		var cusID = 1;
		var title = $("#titlecmt").val();
		var content = $("#contentcmt").val();

		if(ratedstar == 0){
			$.alert({
		    	    title: 'Thông báo!',
		    	    content: 'Bạn phải chọn số sao!'
		    	});
		}
		else{
			$.ajax({
				url: "/VerOne/addComment",
				type: "POST",
				dataType: 'text',
				data: {
					productID:productID,
					cusID:cusID,
					title:title,
					content:content,
					star:ratedstar
				},
				success: function(response) {
					if(response != ""){
						var msg = response;
		  	        	$.alert({
		  		    	    title: 'Thông báo!',
		  		    	    content: msg
		  		    	});
					}
					else{
						ratedstar = 0;
						ratehover(-1);
						$("#titlecmt").val("");
						$("#contentcmt").val("");
						LoadComment("top");
					}
				},
				error: function() {
	  	        	$.alert({
	  		    	    title: 'Thông báo!',
	  		    	    content: 'Đã xảy ra lỗi, vui lòng thử lại!'
	  		    	});
				}
			});
		}

	});

	

	  $('.tile')
	    // tile mouse actions
	    .on('mouseover', function(){
	      $(this).children('.photo').css({'transform': 'scale('+ $(this).attr('data-scale') +')'});
	    })
	    .on('mouseout', function(){
	      $(this).children('.photo').css({'transform': 'scale(1)'});
	    })
	    .on('mousemove', function(e){
	      $(this).children('.photo').css({'transform-origin': ((e.pageX - $(this).offset().left) / $(this).width()) * 100 + '% ' + ((e.pageY - $(this).offset().top) / $(this).height()) * 100 +'%'});
	    })
	  
	    //LoadNewImage
	  function LoadIMG(){
		  $('.tile')
		  .each(function(){
		      $(this)
		        // add a photo container
		        .append('<div class="photo"></div>')
		        // some text just to show zoom level on current item in this example
		        // set up a background image for each tile based on data-image attribute
		        .children('.photo').css({'background-image': 'url('+ $(this).attr('data-image') +')'});
		    });
	  }
	  
	  LoadIMG();
	  
function LoadImgEvent(){
		  
		  $('.tile')
		    // tile mouse actions
		    .on('mouseover', function(){
		      $(this).children('.photo').css({'transform': 'scale('+ $(this).attr('data-scale') +')'});
		    })
		    .on('mouseout', function(){
		      $(this).children('.photo').css({'transform': 'scale(1)'});
		    })
		    .on('mousemove', function(e){
		      $(this).children('.photo').css({'transform-origin': ((e.pageX - $(this).offset().left) / $(this).width()) * 100 + '% ' + ((e.pageY - $(this).offset().top) / $(this).height()) * 100 +'%'});
		    });
		  
		  $('.tile')
		  .each(function(){
		      $(this)
		        // add a photo container
		        .append('<div class="photo"></div>')
		        // some text just to show zoom level on current item in this example
		        // set up a background image for each tile based on data-image attribute
		        .children('.photo').css({'background-image': 'url('+ $(this).attr('data-image') +')'});
		    });
		  
		  $('.ortherItem').click(function(){
			  
			  $('.tile').css({'opacity': '0.2'});
			  var ImgSrc = $(this).find('.img-responsive:first-child').attr('src');
			 
			   if(loadOpacity!=null)
				   clearTimeout(loadOpacity);
			  
	          var loadOpacity = setTimeout(function () {
	     		 $('.tile').eq(0)
	     		 .attr('data-image',ImgSrc);
	     		 LoadIMG();
	     		$('.tile').css({'opacity': '1'});
	          }, 300);		  
		  });
		  
	  }
	  
	  
	  function LoadImageByColor(){
			var pID = $("#pID").text();
			var ColorId = $(".activeColor").eq(0).parent().find("p").eq(0).text();
			
			var xhttp; 
			  
			  xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			    	
			    	$(".imageProductWrap").eq(0).html(this.responseText);
			    	
			    	setTimeout(function(){
			    		LoadImgEvent();
			    	},100);
			    	
			    }

			  };
			  xhttp.open("GET", "/VerOne/getproductcolorimage/"+pID+"/"+ColorId, true);
			  xhttp.send();
			 
		}

	  
	  
	  $('.ortherItem').click(function(){
		  
		  $('.tile').css({'opacity': '0.2'});
		  var ImgSrc = $(this).find('.img-responsive:first-child').attr('src');
		 
		   if(loadOpacity!=null)
			   clearTimeout(loadOpacity);
		  
          var loadOpacity = setTimeout(function () {
     		 $('.tile').eq(0)
     		 .attr('data-image',ImgSrc);
     		 LoadIMG();
     		$('.tile').css({'opacity': '1'});
          }, 300);		  
	  });
	  
	  
	  
	  
	  
var loadOpacity	  
var imgclone;
var timer;
	    $('#submitAddToCart').on('click', function () {
	        var cart = $('.shopping-cart');
	        var cartImg  = $('#cart');
	        var imgtodrag = $('.photo').eq(0);
	        var widthImg = imgtodrag[0].offsetWidth;
	        var heightImg = imgtodrag[0].offsetHeight;
	        if (imgtodrag) {
	            imgclone = imgtodrag.clone()
	            	.offset({
	                top: 10,
	                left: imgtodrag.offset().left
	            })
	                .css({
	                'opacity': '0.7',
	                'width': widthImg,
	                'height': heightImg,
	                    'position': 'absolute',
	                    'z-index': '100000'
	            })
	                .appendTo($('.productDetailWrap'))
	                .animate({
	                'top': cartImg.offset().top - 120,
	                    'left': cartImg.offset().left,
	                    'width': 75,
	                    'height': 75
	            }, 1000, 'easeInOutExpo');
	            
	            debugger;
	            
	            timer =  setTimeout(function () {
	                cart.effect("shake", {
	                    times: 2,
	                    distance:5
	                }, 500);
	            }, 1500);

	            imgclone.animate({
	                'width': 0,
	                    'height': 0
	            }, function () {
	                $(this).detach()
	            });
	        }
	    });
	
	$(".size").click(function(){
		var deg = $(".arrow").css("transform");
		
		if(deg != "matrix3d(1, 0, 0, 0, 0, -1, 1.22465e-16, 0, 0, -1.22465e-16, -1, 0, 0, 0, 0, 1)")
			$(".arrow").css("transform","rotateX(180deg)");
		else
			$(".arrow").css("transform","rotateX(0deg)");
		$(".sizeWrap").slideToggle(300);
	});
	    
	$(".sizeSubItem").click(function(){
	
		
		$(".sizeSubItem").removeClass("activeSize");
		$(this).addClass("activeSize");
		
		var txt = $(this).find("h3").eq(0).text();
		
		$("#sizeValue").text(txt);
		
		var deg = $(".arrow").css("transform");
		if(deg != "matrix3d(1, 0, 0, 0, 0, -1, 1.22465e-16, 0, 0, -1.22465e-16, -1, 0, 0, 0, 0, 1)")
			$(".arrow").css("transform","rotateX(180deg)");
		else
			$(".arrow").css("transform","rotateX(0deg)");
		$(".sizeWrap").slideToggle(300);
		
	});
	
	$(".colorSubItemImg").click(function(){
		
		$(".colorSubItemImg").removeClass("activeColor");
		$(this).addClass("activeColor");
		
		var txt = $(this).parent().find(".colorName").eq(0).text();
		
		$("#pickedColor").text(txt)
		
		setTimeout(function(){
			LoadImageByColor();
		},100);
		 
		
	});
	
	
	
});

