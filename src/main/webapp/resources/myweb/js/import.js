

function hasDuplicates(array) {
    var valuesSoFar = Object.create(null);
    for (var i = 0; i < array.length; ++i) {
        var value = array[i];
        if (value in valuesSoFar) {
            return true;
        }
        valuesSoFar[value] = true;
    }
    return false;
}



function hasDuplicates1(array) {
	
    for (var i = 0; i < array.length - 1; i++) {
        var value = array[i];
        for(var j = i+1; j<array.length; j++){
        	if(array[j] == value)
        		return true;
        }
    }
    return false;
}


function hasNoneImg(array) {
	if(array.length < 1)
		return true;
    for (var i = 0; i < array.length; i++) {
       
    	if(array[i] == "")
    		return true;
    }
    return false;
}

function checkColorChosen(array)
{
	if(array.length < 1)
		return true;
	for (var i = 0; i < array.length; i++) {
	       
    	if(array[i] == -1)
    		return true;
    }
    return false;
}

function AddImageWithColor(){	

	var items = $("#addColor").children();
	debugger;
	var fl = true;
	items.each(function(){
		
		 var formData = new FormData($(this)[0]);
		 debugger;
		    $.ajax({
		    	//async: false,
		        url: "addColorItem",
		        type: "POST",
		        dataType: 'text',
		        contentType: false,
		        processData: false,
		        cache: false,
		        data: formData,
		        success: function(response) {
		        	fl = true;
		        },
		        error: function() {
		        	fl = false;
		        }
		    });
	});
	
	if(fl){
		$.alert({
    	    title: 'Thông báo!',
    	    content: 'Thêm hình ảnh theo màu thành công!'
    	});
	}else{
		$.alert({
    	    title: 'Thông báo!',
    	    content: 'Có lỗi khi thêm hình ảnh theo màu, kiểm tra lại thông tin nhập!'
    	});
	}
}

$(document).ready(function() {
	
	
	function LoadEvent(){
		$('#btnAddColorItem').click(function(){
						
			var obj = $('#addColor').find('.colorItem').eq(0).html();
			debugger;
			obj = "<form class='colorItem' enctype='multipart/form-data' method='POST' >" + obj + "</form>";
			debugger;
			$('#addColor').append(obj);
		});
	};
	
	 LoadEvent();
	
	 
	 $('#addID').change(function() {
		    $('#prID').val($(this).val());
		});
	 
	$('#addColor').on('click','.removeItem',function(){
		var child = $("#addColor").children().length;
		debugger;
		if(child > 1){
			$(this).parent().parent().remove();
		}
		else{
			$.alert({
	    	    title: 'Thông báo!',
	    	    content: 'Không thể xóa, Nhấn hủy để thoát'
	    	});
		}
	});
	
});