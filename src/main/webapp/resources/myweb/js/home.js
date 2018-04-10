function LoadPage(){
	fixedNav();
}

function Resize(){
	fixedNav();
}

function fixedNav()
{
	var height = document.getElementsByClassName('headerWrap')[0].offsetHeight;

	height -= 15;
	document.getElementsByClassName('home')[0].setAttribute("style","margin-top:" + height + "px");
}