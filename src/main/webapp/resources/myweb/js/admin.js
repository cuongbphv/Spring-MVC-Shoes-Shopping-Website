
function LoadPage(){
	fixedNav();
	getStaffTypeList();
	getStaffTypeListModal();
}


function Resize(){
	fixedNav();
}

function fixedNav()
{
	var height = document.getElementsByClassName('headerWrap')[0].offsetHeight;

	height+=10;
	document.getElementsByClassName('adminWrap')[0].setAttribute("style","margin-top:" + height + "px");
}

function newProduct(){
	getProducer();
	getMaterial();
	getProductType();
}

function LoadDate(){
	var now = new Date();
	
	var today = now.getFullYear()+"-"+(now.getMonth()+1)+"-" + now.getDate();
	var startday = now.getFullYear()+"-"+(now.getMonth()+1)+"-01";

	$("#startDayLog").val(startday);
	$("#endDayLog").val(today);

}

function LoadLogs(){
	
	var xhttp; 
	
	var startDate = $("#startDayLog").val();
	var endDate = $("#endDayLog").val();
	var content = $("#inputSearchLog").val();
	
	if(content=="" || content == null)
		content = "-1";
	
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("logContent").innerHTML = this.responseText;
	    }
	  };
	  
	  debugger;
	  xhttp.open("GET", "/VerOne/getlogs/"+startDate+"/"+endDate+"/"+content, true);
	  xhttp.send();
	
}

function importShoe(){
	getImportColorList();
	searchShoeList();
	getImportSizeList();
	
}


function getImportColorList(){
	
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("selectBoxColorList").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getColor", true);
	  xhttp.send();
}

function getImportSizeList(){
	
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("selectBoxSizeList").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getSize", true);
	  xhttp.send();
}

function getImportList(){	  
	
	var id = $("#sortImport").val();
	var fDate = $("#inputFromDateImport").val();
	var eDate = $("#inputEndDateImport").val();
	  
	var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("loadListImport").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getImportList/"+id+"/"+fDate+"/"+eDate, true);
	  xhttp.send();
}

function getPromotion(){
	
	  var state = $("#slbPromotionState").val();
	  var fDate =  $("#inputFromDatePromotion").val();
	  var eDate = $("#inputEndDatePromotion").val();
	  
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("showPromotion").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getPromotion/"+state+"/"+fDate+"/"+eDate, true);
	  xhttp.send();
}

function getCustomerTypeList(){
	
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("customers").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getListCustomerType", true);
	  xhttp.send();
}

function getProductList(){
	  var mID = $("#slbMaterialSort").val();
	  var pID = $("#slbProducerSort").val();
	  var ptID = $("#slbProductTypeSearch").val();
	  var typeID = $("#slbProductSearch").val();
	  var searchContent = $("#inputProductSearch").val();
	  
	  if(searchContent == null || searchContent == "")
		  searchContent = -1;
	  
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("loadProductList").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getProductList/"+mID+"/"+pID+"/"+ptID+"/"+typeID+"/"+searchContent+"/1", true);
	  xhttp.send();
}

function getProductListByPage(page){
	  var mID = $("#slbMaterialSort").val();
	  var pID = $("#slbProducerSort").val();
	  var ptID = $("#slbProductTypeSearch").val();
	  var typeID = $("#slbProductSearch").val();
	  var searchContent = $("#inputProductSearch").val();
	  
	  if(searchContent == null || searchContent == "")
		  searchContent = -1;
	  
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("loadProductList").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getProductList/"+mID+"/"+pID+"/"+ptID+"/"+typeID+"/"+searchContent+"/"+page, true);
	  xhttp.send();
}

function getLowStockProductList(){
	
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("lowStock").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getLowStockList", true);
	  xhttp.send();
}


function getProducer() {
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("newShoesProducer").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getProducer/addProducer", true);
	  xhttp.send();
}

function getColor() {
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("newShoesColor").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getColor/addColor", true);
	  xhttp.send();
}

function getMaterial() {
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("newShoesMaterial").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getMaterial/addMaterial", true);
	  xhttp.send();
}

function getSize() {
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("newShoesSize").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getSize/addSize", true);
	  xhttp.send();
}

function getProductType() {
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("newShoesType").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getProductType/addProductType", true);
	  xhttp.send();
}

//MATERIAL SECTION

function getStaffTypeList(){
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange=function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("selectBoxStaffType").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getStaffTypeList", true);
	  xhttp.send();
}

function searchShoeList(){
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange=function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("selectBoxShoeList").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "searchShoeList", true);
	  xhttp.send();
}


function getStaffTypeListModal(){
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange=function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("editStaffTypeModal").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getStaffTypeListModal", true);
	  xhttp.send();
}

function getProductTypeList(){
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange=function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("productType").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getListProductType", true);
	  xhttp.send();
}

function getMaterialList(){
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange=function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("material").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getListMaterial", true);
	  xhttp.send();
}
///Color
function getColorList(){
	
	var typeID =  $("#slbColorSearch").val();
	var searchContent = $("#inputColorSearch").val();

	if(searchContent == null || searchContent == "")
		searchContent = 0;
	
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange=function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("loadListColor").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getListColor/1"+"/"+typeID+"/"+searchContent, true);
	  xhttp.send();
}

function filterColorList(page) {
	
	var typeID =  $("#slbColorSearch").val();
	var searchContent = $("#inputColorSearch").val();

	if(searchContent == null || searchContent == "")
		searchContent = 0;

	var xhttp; 

	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("loadListColor").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "getListColor/"+page+"/"+typeID+"/"+searchContent, true);
	xhttp.send();
}
////End Color
function getSizeList(){
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange=function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("size").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getListSize", true);
	  xhttp.send();
}

function getProducerList(){
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange=function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("producer").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getListProducer", true);
	  xhttp.send();
}

function getProductPriceList(){
	
	var typeID = $("#slbSearchUpdatePrice").val();
	var content = $("#inputSearchUpdatePrice").val();
	  
	if(content == null || content == "")
		content = -1;
	
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange=function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("listUpdatePrice").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getListProductPrice/"+typeID+"/"+content, true);
	  xhttp.send();
}

function getStaffList(){
	
	var typeID = $("#slbStaffSearch").val();
	var contentSearch = $("#inputStaffSearch").val();
	var staffTypeSort = $("#slbStaffTypeSort").val();
	
	if(contentSearch == null || contentSearch == "")
		contentSearch = -1;
	
	debugger;
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange=function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("loadListStaff").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "getListStaff/"+typeID+"/"+contentSearch+"/"+staffTypeSort, true);
	  xhttp.send();
}

$(document).ready(function() {
	
	////////////CustomerType////////////////
	$("#customers").on("click", "#editCustomerType", function(){
		  
	      var id = $(this).parent().siblings("td:first-child").text();
	      var name = $(this).parent().siblings("td:nth-child(2)").text();
	      var discount = $(this).parent().siblings("td:nth-child(3)").text();
	      var level = $(this).parent().siblings("td:nth-child(4)").text().replace(/\,/g,'');
	      
	      debugger;
	      
	      $("#EditCustomerTypeModalBox").find("#idCT:first-child").val(id);
	      $("#EditCustomerTypeModalBox").find("#nameCT:first-child").val(name);
	      $("#EditCustomerTypeModalBox").find("#discountCT:first-child").val(discount);
	      $("#EditCustomerTypeModalBox").find("#levelMoneyCT:first-child").val(level);
		  
	});
	
	$("#EditCustomerTypeModalBox").on("click", "#submitEditCustomerType", function(){
		
		  var id = $("#EditCustomerTypeModalBox").find("#idCT").val();
		  var name = $("#EditCustomerTypeModalBox").find("#nameCT").val();
		  var discount = $("#EditCustomerTypeModalBox").find("#discountCT").val();
		  var level = $("#EditCustomerTypeModalBox").find("#levelMoneyCT").val().replace(",","");;
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
	        	$("#frmEditCustomerType").trigger('reset');
	        	getCustomerTypeList();
		    }
	
		  };
		  xhttp.open("GET", "editCustomerType/"+id+"/"+name+"/"+discount+"/"+level, true);
		  xhttp.send();
	});
	
	$("#customers").on("click", "#deleteCustomerType", function(){
		
	    var id = $(this).parent().siblings("td:first-child").text();
	    debugger;
	    
	    $.confirm({
		    title: 'Thông báo!',
		    content: 'Bạn chắc chắn xóa loại khách hàng này?',
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
			  	        	getCustomerTypeList();
			  		    }
			  	
			  		  };
			  		  xhttp.open("GET", "deleteCustomerType/"+id, true);
			  		  xhttp.send();
		        },
		        'Hủy bỏ': function () {
		        }
		    }
		});
	    
	});
	
	$("#AddCustomerTypeModalBox").on("click", "#submitNewCustomerType", function(){
		
		  var name = $("#AddCustomerTypeModalBox").find("#nameCustomerType").val();
		  var discount = $("#AddCustomerTypeModalBox").find("#discountCustomerType").val();
		  var level = $("#AddCustomerTypeModalBox").find("#levelMoneyCustomerType").val();
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
	        	$("#frmNewCustomerType").trigger('reset');
	        	getCustomerTypeList();
		    }
	
		  };
		  xhttp.open("GET", "addCustomerType/"+name+"/"+discount+"/"+level, true);
		  xhttp.send();
	});
	
	///////////End Customer Type ///////////
	////////////Staff///////////////////
	$("#submitNewStaff").click(function(){
		
		var formData = $('#frmNewStaff').serialize();
		$.ajax({
	        url: "addStaff",
	        type: "POST",
	        dataType: 'text',
	        data: formData,
	        success: function() {
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: 'Thêm nhân viên và tài khoản thành công'
		    	});
	            $("#frmNewStaff").trigger('reset');
	    		getStaffList();     
	        },
	        error: function() {
	            $.alert({
		    	    title: 'Thông báo!',
		    	    content: 'Thêm nhân viên và tài khoản thất bại'
		    	});
	        }
	    	});
	});
	
	$("#staff").on("click", "#resetStaffPassword", function(){
		
	    var id = $(this).parent().siblings("td:first-child").text();
	    
	    $.confirm({
		    title: 'Thông báo!',
		    content: 'Bạn chắc chắn khôi phục mật khẩu mặc định cho nhân viên ?',
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
		  	        	getStaffList(); 
		  		    }
		  	
		  		  };
		  		  xhttp.open("GET", "resetStaffPassword/"+id, true);
		  		  xhttp.send();
		  		  
		        },
		        'Hủy bỏ': function () {
		        }
		    }
		});
	    
	});
	
	$("#staff").on("click", "#deleteStaff", function(){
		
	    var id = $(this).parent().siblings("td:first-child").text();
	    
	    $.confirm({
		    title: 'Thông báo!',
		    content: 'Bạn chắc chắn xóa tài khoản và nhân viên này không?',
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
			  	        	getStaffList(); 
			  		    }
			  	
			  		  };
			  		  xhttp.open("GET", "deleteStaff/"+id, true);
			  		  xhttp.send();
		  		  
		        },
		        'Hủy bỏ': function () {
		        }
		    }
		});
		  
	});

	$("#submitNewStaffType").click(function(){
		var newName = $("#addNewStaffType").find("#name").val();
		
		var xhttp; 		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getStaffTypeList();
		 	 getStaffTypeListModal();
		    }	
		  };
		  xhttp.open("GET", "addStaffType/"+newName, true);
		  xhttp.send();
	});
	
	$("#editStaffTypeModal").on("click", ".editStaffType", function(){
		
	      var id = $(this).parent().siblings("td:first-child").text();
	      var name = $(this).parent().siblings("td:nth-child(2)").text();
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200){
		    	document.getElementById("editStaffTypeModal").innerHTML = this.responseText;
		    }
	
		  };
		  xhttp.open("GET", "editStaffType/"+id+"/"+name, true);
		  xhttp.send();
	});
	
	$("#editStaffTypeModal").on("click", "#submitEditStaffType", function(){
		
	      var id = $("#editStaffTypeModal").find("#idST:first-child").val();
	      var name = $("#editStaffTypeModal").find("#nameST:first-child").val();
	      debugger;
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200){
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
	        	getStaffList(); 
		    }
	
		  };
		  xhttp.open("GET", "submitEditStaffType/"+id+"/"+name, true);
		  xhttp.send();
	});
	
	$("#editStaffTypeModal").on("click", ".deleteStaffType", function(){
		
	      var id = $(this).parent().siblings("td:first-child").text();
	    
			$.confirm({
			    title: 'Thông báo!',
			    content: 'Bạn chắc chắn xóa loại nhân viên này không?',
			    buttons: {
			        'Tiếp tục': function () {
			        	 var xhttp; 
			        	 
				  		  xhttp = new XMLHttpRequest();
				  		  xhttp.onreadystatechange = function() {
				  		    if (this.readyState == 4 && this.status == 200){
				  		    	var msg = this.responseText;
				  	        	$.alert({
				  		    	    title: 'Thông báo!',
				  		    	    content: msg
				  		    	});
				  		     getStaffTypeList();
				  		     getStaffTypeListModal();
				  		    }
				  	
				  		  };
				  		  xhttp.open("GET", "deleteStaffType/"+id, true);
				  		  xhttp.send();
			  		  
			        },
			        'Hủy bỏ': function () {
			        }
			    }
			});
	});

	$("#staff").on("click", ".openEditStaffModal", function(){
		  
	      var id = $(this).parent().siblings("td:first-child").text();
	      var name = $(this).parent().siblings("td:nth-child(2)").text();
	      var address = $(this).parent().siblings("td:nth-child(3)").text();
	      var phoneNumber = $(this).parent().siblings("td:nth-child(4)").text();
	      var dateOfBirth = $(this).parent().siblings("td:nth-child(5)").text();
	      var gender = $(this).parent().siblings("td:nth-child(6)").text();
	      var staffType = $(this).parent().siblings("td:nth-child(7)").text();
	      var username = $(this).parent().siblings("td:nth-child(8)").text();
	      
	      if(gender == "Nam"){
	    	  $('#staffMale').prop('checked',true);
	    	  $('#staffFemale').prop('checked',false);
	      }
	      else{
	    	  $('#staffMale').prop('checked',false);
	    	  $('#staffFemale').prop('checked',true);
	      }
	      
	      $("#editStaffInfo").find("#staffID").val(id);
	      $("#editStaffInfo").find("#staffName").val(name);
	      $("#editStaffInfo").find("#staffAddress").val(address);
	      $("#editStaffInfo").find("#staffPhoneNumber").val(phoneNumber);
	      $("#editStaffInfo").find("#staffDateofBirth").val(dateOfBirth);

	      var id = $(this).parent().siblings("td:first-child").text();
		    
		  var xhttp;
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	$("#editStaffInfo").find("#staffUsername:first-child").val(this.responseText);
		    }
	
		  };
		  xhttp.open("GET", "getUsernameStaff/"+id, true);
		  xhttp.send();
		  
		  
		  var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange=function() {
		    if (this.readyState == 4 && this.status == 200) {
		      document.getElementById("selectBoxStaffTypeEdit").innerHTML = this.responseText;
		      $("#staffTypeID option").each(function(){
		    	  var temp = $(this).text().trim();
		    	  if(temp == staffType){
		    		  $("#staffTypeID option:selected").text(staffType);
		    	  }
		      });
		    }
		  };
		  xhttp.open("GET", "getStaffTypeListEdit", true);
		  xhttp.send();
		  
		  
	});
	
	$("#editStaffInfo").on("click","#submitStaffInfo",function(){
		var formData = $('#frmStaffInfo').serialize();
		$.ajax({
	        url: "editStaffInfo",
	        type: "POST",
	        dataType: 'text',
	        data: formData,
	        success: function() {
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: 'Chỉnh sửa thông tin nhân viên thành công'
		    	});
	        	getStaffList();    
	        },
	        error: function() {
	            $.alert({
		    	    title: 'Thông báo!',
		    	    content: 'Chỉnh sửa thông tin nhân viên thất bại'
		    	});
	        }
	    	});
	});
	
	//////////End Staff//////////////////
	
	/////////// ProductType //////////////
	$("#productType").on("click", ".deleteProductType", function(){
		
	    var id = $(this).parent().siblings("td:first-child").text();
	    
		  var xhttp;
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getProductTypeList();
		    }
	
		  };
		  xhttp.open("GET", "deleteProductType/"+id, true);
		  xhttp.send();
	});
	
	$("#productType").on("click", ".openEditProductType", function(){		
	      var id = $(this).parent().siblings("td:first-child").text();
	      var name = $(this).parent().siblings("td:nth-child(2)").text();
	      
	      $("#editProductTypeModal").find("h4").text("Chỉnh sửa loại sản phẩm");
	      $("#editProductTypeModal").find("#labelID:first-child").text("Mã loại:");
	      $("#editProductTypeModal").find("#labelName:first-child").text("Tên loại:");
	      
	      
	      $("#editProductTypeModal").find("#ID:first-child").val(id);
	      $("#editProductTypeModal").find("#Name:first-child").val(name);
	});
	
	
	$("#editProductTypeModal").on("click",".editProductType", function(){
		
		var ID = $("#editProductTypeModal").find("#ID:first-child").val();
		var newName = $("#editProductTypeModal").find("#Name:first-child").val();
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getProductTypeList();
		    }	
		  };
		  xhttp.open("GET", "editProductType/"+ID+"/"+newName, true);
		  xhttp.send();
	});
	
	$("#submitNewProductType").click(function(){
		var newName = $("#addProductTypeModal").find("#name:first-child").val();
		
		var xhttp; 		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		     $("#frmNewProductType").trigger('reset');
		     var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getProductTypeList();
		    }	
		  };
		  xhttp.open("GET", "addProductType/"+newName, true);
		  xhttp.send();
	});
	/////////// End ProductType //////////////
	
	/////////// Producer //////////////
	$("#producer").on("click", ".deleteProducer", function(){
		
	    var id = $(this).parent().siblings("td:first-child").text();
	    
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getProducerList();
		    }
	
		  };
		  xhttp.open("GET", "deleteProducer/"+id, true);
		  xhttp.send();
	});
	
	$("#producer").on("click", ".openEditProducer", function(){		
	      var id = $(this).parent().siblings("td:first-child").text();
	      var name = $(this).parent().siblings("td:nth-child(2)").text();
	      var address = $(this).parent().siblings("td:nth-child(3)").text();
	      var phoneNumber = $(this).parent().siblings("td:nth-child(4)").text();
	      
	      $("#editProducerModal").find("h4").text("Chỉnh sửa nhà sản xuất");
	      $("#editProducerModal").find("#labelID:first-child").text("Mã NSX:");
	      $("#editProducerModal").find("#labelName:first-child").text("NSX:");
	      $("#editProducerModal").find("#labelAddress:first-child").text("Địa chỉ:");
	      $("#editProducerModal").find("#labelPhoneNumber:first-child").text("Số điện thoại:");
	      
	      $("#editProducerModal").find("#ID:first-child").val(id);
	      $("#editProducerModal").find("#Name:first-child").val(name);
	      $("#editProducerModal").find("#Address:first-child").val(address);
	      $("#editProducerModal").find("#PhoneNumber:first-child").val(phoneNumber);
	});
	
	
	$("#editProducerModal").on("click",".editProducer", function(){
		
		var ID = $("#editProducerModal").find("#ID:first-child").val();
		var newName = $("#editProducerModal").find("#Name:first-child").val();
		var newAddress = $("#editProducerModal").find("#Address:first-child").val();
		var newPhoneNumber = $("#editProducerModal").find("#PhoneNumber:first-child").val();
		
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getProducerList();
		    }	
		  };
		  xhttp.open("GET", "editProducer/"+ID+"/"+newName+"/"+newAddress+"/"+newPhoneNumber, true);
		  xhttp.send();
	});
	
	$("#submitNewProducer").click(function(){
		var newName = $("#addProducerModal").find("#name:first-child").val();
		var newAddress = $("#addProducerModal").find("#address:first-child").val();
		var newPhoneNumber = $("#addProducerModal").find("#phoneNumber:first-child").val();
		
		var xhttp; 		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		     $("#frmNewProducer").trigger('reset');
		     var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getProducerList();
		    }	
		  };
		  xhttp.open("GET", "addProducer/"+newName+"/"+newAddress+"/"+newPhoneNumber, true);
		  xhttp.send();
	});
	/////////// End Producer //////////////
	
	
	/////////// Size //////////////
	$("#size").on("click", ".deleteSize", function(){
		
	    var id = $(this).parent().siblings("td:first-child").text();
	    
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getSizeList();
		    }
	
		  };
		  xhttp.open("GET", "deleteSize/"+id, true);
		  xhttp.send();
	});

	$("#size").on("click", ".openEditSize", function(){		
	      var id = $(this).parent().siblings("td:first-child").text();
	      var name = $(this).parent().siblings("td:nth-child(2)").text();
	      
	      $("#editSizeModal").find("h4").text("Chỉnh sửa màu sắc");
	      $("#editSizeModal").find("#labelID:first-child").text("Mã kích cỡ:");
	      $("#editSizeModal").find("#labelName:first-child").text("Kích cỡ:");
	      
	      
	      $("#editSizeModal").find("#ID:first-child").val(id);
	      $("#editSizeModal").find("#Name:first-child").val(name);
	});
	
	
	$("#editSizeModal").on("click",".editSize", function(){
		
		var ID = $("#editSizeModal").find("#ID:first-child").val();
		var newName = $("#editSizeModal").find("#Name:first-child").val();
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getSizeList();
		    }	
		  };
		  xhttp.open("GET", "editSize/"+ID+"/"+newName, true);
		  xhttp.send();
	});
	
	$("#submitNewSize").click(function(){
		var newName = $("#addSizeModal").find("#name:first-child").val();
		
		var xhttp; 		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		     $("#frmNewSize").trigger('reset');
		     var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getSizeList();
		    }	
		  };
		  xhttp.open("GET", "addSize/"+newName, true);
		  xhttp.send();
	});
	/////////// End Size //////////////
	
	/////////// Color //////////////
	$("#color").on("click", ".deleteColor", function(){
		
	    var id = $(this).parent().siblings("td:first-child").text();
	    
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getColorList();
		    }
	
		  };
		  xhttp.open("GET", "deleteColor/"+id, true);
		  xhttp.send();
	});

	$("#color").on("click", ".openEditColor", function(){		
	      var id = $(this).parent().siblings("td:first-child").text();
	      var name = $(this).parent().siblings("td:nth-child(2)").text();
	      
	      $("#editColorModal").find("h4").text("Chỉnh sửa màu sắc");
	      $("#editColorModal").find("#labelID:first-child").text("Mã màu sắc:");
	      $("#editColorModal").find("#labelName:first-child").text("Tên màu sắc:");
	      
	      
	      $("#editColorModal").find("#editColorID:first-child").val(id);
	      $("#editColorModal").find("#editColorName:first-child").val(name);
	      
	      var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	document.getElementById("loadingImageByColor").innerHTML = this.responseText;
		    }	
		  };
		  xhttp.open("GET", "getEditColorByID/"+id, true);
		  xhttp.send();
		  
	});
	
	
	$("#editColorModal").on("click",".editColor", function(){
		
		var formData = new FormData($('#formEditColor')[0])
		
	    $.ajax({
	        url: "editColor",
	        type: "POST",
	        dataType: 'text',
	        contentType: false,
	        processData: false,
	        cache: false,
	        data: formData,
	        success: function(response) {
	        	var msg = response;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
	            $("#formEditColor").trigger('reset');
	            getColorList();
	        },
	        error: function() {
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: 'Đã xảy ra lỗi khi chỉnh sửa màu, vui lòng kiểm tra lại thông tin nhập!'
		    	});
	        }
	    });
	});
	
	
	$("#submitNewColor").click(function(){
		//var formData = $('#frmAddNewColor').serialize();
		var formData = new FormData($('#frmAddNewColor')[0])
		
	    $.ajax({
	        url: "addColor",
	        type: "POST",
	        dataType: 'text',
	        contentType: false,
	        processData: false,
	        cache: false,
	        data: formData,
	        success: function(response) {
	        	var msg = response;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
	            $("#frmAddNewColor").trigger('reset');
	            getColorList();
	        },
	        error: function() {
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: 'Đã xảy ra lỗi khi thêm màu, vui lòng kiểm tra lại thông tin nhập!'
		    	});
	        }
	    });
	});
	/////////// End Color //////////////
	
	/////////// Material //////////////
	$("#material").on("click", ".deleteMaterial", function(){
		
	    var id = $(this).parent().siblings("td:first-child").text();
	    
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getMaterialList();
		    }
	
		  };
		  xhttp.open("GET", "deleteMaterial/"+id, true);
		  xhttp.send();
	});
	
	$("#material").on("click", ".openEditMaterial", function(){		
	      var id = $(this).parent().siblings("td:first-child").text();
	      var name = $(this).parent().siblings("td:nth-child(2)").text();
	      
	      $("#editMaterialModal").find("h4").text("Chỉnh sửa chất liệu");
	      $("#editMaterialModal").find("#labelID:first-child").text("Mã chất liệu:");
	      $("#editMaterialModal").find("#labelName:first-child").text("Tên chất liệu:");
	      
	      $("#ID").val(id);
	      $("#Name").val(name);
	});
	
	
	$("#editMaterialModal").on("click",".editMaterial", function(){
		
		var ID = $("#editMaterialModal").find("#ID:first-child").val();
		var newName = $("#editMaterialModal").find("#Name:first-child").val();
		
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getMaterialList();
		    }
	
		  };
		  xhttp.open("GET", "editMaterial/"+ID+"/"+newName, true);
		  xhttp.send();
	});
	
	
	$("#submitNewMaterial").click(function(){
		var newName = $("#addMaterialModal").find("#name:first-child").val();
		
		var xhttp; 		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		     $("#frmNewMaterial").trigger('reset');
		     var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getMaterialList();
		    }	
		  };
		  xhttp.open("GET", "addMaterial/"+newName, true);
		  xhttp.send();
	});
/////////// End Material //////////////
	
	function AddNewProduct(){
		var flag = false;
    	var formData = new FormData($('#frmNewShoe')[0]);
		
	    $.ajax({
	    	//async: false,
	        url: "addProductAD",
	        type: "POST",
	        dataType: 'text',
	        contentType: false,
	        processData: false,
	        cache: false,
	        data: formData,
	        success: function(response) {
	            var msg = response;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
	            $("#frmNewShoe").trigger('reset');
	            flag = true;
	        },
	        error: function() {
//	            alert("Đã xảy ra lỗi khi thêm sản phẩm, vui lòng kiểm tra lại thông tin nhập");
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: "Đã xảy ra lỗi khi thêm sản phẩm, vui lòng kiểm tra lại thông tin nhập"
		    	});
	        }
	    });
	    
	    if (flag)
	    	return true;
	    else
	    	return false;
	}
	
	
	$("#submitNewShoe").click(function(){
		
		  var flag = false;
		  var ColorIDValues = $('.colorItemID').map(function(idx, elem) {
			    return $(elem).val();
			  }).get();
		  
		  var ImageItems = $('.imageItem').map(function(idx, elem) {
			    return $(elem).val();
			  }).get();
		  
		  if(checkColorChosen(ColorIDValues) || hasNoneImg(ImageItems) || hasDuplicates1(ColorIDValues)){
			  debugger;
			  $.confirm({
				    title: 'Thông báo!',
				    content: 'Bạn chưa thêm hình ảnh theo màu giày, tiếp tục thêm sản phẩm này?',
				    buttons: {
				        'Tiếp tục': function () {
				        	AddNewProduct();
				        },
				        'Hủy bỏ': function () {
				        }
				    }
				});
		  }
		  else{
			  		AddNewProduct();
				  	AddImageWithColor();
				  }
	});
	
	
	$("#submitNewPromotion").click(function(){
		if($(this).text() == "Thêm khuyến mãi"){
		    var formData = $('#frmNewPromotion').serialize();
			
		    $.ajax({
		        url: "addPromotionAD",
		        type: "POST",
		        dataType: 'text',
		        data: formData,
		        success: function(response) {
		        	var msg = response;
		        	$.alert({
			    	    title: 'Thông báo!',
			    	    content: msg
			    	});
		            $("#frmNewPromotion").trigger('reset');
		            getPromotion();
		        },
		        error: function() {
		            alert("Đã xảy ra lỗi khi thêm khuyến mãi, vui lòng kiểm tra lại thông tin nhập!");
		        }
		    });
		}
		else{
			var formData = $('#frmNewPromotion').serialize();
			
		    $.ajax({
		        url: "editPromotionAD",
		        type: "POST",
		        dataType: 'text',
		        data: formData,
		        success: function(response) {
		        	var msg = response;
		        	$.alert({
			    	    title: 'Thông báo!',
			    	    content: msg
			    	});
		            $("#frmNewPromotion").trigger('reset');
		            $("#discount").find("#submitNewPromotion").text("Thêm khuyến mãi");
		            getPromotion();
		        },
		        error: function() {
		            alert("Đã xảy ra lỗi khi chỉnh sửa khuyến mãi, vui lòng kiểm tra lại thông tin nhập!");
		        }
		    });
		}
	});
	
	
	$("#product").on("click", ".deleteProduct", function(){
		
	    var id = $(this).parent().siblings("td:first-child").text();
	    
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		     var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getProductList();
		    }

		  };
		  xhttp.open("GET", "deleteProduct/"+id, true);
		  xhttp.send();
	});
	
	$("#showPromotion").on("click", ".deletePromotion", function(){
		
	    var id = $(this).parent().siblings("td:first-child").text();
	    
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getPromotion();
		    }

		  };
		  xhttp.open("GET", "deletePromotion/"+id, true);
		  xhttp.send();
	});
	
	$("#showPromotion").on("click", ".editPromotion", function(){
		var id = $(this).parent().siblings("td:first-child").text();
		var name = $(this).parent().siblings("td:nth-child(2)").text();
		var percent = $(this).parent().siblings("td:nth-child(3)").text();
		var startDate = $(this).parent().siblings("td:nth-child(4)").text();
		var endDate = $(this).parent().siblings("td:nth-child(5)").text();

		var tempStart = startDate.split("-");
	    var tempEnd = endDate.split("-");
	    
	    var nowStart = new Date();
	    var nowEnd = new Date();
	    
	    var setStartDate = nowStart.getFullYear(tempStart[2])+"-"+(tempStart[1])+"-"+(tempStart[0]) ;
	    var setEndDate = nowEnd.getFullYear(tempEnd[2])+"-"+(tempEnd[1])+"-"+(tempEnd[0]) ;

		$("#discount").find("#discountID").val(id);
		$("#discount").find("#discountID").prop('readonly','true');
		$("#discount").find("#discountName").val(name);
		$("#discount").find("#discountPercent").val(percent);
		$("#discount").find("#discountStartDate").val(setStartDate);
		$("#discount").find("#discountEndDate").val(setEndDate);

		$("#discount").find("#submitNewPromotion").text("Sửa khuyến mãi");
	});
	
	$("#submitAddImportDetail").click(function(){		
		var cell1 = $("#importShoeID").val();
		var cell3 = $("#importColorID").val();
		var cell4 = $("#importSizeID").val();
		var cell5 = $("#importPrice").val();
		
		debugger;
		var flag = false;
		var table = document.getElementById('importTable');
		
	    $("#importTable tbody").find('tr').each(function () {
	        var $tds = $(this).find('td'),
	            pID = $tds.eq(0).text(),
	            color = $tds.eq(2).find("input:first").val(),
	            size = $tds.eq(3).find("input:first").val(),
	            price = $tds.eq(5).text();
	        debugger;
	        if(pID == cell1 && color == cell3 && size == cell4){
	        	if (price == cell5){
	        		debugger;
	        		var num = parseInt($tds.eq(4).text()) + parseInt($("#importNumber").val()) ;
	        		$tds.eq(4).text(num);
	        		flag = true;
	        	}
	        	else{
	        		$.alert({
			    	    title: 'Thông báo!',
			    	    content: 'Sản phẩm cùng màu, kích cỡ nhưng khác giá vui lòng kiểm tra lại'
			    	});
	        		flag = true;
	        	}
	        }
	      
	    });
    
	    if(flag == false){
		    var temp = "<tr><td>" + $("#importShoeID").val() + "</td>"+
				"<td>" + $("#importShoeID option:selected").text() +"</td>" +
				"<td>" + $("#importColorID option:selected").text() + "<input type='hidden' value='" + $("#importColorID").val()+"'/>" + "</td>" +
				"<td>" + $("#importSizeID option:selected").text() + "<input type='hidden' value='" + $("#importSizeID").val()+"'/>" + "</td>" +
				"<td>" + $("#importNumber").val() +"</td>" +
				"<td>" + $("#importPrice").val() +"</td>" +
				"<td><button class='deleteImportDetail btn btn-danger button-style'>Xóa</button></td>" + "</tr>"; 
		    $("#importshoes").find("table").append(temp);
	    }
	});
	
	
	$("#importshoes").on("click",".deleteImportDetail",function(){
		$(this).parent().parent().remove();
	});
	
	$("#submitAddImportBill").click(function(){
		var table = $('#importTable tr:has(td)').map(function() {
		    var $td =  $('td', this);
		        return {
			        	productID: $td.eq(0).text(),
			        	colorID: $td.eq(2).find("input:first").val(),
			        	sizeID: $td.eq(3).find("input:first").val(),
			        	quantity : $td.eq(4).text(),
			        	price: $td.eq(5).text()
		               }
		}).get();
		
		var Import = JSON.stringify(table);

		$.ajax({
		    dataType : 'text',
	        type: 'POST',
	        url: 'importShoe',
	        data: "Import=" + Import,
	        success: function (response) {          
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: response
		    	});
	        },
	        error: function (response) {
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: response
		    	});
	        }
	    }); 		
		
	});
	
	
	$("#update").on("click", ".updatePriceModal", function(){
		  var id = $(this).parent().siblings("td:first-child").text();
		  var name = $(this).parent().siblings("td:nth-child(2)").text();
	      var price = $(this).parent().siblings("td:nth-child(3)").text();
	      
	      $("#updatePriceModalBox").find("#newPrice:first-child").val(price);
	      $("#updatePriceModalBox").find("#ID:first-child").val(id);
	      $("#updatePriceModalBox").find("#Name:first-child").val(name);
	});
	
	$("#updatePriceModalBox").on("click","#submitNewPrice",function(){
		var id = $("#updatePriceModalBox").find("#ID:first-child").val();
		var price = $("#updatePriceModalBox").find("#newPrice:first-child").val().replace(",","");
		debugger;
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200){
		     var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getProductPriceList();
		    }
	
		  };
		  xhttp.open("GET", "updatePrice/"+id+"/"+price, true);
		  xhttp.send();
		  
	});
	
	$("#update").on("click", ".updateDiscountModal", function(){
		  var id = $(this).parent().siblings("td:first-child").text();
		  var name = $(this).parent().siblings("td:nth-child(2)").text();
	      var discount = $(this).parent().siblings("td:nth-child(4)").text();
	      
	      $("#updateDiscountModalBox").find("#newDiscount:first-child").val(discount);
	      $("#updateDiscountModalBox").find("#ID:first-child").val(id);
	      $("#updateDiscountModalBox").find("#Name:first-child").val(name);
	});
	
	$("#updateDiscountModalBox").on("click","#submitNewDiscount",function(){
		var id = $("#updateDiscountModalBox").find("#ID:first-child").val();
		var discount = $("#updateDiscountModalBox").find("#newDiscount:first-child").val();
		debugger;
		var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200){
		    	var msg = this.responseText;
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: msg
		    	});
		     getProductPriceList();
		    }
	
		  };
		  xhttp.open("GET", "updateDiscount/"+id+"/"+discount, true);
		  xhttp.send();
		  
	});
	
	$("#product").on("click",".detailProduct",function(){
		var id = $(this).parent().siblings("td:first-child").text();
		
		 var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200){
		    	document.getElementById("detailShoeModalBox").innerHTML = this.responseText;
		    }
	
		  };
		  xhttp.open("GET", "viewProductDetail/"+id, true);
		  xhttp.send();
	});
	
	$("#product").on("click",".editProduct",function(){
		var id = $(this).parent().siblings("td:first-child").text();
		var mID = $(this).parent().siblings("td:nth-child(5)").find("input:first").val();
		var pID = $(this).parent().siblings("td:nth-child(4)").find("input:first").val();
		var ptID = $(this).parent().siblings("td:nth-child(8)").find("input:first").val();
		 var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200){
		    	document.getElementById("editShoeModalBox").innerHTML = this.responseText;
		    }
	
		  };
		  xhttp.open("GET", "editProduct/"+id+"/"+mID+"/"+pID+"/"+ptID, true);
		  xhttp.send();
		  
	});
	
	$("#editShoeModalBox").on("click","#submitEditProduct",function(){
		//var formData = $('#frmEditProduct').serialize();
		var formData = new FormData($('#frmEditProduct')[0]);
		$.ajax({
	        url: "editProductDetail",
	        type: "POST",
	        dataType: 'text',
	        contentType: false,
	        processData: false,
	        cache: false,
	        data: formData,
	        success: function() {
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: 'Chỉnh sửa sản phẩm thành công'
		    	});
	            $("#frmEditProduct").trigger('reset');
	            getProductList();     
	        },
	        error: function() {
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: 'Chỉnh sửa sản phẩm thành công'
		    	});
	        }
	    	});		
	});
	
	$("#product").on("click",".editProductImage",function(){
		var id = $(this).parent().siblings("td:first-child").text();
		 var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200){
		    	document.getElementById("editProductImageModalBox").innerHTML = this.responseText;
		    }
	
		  };
		  xhttp.open("GET", "editProductImage/"+id, true);
		  xhttp.send();
		  
	});
	
	
	$("#editProductImageModalBox").on("click","#deleteProductImage",function(){
		var x = $(this);
		var pID = $(this).parent().parent().siblings().find("input:first-child").val();
		var cID = $(this).siblings().find("#piColorID option:selected").val();
		var keyID = $(this).siblings("input:first-child").val();

		$.confirm({
		    title: 'Thông báo!',
		    content: 'Bạn chắc chắn xóa hình ảnh này không?',
		    buttons: {
		        'Tiếp tục': function () {
		        	$(x).parent().next('div').remove();
		    		$(x).parent().next('div').remove();
		    		$(x).parent().prev('hr').remove();
		    		$(x).parent().remove();
		    		
		    		var xhttp; 
		  		  
		  		  	xhttp = new XMLHttpRequest();
		  		  	xhttp.onreadystatechange = function() {
		  		    if (this.readyState == 4 && this.status == 200){
		  		    	var msg = this.responseText;
			        	$.alert({
				    	    title: 'Thông báo!',
				    	    content: msg
				    	});
		  		    }
		  	
		  		  	};
		  		  	xhttp.open("GET", "deleteProductImage/"+pID+"/"+cID+"/"+keyID, true);
		  		  	xhttp.send();
		  		  
		        },
		        'Hủy bỏ': function () {
		        }
		    }
		});
	});	
	
	
	$("#editProductImageModalBox").on("click","#editProductImageDetail",function(){
		var x = $(this);
		
		var pID = $(this).parent().parent().siblings().find("input:first-child").val();
		var cID = $(this).parent().siblings().find("#piColorID option:selected").val();
		var keyID = $(this).parent().siblings().find("input:first-child").val();
		var image = $(this).parent().siblings().find("input:nth-child(2)");
		var file = image[0].files[0];
		
		var formData = new FormData();	
		formData.append("pID",pID);
		formData.append("piColorID",cID);
		formData.append("piKeyID",keyID);
		
		if (!file){
			formData.append("piImage",new Blob([], {type : 'image/*'}));
			debugger;
		}else{
			formData.append("piImage",file);
		}	
		
		$.ajax({
	        url: "editProductImageDetail",
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

		        var id = pID;
		        debugger;
		   		 var xhttp; 
		   		  
		   		  xhttp = new XMLHttpRequest();
		   		  xhttp.onreadystatechange = function() {
		   		    if (this.readyState == 4 && this.status == 200){
		   		    	document.getElementById("editProductImageModalBox").innerHTML = this.responseText;
		   		    }
		   	
		   		  };
		   		  xhttp.open("GET", "editProductImage/"+id, true);
		   		  xhttp.send(); 
	        },
	        error: function(response) {
	        	$.alert({
		    	    title: 'Thông báo!',
		    	    content: response
		    	});
	        }
	    	});		
		
	});
	
	$("#sta-import").on("change","#sortImport",function(){
		getImportList();
	});
	
	$("#sta-import").on("change","#inputEndDateImport",function(){
		getImportList();
	});
	
	$("#sta-import").on("change","#inputFromDateImport",function(){
		getImportList();
	});

	$("#sta-import").on("click","#viewImportDetailList",function(){
		var id = $(this).parent().siblings("td:first-child").text();
	    debugger;
		  var xhttp; 
		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
			  document.getElementById("ImportDetailModalBox").innerHTML = this.responseText;
		    }
	
		  xhttp.open("GET", "viewListImportDetail/"+id, true);
		  xhttp.send();
	});
	
	$('#editProductImageModalBox').on('click','#btnAddColorItem',function(){
		
		var obj = $('#addColor').find('.colorItem').eq(0).html();
		debugger;
		obj = "<form class='colorItem' enctype='multipart/form-data' method='POST' >" + obj + "</form>";
		debugger;
		$('#addColor').append(obj);
	});
	
	
	$('#editProductImageModalBox').on('click','.removeItem',function(){
		var child = $("#addColor").children().length;
		debugger;
		if(child > 1){
			$(this).parent().parent().remove();
		}
		else{
			alert("Không thể xóa, Nhấn hủy để thoát");
		}
	});
	
	$('#editProductImageModalBox').on('click','#submitNewProductImage',function(){
		
		var pID = $(this).parent().parent().find("input:first-child").val();
		debugger;
		var ColorIDValues = $('#editProductImageModalBox').find('.colorItemID').map(function(idx, elem) {
		    return $(elem).val();
		  }).get();
	  
	  var ImageItems = $('#editProductImageModalBox').find('.imageItem').map(function(idx, elem) {
		    return $(elem).val();
		  }).get();
	  
		if(hasNoneImg(ImageItems)){
			$.alert({
	    	    title: 'Thông báo!',
	    	    content: 'Chưa chọn hình ảnh'
	    	});
		  }
		else if(checkColorChosen(ColorIDValues)){
			$.alert({
	    	    title: 'Thông báo!',
	    	    content: 'Chưa chọn màu tương ứng'
	    	});
		}
		else if(hasDuplicates1(ColorIDValues)){
			$.alert({
	    	    title: 'Thông báo!',
	    	    content: 'Đã chọn trùng màu'
	    	});
		}
		else{
			$('#prID').val(pID);
			
			var items = $("#addColor").children();
			var fl = true;
			items.each(function(){
				
				 var formData = new FormData($(this)[0]);
				 debugger;
				    $.ajax({
				    	async: false,
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
				var id = pID;
				debugger;
		   		 var xhttp; 
		   		  
		   		  xhttp = new XMLHttpRequest();
		   		  xhttp.onreadystatechange = function() {
		   		    if (this.readyState == 4 && this.status == 200){
		   		    	document.getElementById("editProductImageModalBox").innerHTML = this.responseText;
		   		    	debugger;
		   		    }
		   	
		   		  };
		   		  xhttp.open("GET", "editProductImage/"+id, true);
		   		  xhttp.send();
			}else{
				$.alert({
		    	    title: 'Thông báo!',
		    	    content: 'Có lỗi khi thêm hình ảnh theo màu, kiểm tra lại thông tin nhập!'
		    	});
			}
			 
		  }
	});
	
	$("#discount #slbPromotionState").change(function(){
		getPromotion();
	});
	
	$("#inputFromDatePromotion").keyup(function(){
		getPromotion();
	});
	
	$("#inputEndDatePromotion").keyup(function(){
		getPromotion();
	});
	
	$("#inputFromDatePromotion").change(function(){
		getPromotion();
	});
	
	$("#inputEndDatePromotion").change(function(){
		getPromotion();
	});
	
	$("#slbSearchUpdatePrice").change(function(){
		getProductPriceList();
	});
	
	$("#inputSearchUpdatePrice").keyup(function(){
		getProductPriceList();
	});
	
	$("#slbStaffSearch").change(function(){
		getStaffList();
	});
	
	$("#slbStaffTypeSort").change(function(){
		getStaffList();
	});
	
	$("#inputStaffSearch").keyup(function(){
		getStaffList();
	});
	  
	  $("#slbMaterialSort").change(function(){
			getProductList();
		});
	  
	  $("#slbProducerSort").change(function(){
			getProductList();
		});
	  
	  $("#slbProductTypeSearch").change(function(){
			getProductList();
		});
	  
	  $("#slbProductSearch").change(function(){
			getProductList();
		});
	  
	  $("#inputProductSearch").keyup(function(){
			getProductList();
		});
	  

	  function EventSettings(){
		  $("#btnChangeBanner").click(function(){
			  $(".bannerWrapper").slideToggle(1000);

		  });
	  }


	  function LoadSettings(){

		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
			  if (this.readyState == 4 && this.status == 200){
				  document.getElementById("settings").innerHTML = this.responseText;
				  EventSettings();
			  }

		  };
		  xhttp.open("GET", "/VerOne/getsettings", true);
		  xhttp.send();

	  }

	  LoadSettings();




	  $("#settings").on('click','.btnEditFeature', function(){
		  var input = $(this).parent().siblings('div').eq(0).find('input');
		  var txt = $(this).text();

		  if(txt == "Sửa"){
			  input.eq(1).prop('readonly', false);
			  $(this).text('Cập nhật');
		  }
		  else{

			  var ID = input.eq(0).val();
			  var value = input.eq(1).val();

			  xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
				  if (this.readyState == 4 && this.status == 200){
					  var msg = this.responseText;
			        	$.alert({
				    	    title: 'Thông báo!',
				    	    content: msg
				    	});
					  if(this.responseText == "Cập nhật thành công"){
						  LoadSettings();
					  }
				  }

			  };
			  xhttp.open("GET", "/VerOne/updatefeature/"+ID+"/"+value, true);
			  xhttp.send();

		  }
	  });

	  $("#settings").on('click','.btnEditBanner', function(){

		  var formData = new FormData($(this).parent()[0]);

		  var input = $(this).parent().find('input'); 

		  var length123 = input.eq(1).get(0).files.length;

		  if( length123 == 0 ){
			  $.alert({
		    	    title: 'Thông báo!',
		    	    content: 'Bạn chưa chọn hình'
		    	});
		  }
		  else{

			  $.ajax({
				  async: true,
				  url: "updatebanner",
				  type: "POST",
				  dataType: 'text',
				  contentType: false,
				  processData: false,
				  cache: false,
				  data: formData,
				  success: function(response) {
					  LoadSettings();
					  var msg = response;
			        	$.alert({
				    	    title: 'Thông báo!',
				    	    content: msg
				    	});    	
					  $(".bannerWrapper").show();

				  },
				  error: function() {
					  var msg = response;
			        	$.alert({
				    	    title: 'Thông báo!',
				    	    content: msg
				    	});
				  }
			  });
		  }

	  });


	  // Color Pagination
	  $("#color").on('click','.pageColorItem',function(){
		  var page = $(this).find('a').eq(0).text();			
		  filterColorList(page);
	  });

	  $("#color").on('click','.nextColor',function(){
		  var temp = $(this).siblings(".active").eq(0).find('a').eq(0).text();			
		  var pageNums = $("#pageColorNums").val();			
		  var page = parseInt(temp) + 1;			
		  if(page <= parseInt(pageNums))
			  filterColorList(page);			
	  });

	  $("#color").on('click','.prevColor',function(){
		  var temp = $(this).siblings(".active").eq(0).find('a').eq(0).text();			
		  var page = parseInt(temp) - 1;			
		  if(page > 0)
			  filterColorList(page);			
	  });

	  $("#slbColorSearch").change(function(){
		  getColorList();
	  });

	  $("#inputColorSearch").keyup(function(){
		  getColorList();
	  });

	  LoadDate();
	  setTimeout(function(){
		  LoadLogs();
	  },500);
	  
	  //Product Pagination
	  
		$("#loadProductList").on('click','.pageProductItem',function(){
			var page = $(this).find('a').eq(0).text();
			
			getProductListByPage(page);
			
		});
		
		$("#loadProductList").on('click','.nextProduct',function(){
			var temp = $(this).siblings(".active").eq(0).find('a').eq(0).text();
			
			var pageNums = $("#pageProductNums").val();
			
			var page = parseInt(temp) + 1;
			
			if(page <= parseInt(pageNums))
				getProductListByPage(page);
			
		});
		
		$("#loadProductList").on('click','.prevProduct',function(){
			var temp = $(this).siblings(".active").eq(0).find('a').eq(0).text();
			
			var page = parseInt(temp) - 1;
			
			if(page > 0)
				getProductListByPage(page);
			
		});
		
		$("#startDayLog, #endDayLog").change(function(){
			LoadLogs();
		});
		
		$("#inputSearchLog").keyup(function(){
			LoadLogs();
		});
		
		setInterval(function(){
			LoadLogs();
		},5000);
		
		var now = new Date();
		
		var today = now.getFullYear()+"-"+(now.getMonth()+1)+"-" + now.getDate();
		var startday = now.getFullYear()+"-"+(now.getMonth()+1)+"-01";

		$("#inputFromDateImport").val(startday);
		$("#inputEndDateImport").val(today);
});







