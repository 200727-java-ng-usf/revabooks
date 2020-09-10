
const APP_VIEW = document.getElementById('app-view');

window.onload = function() {
    loadlogin();

}

function loadlogin(){

    console.log('in loadLogin()');

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200){
        //console.log('response received');
        APP_VIEW.innerHTML = xhr.responseText;
        }
    }

    xhr.open('GET', 'login.view', true);
    xhr.send();


}