
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
	document.getElementsByClassName('staffWrap')[0].setAttribute("style","margin-top:" + height + "px");
}


function getOrderList() {
	  var xhttp; 
	
	  var state = $("#slbOrderState").val();
	  var typeID =  $("#slbSearchOrder").val();
	  var searchContent = $("#searchOrderInput").val();
	  
	  if(searchContent == null || searchContent == "")
		  searchContent = 0;
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("orderList").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/getOrder/1/"+state+"/"+typeID+"/"+searchContent, true);
	  xhttp.send();
}


function filterOrderList(page) {
	  var xhttp; 
	
	  var state = $("#slbOrderState").val();
	  var typeID =  $("#slbSearchOrder").val();
	  var searchContent = $("#searchOrderInput").val();
	  
	  if(searchContent == null || searchContent == "")
		  searchContent = 0;
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("orderList").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/getOrder/"+page+ "/" +state+"/"+typeID+"/"+searchContent, true);
	  xhttp.send();
}

function getBillsList() {
	  var xhttp; 
	  
	  var state = $("#slbBillType").val();
	  var typeID =  $("#slbSearchBill").val();
	  var searchContent = $("#searchBillInput").val();
	  
	  if(searchContent == null || searchContent == "")
		  searchContent = 0;
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("billList").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/getBill/1/"+state+"/"+typeID+"/"+searchContent, true);
	  xhttp.send();
}

function getBillsListByPage(page) {
	  var xhttp; 
	  
	  var state = $("#slbBillType").val();
	  var typeID =  $("#slbSearchBill").val();
	  var searchContent = $("#searchBillInput").val();
	  
	  if(searchContent == null || searchContent == "")
		  searchContent = 0;
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("billList").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/getBill/"+page+"/"+state+"/"+typeID+"/"+searchContent, true);
	  xhttp.send();
}

function getSupportList() {
	
	  var state = $("#slbSupportState").val();
	  var fDate =  $("#inputFromDate").val();
	  var eDate = $("#inputEndDate").val();

	  var xhttp; 
	 
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("spList").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getListSupportStaff/"+state+"/"+fDate+"/"+eDate, true);
	  xhttp.send();
}

function getGuaranteeList() {
	  var xhttp; 
	 
	  var state = $("#slbGuaranteeState").val();
	  var typeID =  $("#slbSearchGuarantee").val();
	  var searchContent = $("#searchGuaranteeInput").val();
	  
	  if(searchContent == null || searchContent == "")
		  searchContent = 0;
	  debugger;
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("gtList").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getListGuaranteeStaff/"+state+"/"+typeID+"/"+searchContent, true);
	  xhttp.send();
}

function getOrderListByCusID(cusID,startDate,endDate,state) {
	
	if(state == 0)
		document.getElementById("customerTradeHistoryList").innerHTML = '<tr><td colspan="7"><div style="margin-top:0;" class="loader"></div></td></tr>';
	
	  var xhttp; 
	  	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("customerTradeHistoryList").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/getOrderListByCusID/"+cusID+"/"+startDate+"/"+endDate, true);
	  xhttp.send();
}

function getCustomerList() {
	  var xhttp; 
	  
	  var state = $("#slbCustomerType").val();
	  var typeID =  $("#slbSearchCustomer").val();
	  var searchContent = $("#searchCustomerInput").val();
	  
	  if(searchContent == null || searchContent == "")
		  searchContent = 0;
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("customerList").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/getCustomers/1/"+state+"/"+typeID+"/"+searchContent, true);
	  xhttp.send();
}

function getCustomerListByPage(page) {
	  var xhttp; 
	  
	  var state = $("#slbCustomerType").val();
	  var typeID =  $("#slbSearchCustomer").val();
	  var searchContent = $("#searchCustomerInput").val();
	  
	  if(searchContent == null || searchContent == "")
		  searchContent = 0;
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("customerList").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/getCustomers/"+page+"/"+state+"/"+typeID+"/"+searchContent, true);
	  xhttp.send();
}

function getCustomerTypeList() {
	  var xhttp; 

	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("slbCustomerType").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/getComboboxCustomerType", true);
	  xhttp.send();
}

function getInfo(cusID) {
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("customerInfo").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/customerInfo/"+cusID, true);
	  xhttp.send();
}



function PrintElem(elem)
{
    var mywindow = window.open('', 'PRINT', 'height=800,width=1200');

    mywindow.document.write('<html><head><title>' + "GREAT - Hóa đơn bán hàng"  + '</title>');
    mywindow.document.write('<link rel="stylesheet" href="/resources/myweb/css/staff.css" type="text/css" media="print" />');
    mywindow.document.write('<link rel="stylesheet" href="/resources/myweb/css/nav.css" type="text/css" media="print" />');
    mywindow.document.write('<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" media="print">');
    mywindow.document.write('</head><body >');
    mywindow.document.write('<h2 style="text-align:center">' + "GREAT - Hóa đơn bán hàng"  + '</h2>');
    mywindow.document.write('<p style="text-align:center">' + "Hot-line: 01699888999"  + '</h2>');
    mywindow.document.write('<p style="text-align:center">' + "Facebook: fb.com/MVPShoe"  + '</h2><hr/>');
    mywindow.document.write(document.getElementById(elem).innerHTML);
    mywindow.document.write('</body></html>');

    mywindow.document.close(); // necessary for IE >= 10
    mywindow.focus(); // necessary for IE >= 10*/

    setTimeout(function(){mywindow.print();
    mywindow.close();},1000);


    return true;
}

function UpdateBillState(billID){
	
	var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	var pageNums = $("#billList").find(".active").eq(0).find('a').eq(0).text();
	    	getBillsListByPage(pageNums);
	    }
	  };
	  xhttp.open("GET", "/VerOne/updateBillState/"+billID, true);
	  xhttp.send();
}


$(document).ready(function() {
	getOrderList();
	getBillsList();
	getCustomerTypeList();
	getSupportList();
	getGuaranteeList();
	
	setTimeout(function(){
		getCustomerList();
	}, 1000);
	
	$("#support #slbSupportState").change(function(){
		getSupportList();
	});
	
	$("#inputFromDate").keyup(function(){
		getSupportList();
	});
	
	$("#inputEndDate").keyup(function(){
		getSupportList();
	});
	
	$("#inputFromDate").change(function(){
		getSupportList();
	});
	
	$("#inputEndDate").change(function(){
		getSupportList();
	});
	
	$("#searchGuaranteeInput").keyup(function(){
		getGuaranteeList();
	});
	
	$("#slbSearchGuarantee, #slbGuaranteeState").change(function(){
		getGuaranteeList();
	});
	
	$("#searchOrderInput").keyup(function(){
		getOrderList();
	});
	
	$("#slbOrderState, #slbSearchOrder").change(function(){
		getOrderList();
	});
	
	
	$("#searchBillInput").keyup(function(){
		getBillsList();
	});
	
	$("#slbSearchBill, #slbBillType").change(function(){
		getBillsList();
	});
	
	
	
	$("#searchCustomerInput").keyup(function(){
		getCustomerList();
	});
	
	$("#slbCustomerType, #slbSearchCustomer").change(function(){
		getCustomerList();
	});
	
	$("#orderList").on("click", ".btnViewOrderDetail", function(){
		document.getElementById("orderDetail").innerHTML = '<div style="display:block;" class="loader"></div>';
		
		var orderID = $(this).parent().siblings("td:first-child").text();
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    document.getElementById("orderDetail").innerHTML = this.responseText;
		    }
		  };
		  xhttp.open("GET", "/VerOne/getOrderDetail/"+orderID, true);
		  xhttp.send();
		
	});
	

	$("#billList").on("click", ".btnViewBillDetail", function(){
		document.getElementById("billDetail").innerHTML = '<div style="display:block;" class="loader"></div>';
		
		var billID = $(this).parent().siblings("td:first-child").text();
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    document.getElementById("billDetail").innerHTML = this.responseText;
		    UpdateBillState(billID);
		    }
		  };
		  xhttp.open("GET", "/VerOne/getBillDetail/"+billID, true);
		  xhttp.send();
		
	});
	
	$("#billDetail").on("click", ".btnPrintDetail", function(){
		
		PrintElem("print");
		
	});
	
	
	$("#customerTradeHistory").on("click", ".btnViewOrderDetailCustomer", function(){
		
		$("#myModal").attr("data-backdrop", "static");
		
		document.getElementById("orderDetail").innerHTML = '<div style="display:block;" class="loader"></div>';
		
		var orderID = $(this).parent().siblings("td:first-child").text();
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    document.getElementById("orderDetail").innerHTML = this.responseText;
		    }
		  };
		  xhttp.open("GET", "/VerOne/getOrderDetail/"+orderID, true);
		  xhttp.send();
		
	});

	
	$("#orderList").on("click", ".btnViewOrderDetail", function(){
		var orderID = $(this).parent().siblings("td:first-child").text();
		
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var pageNums = $("#orderList").find(".active").eq(0).find('a').eq(0).text();
		    	filterOrderList(pageNums);
		    }
		  };
		  xhttp.open("GET", "/VerOne/updateOrderState/"+orderID, true);
		  xhttp.send();

	});
	
	$("#customerTradeHistory").on("click", ".btnViewOrderDetailCustomer", function(){	
		var orderID = $(this).parent().siblings("td:first-child").text();
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var cusID = $("#modelHistoryCusID").text();
		    	var firstday = $('#startDayCustomer').val();
				var today = $('#endDayCustomer').val();	
				
				getOrderListByCusID(cusID,firstday,today,1);
				getOrderList();
		    }
		  };
		  xhttp.open("GET", "/VerOne/updateOrderState/"+orderID, true);
		  xhttp.send();
		
	});
	
	$("#customerList").on("click", ".btnViewCustomerOrders", function(){
		
		var cusID = $(this).parent().siblings("td:first-child").text();
		
		var name = $(this).parent().siblings("td").eq(1).text();
		var phoneNo = $(this).parent().siblings("td").eq(2).text();
		
		var now = new Date();

		var day = now.getDate();
		var month = now.getMonth() + 1;
		if(day < 10)
			day = "0" + day;
		if(month<10)
			month = "0" + month;

		var firstday =  now.getFullYear()+"-"+(month)+"-01";
		var today = now.getFullYear()+"-"+(month)+"-"+(day)
		$('#startDayCustomer').val(firstday);
		$('#endDayCustomer').val(today);

		
		$("#modelHistoryCusID").text(cusID);
		$("#modelHistoryCusName").text(name);
		$("#modelHistoryPhoneNo").text(phoneNo);
		
		
		getOrderListByCusID(cusID,firstday,today,0);
		
	});
	
	$("#endDayCustomer, #startDayCustomer").change(function(){
		
		var cusID = $("#modelHistoryCusID").text();

		var firstday = $('#startDayCustomer').val();
		var today = $('#endDayCustomer').val();	
		
		getOrderListByCusID(cusID,firstday,today,0);
		
	});
	
	
	$("#customerList").on("click", ".btnViewCustomerDetail", function(){
		
		var cusID = $(this).parent().siblings("td:first-child").text();
		getInfo(cusID);
		
	});
	
	$("#customerInfo").on("click", "#btnResetPassword", function(){
		
		var cusID = $("#cusInfoID").val();
		
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	            $.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		    }
		  };
		  xhttp.open("GET", "/VerOne/resetCustomerPass/"+cusID, true);
		  xhttp.send();
		
		
	});
	
	
	$("#orderDetail").on("click", ".btnSubmitChangeOrderDetail", function(){
		
		var items = $("#orderDetail").find('tbody').eq(0).children();
		
		var rs= true;
		
		items.each(function(){
			
			var pID = $(this).find('.orderDetailPID').eq(0).val();
			var orderID = $(this).find('.orderDetailOID').eq(0).val();
			var colorID = $(this).find('.orderDetailCID').eq(0).val();
			var sizeID = $(this).find('.orderDetailSID').eq(0).val();
			var newCID = $(this).find('.comboboxColor').eq(0).val();
			var newSID = $(this).find('.comboboxSize').eq(0).val();
			var newStock = $(this).find('.orderDetailNewStock').eq(0).val();
			
			
			
			$.ajax({
				async: false,
		        url: "/VerOne/modifyOrderDetail",
		        type: "POST",
		        data: {
		        	pID:pID,
		        	orderID:orderID,
		        	oldColorID:colorID,
		        	oldSizeID:sizeID,
		        	newColorID:newCID,
		        	newSizeID:newSID,
		        	stocks:newStock
		        },
		        success: function(response) {
		            if(response != " "){
		            	var msg = this.responseText;
			            $.alert({
				    	    title: 'Thông báo!',
				    	    content: msg
				    	});
		            	rs=false;
		            }

	            	
		            var xhttp; 
		      		  
		      		  xhttp = new XMLHttpRequest();
		      		  xhttp.onreadystatechange = function() {
		      		    if (this.readyState == 4 && this.status == 200) {
		      		    document.getElementById("orderDetail").innerHTML = this.responseText;
		      		    }
		      		  };
		      		  xhttp.open("GET", "/VerOne/getOrderDetail/"+orderID, true);
		      		  xhttp.send();
		        },
		        error: function() {
		            $.alert({
			    	    title: 'Thông báo!',
			    	    content: 'Đã xảy ra lỗi khi sửa, vui lòng kiểm tra lại thông tin nhập'
			    	});
		            rs=false;
		            return false;
		        }
		    });
			
		});
		if(rs == true){
			$.alert({
	    	    title: 'Thông báo!',
	    	    content: 'Cập nhật thành công!'
	    	});
		}
		
	});
	
	
	$("#orderDetail").on("click", "#btnCancelOrder", function(){
		
		  var orderID = $("#orderDetail").find('.orderDetailOID').eq(0).val();
		
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	            $.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		    	getOrderList();
		    }
		  };
		  xhttp.open("GET", "/VerOne/cancelOrderStaff/"+orderID, true);
		  xhttp.send();
	});
	
	
	$("#orderDetail").on("click", "#btnConfirmOrder", function(){
		
		  var orderID = $("#orderDetail").find('.orderDetailOID').eq(0).val();
		
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	            $.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		    	getOrderList();
		    }
		  };
		  xhttp.open("GET", "/VerOne/confirmOrder/"+orderID, true);
		  xhttp.send();
	});
	
	$("#support").on("click",".btnReplySupport",function(){
		var supportID = $(this).parent().siblings("td:first-child").text();		
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {	    	
		    	document.getElementById("answerSupportModalBox").innerHTML = this.responseText;
		    }
		  };
		  xhttp.open("GET", "/VerOne/getSupportRequireByID/"+supportID, true);
		  xhttp.send();
		  
	});
	
	$("#answerSupportModalBox").on("click","#submitAnserSupport",function(){		
		var formData = $('#frmReplySupport').serialize();
		$.ajax({
	        url: "replyAnswerSupportStaff",
	        type: "POST",
	        dataType: 'text',
	        data: formData,
	        success: function(response) {
	        	var msg = response;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
	            $("#frmReplySupport").trigger('reset');
	            getSupportList();   
	        },
	        error: function(response) {
	        	var msg = response;
	            $.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
	        }
	    	});
		  
	});
	
	$("#guarantee").on("click",".btnReceiveGuarantee",function(){
		var guaranteeID = $(this).parent().siblings("td:first-child").text();		
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {	    	
		    	document.getElementById("receiveGuaranteeModalBox").innerHTML = this.responseText;
		    }
		  };
		  xhttp.open("GET", "/VerOne/getGuaranteeStaffByID/"+guaranteeID, true);
		  xhttp.send();
		  
	});
	
	$("#receiveGuaranteeModalBox").on("click","#btnSubmitReceiveGuarantee",function(){		
		var formData = $('#frmGuarantee').serialize();
		$.ajax({
	        url: "receiveGuaranteeStaff",
	        type: "POST",
	        dataType: 'text',
	        data: formData,
	        success: function(response) {
	        	var msg = response;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
	            $("#frmGuarantee").trigger('reset');
	            getGuaranteeList();   
	        },
	        error: function(response) {
	        	var msg = response;
	            $.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
	        }
	    	});
		  
	});
	
	
	$("#receiveGuaranteeModalBox").on("click","#btnSubmitReturnGuarantee",function(){	
		var id = $("#receiveGuaranteeModalBox").find("#idGT").val();
		var returnDate = $("#receiveGuaranteeModalBox").find("#returnDate").val();
		
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {	
		    	var msg = this.responseText;
		    	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		    }
		  };
		  xhttp.open("GET", "/VerOne/submitReturnDateGuarantee/"+id+"/"+returnDate, true);
		  xhttp.send();		  
	});
	
	// Order Pagination
	$("#orderList").on('click','.pageOrderItem',function(){
		var page = $(this).find('a').eq(0).text();
		
		filterOrderList(page);
		
	});
	
	$("#orderList").on('click','.nextOrder',function(){
		var temp = $(this).siblings(".active").eq(0).find('a').eq(0).text();
		
		var pageNums = $("#pageOrderNums").val();
		
		var page = parseInt(temp) + 1;
		
		if(page <= parseInt(pageNums))
			filterOrderList(page);
		
	});
	
	$("#orderList").on('click','.prevOrder',function(){
		var temp = $(this).siblings(".active").eq(0).find('a').eq(0).text();
		
		var page = parseInt(temp) - 1;
		
		if(page > 0)
			filterOrderList(page);
		
	});

	// customer Pagination
	$("#customerList").on('click','.pageCusItem',function(){
		var page = $(this).find('a').eq(0).text();
		
		getCustomerListByPage(page);
		
	});
	
	$("#customerList").on('click','.nextCustomer',function(){
		var temp = $(this).siblings(".active").eq(0).find('a').eq(0).text();
		
		var pageNums = $("#pageCusNums").val();
		
		var page = parseInt(temp) + 1;
		
		if(page <= parseInt(pageNums))
			getCustomerListByPage(page);
		
	});
	
	$("#customerList").on('click','.prevCustomer',function(){
		var temp = $(this).siblings(".active").eq(0).find('a').eq(0).text();
		
		var page = parseInt(temp) - 1;
		
		if(page > 0)
			getCustomerListByPage(page);
		
	});
	
	// Bill Pagination
	$("#billList").on('click','.pageBillItem',function(){
		var page = $(this).find('a').eq(0).text();
		
		getBillsListByPage(page);
		
	});
	
	$("#billList").on('click','.nextBill',function(){
		var temp = $(this).siblings(".active").eq(0).find('a').eq(0).text();
		
		var pageNums = $("#pageBillNums").val();
		
		var page = parseInt(temp) + 1;
		
		if(page <= parseInt(pageNums))
			getBillsListByPage(page);
		
	});
	
	$("#billList").on('click','.prevBill',function(){
		var temp = $(this).siblings(".active").eq(0).find('a').eq(0).text();
		
		var page = parseInt(temp) - 1;
		
		if(page > 0)
			getBillsListByPage(page);
		
	});
	
});

