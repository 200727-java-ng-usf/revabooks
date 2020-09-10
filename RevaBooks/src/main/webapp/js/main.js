const APP_VIEW = document.getElementById('app-view');

window.onload = function(){ //function w/out a name = anon function
//	loadLogin();
	loadRegister();
}

function loadLogin(){
	console.log('in loadLogin()');
	let xhr = new XMLHttpRequest;
	// xhr.responseType();
	xhr.open("GET", "login.view", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			// console.log('response received');
			APP_VIEW.innerHTML = xhr.responseText;
		}
	}
}

function loadRegister(){
	console.log('in loadRegister()');
	let xhr = new XMLHttpRequest;
	// xhr.responseType();
	xhr.open("GET", "register.view", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			// console.log('response received');
			APP_VIEW.innerHTML = xhr.responseText;
		}
	}
}