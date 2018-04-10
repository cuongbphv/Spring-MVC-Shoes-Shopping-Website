
function LoadPage(){
	fixedNav();
}


function Resize(){
	fixedNav();
}

function fixedNav()
{
	var height = document.getElementsByClassName('headerWrap')[0].offsetHeight;

	height-=10;
	document.getElementsByClassName('spCustomer')[0].setAttribute("style","margin-top:" + height + "px");
}
