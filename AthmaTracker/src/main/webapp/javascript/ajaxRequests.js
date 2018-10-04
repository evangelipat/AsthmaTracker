/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function sendAjaxPostLogin() {
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
        } else {
            document.getElementById('ajaxContent').innerHTML = xhr.responseText;
            alert('Request failed. Returned status of ' + xhr.status + xhr.responseText);
            alert();
        }
    };

    xhr.open('POST', 'LoginServlet');
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send('email=' + email + '&password=' + password);

}
