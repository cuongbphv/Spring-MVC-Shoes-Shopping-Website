function LoadPage(){
	fixedNav();
	setTimeout(function(){
		showInfo();
	},200)
	
}

function Resize(){
	fixedNav();
}

function fixedNav()
{
	var height = document.getElementsByClassName('headerWrap')[0].offsetHeight;

	height += 10;
	document.getElementsByClassName('aboutWrap')[0].setAttribute("style","margin-top:" + height + "px");
}


function showInfo(){
	var slogan = document.getElementsByClassName('aboutWrap')[0];
	slogan.style.paddingTop = '10px';
	slogan.style.opacity = '1';
}