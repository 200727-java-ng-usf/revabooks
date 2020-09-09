const APP_VIEW = document.getElementById('app-view');

window.onload = function(){ //function w/out a name = anon function
	loadLogin();
}

function loadLogin(){

	console.log('in loadLogin()');

	let xhr = new XMLHttpRequest;
	// xhr.responseType();
	xhr.open("GET", "login.view", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		// 		// Ajax Ready States
		// 		//0:UNSENT
		// 		//1:OPENED
		// 		//2:HEADERS_RECEIVED
		// 		//3:LOADING
		// 		//4:DONE
		if(xhr.readyState == 4 && xhr.status == 200){
			// console.log('response received');
			APP_VIEW.innerHTML = xhr.responseText;
		}
	}
}