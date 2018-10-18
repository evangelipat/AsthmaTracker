/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function aboutAsthmaPages(action) {

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('active')
                    .innerHTML = xhr.responseText;
        } else if (xhr.status !== 200) {
            document.getElementById('active')
                    .innerHTML = xhr.responseText;
        }
    };
    xhr.open('POST', 'AboutAsthmaServlet');
    xhr.setRequestHeader('Content-type',
            'application/x-www-form-urlencoded');

    xhr.send('action=' + action);
}


function motivationPages(action) {

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('active')
                    .innerHTML = xhr.responseText;
        } else if (xhr.status !== 200) {
            document.getElementById('active')
                    .innerHTML = xhr.responseText;
        }
    };
    xhr.open('POST', 'MotivationServlet');
    xhr.setRequestHeader('Content-type',
            'application/x-www-form-urlencoded');

    xhr.send('action=' + action);
}