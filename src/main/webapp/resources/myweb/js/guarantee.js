$(document).ready(function() {
	$("#submitGuarantee").click(function(){
		
		var formData = $('#frmSendGuarantee').serialize();
		debugger;
		$.ajax({
	        url: "addNewGuarantee",
	        type: "POST",
	        dataType: 'text',
	        data: formData,
	        success: function(response) {
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: response
		    	});
	            $("#frmSendGuarantee").trigger('reset'); 
	            $("#3a").load(location.href + " #3a");
	        },
	        error: function(response) {
	            $.alert({
		    	    title: 'Thông báo!',
		    	    content: response
		    	});
	        }
	    	});
	});
	
	$("#submitSendRequire").click(function(){
		
		var formData = $('#frmRequireSupporting').serialize();
		debugger;
		$.ajax({
	        url: "addSupportingRequire",
	        type: "POST",
	        dataType: 'text',
	        data: formData,
	        success: function(response) {
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: response
		    	});
	            $("#frmRequireSupporting").trigger('reset');   
	            $("#4a").load(location.href + " #4a");
	        },
	        error: function(response) {
	            $.alert({
		    	    title: 'Thông báo!',
		    	    content: response
		    	});
	        }
	    	});
	});

	var arr = [
		"Bạn đã mua hàng và đơn hàng đã được xác nhận từ 2 phía người mua và người bán, khách hàng không thể hủy hoặc đổi trả, vui lòng liên hệ nhân viên nếu có thắc mắc",
		"Nhân viên cửa hàng sẽ xác nhận lần cuối đơn hàng và hen giao hàng, nhân viên giao hàng sẽ liên lạc với khách hàng 1-2 giờ trước khi giao hàng. Vì vậy bạn cứ yên tâm về việc giao nhận hàng!",
		"Bạn truy cập vào trang chủ chọn menu Giám giả hoặc tại trang chủ kéo tới danh mục Đang khuyến mãi của cửa hàng",
		"Hiện tại cửa hàng MVP Shoes đang kinh doanh trực tuyến nên các cửa hàng chưa có sẵn tại các tỉnh thành phố, rất xin lỗi khách hàng về sự bất tiện này nhưng khách hàng hãy yên tâm về chất lượng sản phẩm trực tuyến của cửa hàng",
		"Tại liên kết quản lý tài khoản nhấn chuột vào sẽ dẫn tới trang thay đổi thông tin tài khoản, khách hàng có thể chỉnh sửa thông tin cơ bản, địa chỉ, hoặc có thể yêu cầu khôi phục mật khẩu mặc định",
		"Khi sản phẩm hết hàng nhân viên sẽ chủ động liên hệ với khách hàng nếu khách hàng đồng ý mua hàng, chúng tôi sẽ xuất với số lượng còn lại, nếu không khách hàng có thể đợi lô hàng tiếp theo về cửa hàng đẻ tiếp tục mua sắm"
		]
	$("select").change(function(){
		var temp = $(this).val();
		for(var i = 1; i<7; i++)
			if(temp == i){
				$.alert({
		    	    title: 'Thông báo!',
		    	    content: arr[i-1]
		    	});
			}
	});
});