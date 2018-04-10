function loadOrderDelivery() {
	  var xhttp; 
	  
	  var state = $("#slbDeliveryState").val();
	  var typeID =  $("#slbSearchDelivery").val();
	  var searchContent = $("#searchDeliveryInput").val();
	  
	  if(searchContent == null || searchContent == "")
		  searchContent = 0;
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("lstOrderDelivery").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/loadOrderDelivery/"+state+"/"+typeID+"/"+searchContent, true);
	  xhttp.send();
}

function loadDeliveryTrucking() {
	  var xhttp; 
	  
	  var state = $("#slbDeliveryTruckingState").val();
	  var typeID =  $("#slbSearchDeliveryTrucking").val();
	  var searchContent = $("#searchDeliveryTruckingInput").val();
	  
	  if(searchContent == null || searchContent == "")
		  searchContent = 0;
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("lstDeliveryTrucking").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/loadDeliveryTrucking/"+state+"/"+typeID+"/"+searchContent+"/1", true);
	  xhttp.send();
}


function loadDeliveryTruckingByPage(page) {
	  var xhttp; 
	  
	  var state = $("#slbDeliveryTruckingState").val();
	  var typeID =  $("#slbSearchDeliveryTrucking").val();
	  var searchContent = $("#searchDeliveryTruckingInput").val();
	  
	  if(searchContent == null || searchContent == "")
		  searchContent = 0;
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("lstDeliveryTrucking").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/VerOne/loadDeliveryTrucking/"+state+"/"+typeID+"/"+searchContent+"/"+page, true);
	  xhttp.send();
}

function getDeliveryHistory() {
	
	  var state = $("#slbDeliveryHistoryState").val();
	  var fDate =  $("#inputFromDateHistory").val();
	  var eDate = $("#inputEndDateHistory").val();

	  var xhttp; 
	 
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("lstDeliveryHistory").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "loadDeliveryHistory/1/"+state+"/"+fDate+"/"+eDate, true);
	  xhttp.send();
}

function filterDeliveryHistory(page) {
	var state = $("#slbDeliveryHistoryState").val();
	  var fDate =  $("#inputFromDateHistory").val();
	  var eDate = $("#inputEndDateHistory").val();

	  var xhttp; 
	 
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("lstDeliveryHistory").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "loadDeliveryHistory/"+page+"/"+state+"/"+fDate+"/"+eDate, true);
	  xhttp.send();
}

function PrintDelivery(elem)
{
    var mywindow = window.open('', 'PRINT', 'height=800,width=1200');

    mywindow.document.write('<html><head><title>' + "GREAT - Hóa đơn giao hàng"  + '</title>');
    mywindow.document.write('<link rel="stylesheet" href="/resources/myweb/css/staff.css" type="text/css" media="print" />');
    mywindow.document.write('<link rel="stylesheet" href="/resources/myweb/css/nav.css" type="text/css" media="print" />');
    mywindow.document.write('<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" media="print">');
    mywindow.document.write('</head><body >');
    mywindow.document.write('<h2 style="text-align:center">' + "GREAT - Hóa đơn giao hàng"  + '</h2>');
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

$(document).ready(function() {
	
	var now = new Date();
	
	var today = now.getFullYear()+"-"+(now.getMonth()+1)+"-" + now.getDate();
	var startday = now.getFullYear()+"-"+(now.getMonth()+1)+"-01";

	$("#inputFromDateHistory").val(startday);
	$("#inputEndDateHistory").val(today);
	
	loadOrderDelivery();	
	loadDeliveryTrucking();
	getDeliveryHistory();
	
	$("#slbSearchDelivery, #slbDeliveryState").change(function(){
		loadOrderDelivery();
	});
	
	$("#searchDeliveryInput").keyup(function(){
		loadOrderDelivery();
	});
	
	$("#slbSearchDeliveryTrucking, #slbDeliveryTruckingState").change(function(){
		loadDeliveryTrucking();
	});
	
	$("#searchDeliveryTruckingInput").keyup(function(){
		loadDeliveryTrucking();
	});
	
	$("#historyDelivery #slbDeliveryHistoryState").change(function(){
		getDeliveryHistory();
	});
	
	$("#inputFromDateHistory").keyup(function(){
		getDeliveryHistory();
	});
	
	$("#inputEndDateHistory").keyup(function(){
		getDeliveryHistory();
	});
	
	$("#inputFromDateHistory").change(function(){
		getDeliveryHistory();
	});
	
	$("#inputEndDateHistory").change(function(){
		getDeliveryHistory();
	});
	
	$("#receiveOrder").on("click","#submitOrderDelivery",function(){		
		var orderID = $(this).parent().siblings("td:first-child").text();
		
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	            $.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
	            loadOrderDelivery();
	            loadDeliveryTrucking()
		    }
		  };
		  xhttp.open("GET", "/VerOne/setDeliverID/"+orderID, true);
		  xhttp.send();
	});
	
	$("#deliveryTrucking").on("click","#submitDeliveryTrucking",function(){		
		var orderID = $(this).parent().siblings("td:first-child").text();
		
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	document.getElementById("SubmitDeliveryTruckingModalBox").innerHTML = this.responseText;
		    }
		  };
		  xhttp.open("GET", "/VerOne/viewDetailDelivery/"+orderID, true);
		  xhttp.send();
	});
	
	$("#SubmitDeliveryTruckingModalBox").on("click","#submitDelivered",function(){		
		var orderID = $("#SubmitDeliveryTruckingModalBox").find("#orderID").text();
		var state = 1;
		debugger;
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	            $.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
	            loadDeliveryTrucking();
		    }
		  };
		  xhttp.open("GET", "/VerOne/submitOrderStateDelivery/"+orderID+"/"+state, true);
		  xhttp.send();
	});
	
	$("#SubmitDeliveryTruckingModalBox").on("click","#submitCanceled",function(){		
		var orderID = $("#SubmitDeliveryTruckingModalBox").find("#orderID").text();
		var state = 2;
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	            $.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
	            loadDeliveryTrucking();
	            getDeliveryHistory();
		    }
		  };
		  xhttp.open("GET", "/VerOne/submitOrderStateDelivery/"+orderID+"/"+state, true);
		  xhttp.send();
	});
	
	$("#SubmitDeliveryTruckingModalBox").on("click","#printDelivery",function(){		
		PrintDelivery('printDel');
	});
	
	// Delivery History Pagination
	$("#lstDeliveryHistory").on('click','.pageDeliveryHistoryItem',function(){
		var page = $(this).find('a').eq(0).text();		
		filterDeliveryHistory(page);		
	});
	
	$("#lstDeliveryHistory").on('click','.nextDeliveryHistory',function(){
		var temp = $(this).siblings(".active").eq(0).find('a').eq(0).text();		
		var pageNums = $("#pageDeliveryHistoryNums").val();		
		var page = parseInt(temp) + 1;		
		if(page <= parseInt(pageNums))
			filterDeliveryHistory(page);		
	});
	
	$("#lstDeliveryHistory").on('click','.prevDeliveryHistory',function(){
		var temp = $(this).siblings(".active").eq(0).find('a').eq(0).text();		
		var page = parseInt(temp) - 1;		
		if(page > 0)
			filterDeliveryHistory(page);		
	});
	
	  //TRunking Pagination
	  
	$("#lstDeliveryTrucking").on('click','.pageTrunkingItem',function(){
		var page = $(this).find('a').eq(0).text();
		
		loadDeliveryTruckingByPage(page);
		
	});
	
	$("#lstDeliveryTrucking").on('click','.nextTrunking',function(){
		var temp = $(this).siblings(".active").eq(0).find('a').eq(0).text();
		
		var pageNums = $("#pageTrunkingNums").val();
		
		var page = parseInt(temp) + 1;
		
		if(page <= parseInt(pageNums))
			loadDeliveryTruckingByPage(page);
		
	});
	
	$("#lstDeliveryTrucking").on('click','.prevTrunking',function(){
		var temp = $(this).siblings(".active").eq(0).find('a').eq(0).text();
		
		var page = parseInt(temp) - 1;
		
		if(page > 0)
			loadDeliveryTruckingByPage(page);
		
	});
	
});