const APP_VIEW = document.getElementById('app-view');

window.onload = function () {

    loadLogin();

}

    //document.getElementById("registerViewId").addEventListener("mouseover", changeColor("registerViewId"));
    //document.getElementById("homeViewId").addEventListener("mouseover", changeColor("Id"));

function loadLogin() {

    console.log('in loadLogin()');

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'login.view', true);
    xhr.send();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
        }
    }



}
function loadRegister() {
    console.log('in loadRegister()');

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'register.view', true);
    xhr.send();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
        }
    }
}
function loadHome() {
    console.log('in loadHome()');

    xhr.open('GET', 'home.view', true);
    xhr.send();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
        }
    }
    
}

