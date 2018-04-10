function statisticByID(id){
	if (id == 0)
		getStatisticRevenueThisMonth(id);
	else if (id == 1)
		getStatisticRevenueEachMonth(id);
	else if (id == 2)
		getStatisticRevenueEachYear(id);
	else if (id == 3)
		getStatisticSalesOfSale(id);
}

function firstLoad(){
	var now = new Date();
	var month = (now.getMonth() + 1);
	var year = now.getFullYear();
	
	$("#statisticMonth").val(month);
	$("#statisticYear").val(year);
	debugger;
}

function getStatisticRevenueThisMonth(id){
	
	var m = $("#statisticMonth").val();
	var y = $("#statisticYear").val();
	
	debugger;
	
	var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	    	
	    	var labels = []; // tên cột biểu đồ
	    	
	    	var dataSet = []; // dữ liệu cột
	    	    
	    	var backgroundColorChart = []; // màu nền
	    	
	    	var borderColorChart = []; // màu viền từng cột
	    	
	    	var str = this.responseText;
	    	var myObject = eval('(' + str + ')');
	    	for (i in myObject)
	    	{
	    	   labels.push("N" + myObject[i]["sDay"]);
	    	   dataSet.push(myObject[i]["income"]);
	    	   //backgroundColorChart.push("");
	    	   //borderColorChart("'rgba(180, 77, 132, 1)'");
	    	   debugger;
	    	}
	    	
	    
	    	var ctx = document.getElementById("myChart").getContext('2d');
			var myChart = new Chart(ctx, {
				type : 'line', // các loại bar, line, pie
				data : {
					labels : labels,
					datasets : [ {
						label : 'Thống kê doanh thu tháng '+$("#statisticMonth").val(),
						data : dataSet,
						backgroundColor : ['rgba(180, 77, 132, 0.2)'],
						borderColor : ['rgba(180, 77, 132, 1)'],
						borderWidth : 1
					} ]
				},
				options : {
					scales : {
						yAxes : [ {
							ticks : {
								beginAtZero : true
							}
						} ]
					}
				}
			});
			
	    }
	  };
	  xhttp.open("GET", "statisticRevenueByMonthYear/"+id+"/"+m+"/"+y, true);
	  xhttp.send();
}

function getStatisticSalesOfSale(id) {
	
	var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	    	
	    	var labels = []; // tên cột biểu đồ
	    	
	    	var dataSet = []; // dữ liệu cột
	            
	    	var backgroundColorChart = [
				'rgba(70,250,144, 0.2)',
				'rgba(70,250,144, 0.2)',
				'rgba(70,250,144, 0.2)',
				'rgba(70,250,144, 0.2)',
				'rgba(70,250,144, 0.2)',
				'rgba(70,250,144, 0.2)',
				'rgba(70,250,144, 0.2)',
				'rgba(70,250,144, 0.2)',
				'rgba(70,250,144, 0.2)',
				'rgba(70,250,144, 0.2)',
				]; // màu nền
	    	
	    	var borderColorChart = [ 
	    		'rgba(70,250,144, 1)',
	    		'rgba(70,250,144, 1)',
	    		'rgba(70,250,144, 1)',
	    		'rgba(70,250,144, 1)',
	    		'rgba(70,250,144, 1)',
	    		'rgba(70,250,144, 1)',
	    		'rgba(70,250,144, 1)',
	    		'rgba(70,250,144, 1)',
	    		'rgba(70,250,144, 1)',
	    		'rgba(70,250,144, 1)',
				]; // màu viền từng cột
	    	
	    	var str = this.responseText;
	    	var myObject = eval('(' + str + ')');
	    	for (i in myObject)
	    	{
	    	   labels.push(myObject[i]["productName"]);
	    	   dataSet.push(myObject[i]["quantity"]);
	    	}
	    	
	    
	    	var ctx = document.getElementById("myChart").getContext('2d');
			var myChart = new Chart(ctx, {
				type : 'bar', // các loại bar, line, pie
				data : {
					labels : labels,
					datasets : [ {
						label : '10 sản phẩm bán chạy nhất cửa hàng ( màu và kích cỡ )',
						data : dataSet,
						backgroundColor : backgroundColorChart,
						borderColor : borderColorChart,
						borderWidth : 1
					} ]
				},
				options : {
					scales : {
						yAxes : [ {
							ticks : {
								beginAtZero : true,
							}
						} ],
						xAxes: [{
					        ticks: {	
					            autoSkip: false
					        }
					    }]
					}
				}
			});
			
	    }
	  };
	  xhttp.open("GET", "statisticRevenue/"+id, true);
	  xhttp.send();	    	

}

function getStatisticRevenueEachMonth(id) {
	
	var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	    	
	    	var labels = []; // tên cột biểu đồ
	    	
	    	var dataSet = []; // dữ liệu cột
	            
	    	var backgroundColorChart = [
				'rgba(180, 77, 132, 0.2)',
				'rgba(180, 77, 132, 0.2)',
				'rgba(180, 77, 132, 0.2)',
				'rgba(180, 77, 132, 0.2)',
				'rgba(180, 77, 132, 0.2)',
				'rgba(180, 77, 132, 0.2)',
				'rgba(180, 77, 132, 0.2)',
				'rgba(180, 77, 132, 0.2)',
				'rgba(180, 77, 132, 0.2)',
				'rgba(180, 77, 132, 0.2)',
				'rgba(180, 77, 132, 0.2)',
				'rgba(180, 77, 132, 0.2)'
				]; // màu nền
	    	
	    	var borderColorChart = [ 
	    		'rgba(180, 77, 132, 1)',
	    		'rgba(180, 77, 132, 1)',
	    		'rgba(180, 77, 132, 1)',
	    		'rgba(180, 77, 132, 1)',
	    		'rgba(180, 77, 132, 1)',
	    		'rgba(180, 77, 132, 1)',
	    		'rgba(180, 77, 132, 1)',
	    		'rgba(180, 77, 132, 1)',
	    		'rgba(180, 77, 132, 1)',
	    		'rgba(180, 77, 132, 1)',
	    		'rgba(180, 77, 132, 1)',
	    		'rgba(180, 77, 132, 1)'
				]; // màu viền từng cột
	    	
	    	var str = this.responseText;
	    	var myObject = eval('(' + str + ')');
	    	for (i in myObject)
	    	{
	    	   labels.push(myObject[i]["sMonth"] + "/" + myObject[i]["sYear"]);
	    	   dataSet.push(myObject[i]["income"]);
	    	}
	    	
	    	var now = new Date();
	    
	    	var ctx = document.getElementById("myChart").getContext('2d');
			var myChart = new Chart(ctx, {
				type : 'bar', // các loại bar, line, pie
				data : {
					labels : labels,
					datasets : [ {
						label : 'Màu theo từng tháng năm '+ now.getFullYear(),
						data : dataSet,
						backgroundColor : backgroundColorChart,
						borderColor : borderColorChart,
						borderWidth : 1
					} ]
				},
				options : {
					scales : {
						yAxes : [ {
							ticks : {
								beginAtZero : true
							}
						} ]
					}
				}
			});
			
	    }
	  };
	  xhttp.open("GET", "statisticRevenue/"+id, true);
	  xhttp.send();	    	

}

function getStatisticRevenueEachYear(id) {
	
	var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	    	
	    	var labels = []; // tên cột biểu đồ
	    	
	    	var dataSet = []; // dữ liệu cột
	    	
	    	var randomScalingFactor = function() {
	            return Math.round(Math.random() * 100)}; // random độ của vòng tròn 
	            
	    	var backgroundColorChart = [
				'rgba(180, 77, 132, 0.2)',
				'rgba(54, 162, 235, 0.2)',
				'rgba(200, 206, 86, 0.2)',
				'rgba(75, 192, 192, 0.2)',
				'rgba(153, 102, 255, 0.2)',
				'rgba(255, 159, 64, 0.2)',
				'rgba(80, 222, 140, 0.2)',
				'rgba(30, 30, 227, 0.2)',
				'rgba(230, 170, 60, 0.2)',
				'rgba(70, 255, 255, 0.2)',
				'rgba(160, 180, 219, 0.2)',
				'rgba(44, 245, 90, 0.2)'
				]; // màu nền
	    	
	    	var borderColorChart = [ 
	    		'rgba(180, 77, 132, 1)',
				'rgba(54, 162, 235, 1)',
				'rgba(200, 206, 86, 1)',
				'rgba(75, 192, 192, 1)',
				'rgba(153, 102, 255, 1)',
				'rgba(255, 159, 64, 1)',
				'rgba(80, 222, 140, 1)',
				'rgba(30, 30, 227, 1)',
				'rgba(230, 170, 60, 1)',
				'rgba(70, 255, 255, 1)',
				'rgba(160, 180, 219, 1)',
				'rgba(44, 245, 90, 1)'
				]; // màu viền từng cột
	    	
	    	var str = this.responseText;
	    	var myObject = eval('(' + str + ')');
	    	for (i in myObject)
	    	{
	    	   labels.push("Năm " + myObject[i]["sYear"]);
	    	   dataSet.push(myObject[i]["income"]);
	    	}
	    	
	    
	    	var ctx = document.getElementById("myChart").getContext('2d');
			var myChart = new Chart(ctx, {
				type : 'line', // các loại bar, line, pie
				data : {
					labels : labels,
					datasets : [ {
						label : 'Màu theo từng năm ',
						data : dataSet,
						backgroundColor : backgroundColorChart,
						borderColor : borderColorChart,
						borderWidth : 1
					} ]
				},
				options : {
					scales : {
						yAxes : [ {
							ticks : {
								beginAtZero : true
							}
						} ]
					}
				}
			});
			
	    }
	  };
	  xhttp.open("GET", "statisticRevenue/"+id, true);
	  xhttp.send();	    	

}

$(document).ready(function() {
    $("#slbStatisticRevenue").change(function(){
    	var id = $("#slbStatisticRevenue").val();
    	
    	if(id == 0)
    		$("#loadMonthYear").show();
    	else
    		$("#loadMonthYear").hide();
    	$('#myChart').remove(); // this is my <canvas> element
    	$('.chartjs-size-monitor').remove();
    	$('#reloadCanvas').append('<canvas id="myChart" width="600" height="300"></canvas>');
    	statisticByID(id);
    });
    
    $("#statisticMonth").change(function(){
    	var id = $("#slbStatisticRevenue").val();
    	
    	if(id == 0){  		
    		$("#loadMonthYear").show();
    	}
    	else
    		$("#loadMonthYear").hide();
    	$('#myChart').remove(); // this is my <canvas> element
    	$('.chartjs-size-monitor').remove();
    	$('#reloadCanvas').append('<canvas id="myChart" width="600" height="300"></canvas>');
    	statisticByID(id);
    });
    
});