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
	document.getElementsByClassName('wrapper')[0].setAttribute("style","margin-top:" + height + "px");
}

function checkpass() {
    if (document.getElementById('password').value ==
            document.getElementById('confirm_password').value) {
        document.getElementById('submit').disabled = false;
    } else {
        document.getElementById('submit').disabled = true;
    }
}
