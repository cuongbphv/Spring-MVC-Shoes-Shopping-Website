function LoadPage(){
	fixedNav();
}

function Resize(){
	fixedNav();
}

function fixedNav()
{
	var height = document.getElementsByClassName('headerWrap')[0].offsetHeight;

	height -= 10;
	document.getElementsByClassName('saleWrap')[0].setAttribute("style","margin-top:" + height + "px");
}

function filterProduct(productType,colorID,sizeID,materialID,producerID,searchContent,page){
	$.ajax({
		async: true,
        url: "/VerOne/searchproduct",
        type: "POST",
        data: {
        	productType:productType,
        	colorID:colorID,
        	sizeID:sizeID,
        	materialID:materialID,
        	producerID:producerID,
        	searchContent:searchContent,
        	page:page
        },
        success: function(response) {
        	$(".productWrapper").eq(0).html(response);
        },
        error: function() {
            $.alert({
	    	    title: 'Thông báo!',
	    	    content: 'Đã xảy ra lỗi tìm kiếm, vui lòng kiểm tra lại thông tin nhập!'
	    	});
        }
    });
}


function filter(){
	var productType = $("#activeSlideItem").find("input").eq(0).val();
	var page = 1;
	var colorID = $("#colorFilter").val();
	var sizeID = $("#sizeFilter").val();
	var materialID = $("#materialFilter").val();
	var producerID = $("#producerFilter").val();
	var searchContent = $("#searchContent").val();
	
	if(productType == null || productType == "")
		productType = 0;
	
	if(searchContent == null || searchContent == "")
		  searchContent = 0;
	
	var hr = window.location.href;
	if(hr.includes("hotproduct"))
		productType = -1;
	else if(hr.includes("hotsaleproduct"))
		productType = -2;
	else if(hr.includes("discountproduct"))
		productType = -3;
	
	if(productType == 0)
		$(".slideItem").eq(0).attr('id','activeSlideItem');

	filterProduct(productType,colorID,sizeID,materialID,producerID,searchContent,page);
}

$(document).ready(function(){
			
	$("#colorFilter, #sizeFilter, #materialFilter, #producerFilter").change(function(){
		filter();
	});
	
	$("#searchContent").keyup(function(){
		filter();
	})
	
	
	$(".productWrapper").eq(0).on('click','.pageItem',function(){
		
		var productType = $("#activeSlideItem").find("input").eq(0).val();
		var page = $(this).find(".badge").eq(0).text();
		var colorID = $("#colorFilter").val();
		var sizeID = $("#sizeFilter").val();
		var materialID = $("#materialFilter").val();
		var producerID = $("#producerFilter").val();
		var searchContent = $("#searchContent").val();
		
		if(productType == null || productType == "")
			productType = 0;
		
		if(searchContent == null || searchContent == "")
			  searchContent = 0;
		
		filterProduct(productType,colorID,sizeID,materialID,producerID,searchContent,page);
		
	});
	
	
	
});