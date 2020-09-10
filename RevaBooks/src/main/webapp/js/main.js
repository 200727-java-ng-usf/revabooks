const APP_VIEW = document.getElementById('app-view');

window.onload = function(){ //function w/out a name = anon function
	loadLogin();
//	loadRegister();
	document.getElementById('toLogin').addEventListener('click', loadLogin);
	document.getElementById('toRegister').addEventListener('click', loadRegister);
	document.getElementById('toHome').addEventListener('click', loadHome);
	document.getElementById('toLogout').addEventListener('click', loadLogout);
}

//region loaders

function loadPage(page){
	console.log(page);
	let xhr = new XMLHttpRequest;
	// xhr.responseType();
	xhr.open("GET", page, true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			// console.log('response received');
			APP_VIEW.innerHTML = xhr.responseText;
		}
	}
}

function loadLogin(){
	console.log('in loadLogin()');
	let xhr = new XMLHttpRequest;
	// xhr.responseType();
	xhr.open("GET", "login.view", true); // third parameter of this method is optional (defaults to true)
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			// console.log('response received');
			APP_VIEW.innerHTML = xhr.responseText;
			configureLoginView();
		}
	}
}

function loadRegister(){
	console.log('in loadRegister()');
	let xhr = new XMLHttpRequest;
	// xhr.responseType();
	xhr.open("GET", "register.view"); // third parameter of this method is optional (defaults to true)
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			// console.log('response received');
			APP_VIEW.innerHTML = xhr.responseText;
			configureRegisterView();
		}
	}
}

function loadHome(){
	console.log('in loadHome()');
	let xhr = new XMLHttpRequest;
	// xhr.responseType();
	xhr.open("GET", "home.view", true); // third parameter of this method is optional (defaults to true)
	xhr.send(); 
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			// console.log('response received');
			APP_VIEW.innerHTML = xhr.responseText;
		}
	}
}

function loadLogout(){
	console.log('in loadLogout()');
	let xhr = new XMLHttpRequest;
	// xhr.responseType();
	xhr.open("GET", "logout.view", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			// console.log('response received');
			APP_VIEW.innerHTML = xhr.responseText;
		}
	}
}

//endregion

// #region configurators

function configureLoginView(){
	console.log('in configureLoginView');

	document.getElementById('login-message').setAttribute('hidden', true);
	document.getElementById('login').addEventListener('click', login);
}

function configureRegisterView(){
	console.log('in configureLoginView');

	document.getElementById('reg-message').setAttribute('hidden', true);
	document.getElementById('register').addEventListener('click', register);
}

//endregion

//region operations

function login(){
	console.log('in login()');

	let un = document.getElementById('login-username').value;
	let pw = document.getElementById('login-password').value;

	let credentials = {
		username: un,
		password: pw
	}

	let credentialsJSON = JSON.stringify(credentials);

	let xhr = new XMLHttpRequest;
	xhr.open('POST', 'auth');
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(credentialsJSON);

	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 204){

			console.log('login successful!');
			document.getElementById('login-message').setAttribute('hidden', true);

		} else if (xhr.readyState == 4 && xhr.status == 401){

			document.getElementById('login-message').removeAttribute('hidden');
			let err = JSON.parse(xhr.responseText);
			document.getElementById('login-message').innerText = err.message;

		}
	}

}

function register(){
	console.log('in register()');

	let fn = document.getElementById('fn').value;
	let ln = document.getElementById('ln').value;
	let em = document.getElementById('email').value;
	let un = document.getElementById('reg-username').value;
	let pw = document.getElementById('reg-password').value;

	let credentials = {
		email:em,
		firstName:fn,
		lastName:ln,
		username: un,
		password: pw
	}

	let credentialsJSON = JSON.stringify(credentials);

	let xhr = new XMLHttpRequest;
	xhr.open('POST', 'users');
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(credentialsJSON);

	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 201){

			let msg = JSON.parse(xhr.responseText);
			console.log(msg);
			// document.getElementById('reg-message').innerText = msg;
			document.getElementById('reg-message').setAttribute('hidden', true);

		} else if (xhr.readyState == 4 && xhr.status == 400){

			document.getElementById('reg-message').removeAttribute('hidden');
			let err = JSON.parse(xhr.responseText);
			document.getElementById('reg-message').innerText = err.message;

		}
	}
}

//endregion