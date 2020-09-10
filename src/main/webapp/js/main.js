const APP_VIEW = document.getElementById('app-view');

window.onload = function() {
    loadLogin();
    document.getElementById('toLogin').addEventListener('click', loadLogin);
    document.getElementById('toRegister').addEventListener('click', loadRegister);
}

//----------------------LOAD VIEWS-------------------------

function loadLogin() {

    console.log('in loadLogin()');

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'login.view', true); // third parameter (default true) indicates we want to make this req async
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
            configureLoginView();
        }
    }

}

function loadRegister() {

    console.log('in loadRegister()');

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'register.view'); // third parameter of this method is optional (defaults to true)
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
        }
    }

}

//----------------CONFIGURE VIEWS--------------------

function configureLoginView() {

    console.log('in configureLoginView()');

    document.getElementById('login-message').setAttribute('hidden', true);
    document.getElementById('login').addEventListener('click', login);

}

//------------------OPERATIONS-----------------------

function login() {

    console.log('in login()');

    let un = document.getElementById('login-username').value;
    let pw = document.getElementById('login-password').value;

    let credentials = {
        username: un,
        password: pw
    }

    let credentialsJSON = JSON.stringify(credentials);

    let xhr = new XMLHttpRequest();

    xhr.open('POST', 'auth');
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(credentialsJSON);

    xhr.onreadystatechange = function () {

        console.log(xhr.readyState);

        if (xhr.readyState == 4 && xhr.status == 204) {

            document.getElementById('login-message').setAttribute('hidden', true);
            console.log('login successful!');

        } else if (xhr.readyState == 4 && xhr.status == 401) {

            document.getElementById('login-message').removeAttribute('hidden');
            let err = JSON.parse(xhr.responseText);
            document.getElementById('login-message').innerText = err.message;

        }

    }

}