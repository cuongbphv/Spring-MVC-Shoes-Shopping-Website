
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
	document.getElementsByClassName('spStaff')[0].setAttribute("style","margin-top:" + height + "px");
}
