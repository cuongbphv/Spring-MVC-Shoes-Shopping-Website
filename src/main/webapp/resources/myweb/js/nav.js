function getItemsNumber(){
	  var xhttp; 
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    document.getElementById("numItems").innerHTML = "(" + this.responseText + ")";
	    }
	  };
	  xhttp.open("GET", "/VerOne/numItemOrdered", true);
	  xhttp.send();
}



$(document).ready(function() {
	getItemsNumber();
});

function showNav(){
	var state = document.getElementsByClassName('navi')[0];
	if(state.style.display == 'none')
		state.style.display = 'block';
	else
		state.style.display = 'none';
}


